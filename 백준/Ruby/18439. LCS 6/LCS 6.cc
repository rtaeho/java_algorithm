#include <cstdio>
#include <cstdint>
#include <cstring>

// 50000 비트 → 782 longs
static const int MAX_W = 782;

static char A[50005];
static char B[50005];

static uint64_t Match[26][MAX_W];
static uint64_t S[MAX_W];
static uint64_t T[MAX_W];

int main() {
    if (scanf("%s %s", A, B) != 2) return 0;

    int N = (int) strlen(A);
    int M = (int) strlen(B);
    int W = (M + 63) >> 6;

    // Match[c][k] 구성
    for (int j = 0; j < M; j++) {
        int c = B[j] - 'A';
        Match[c][j >> 6] |= (uint64_t) 1 << (j & 63);
    }

    // 비트 병렬 LCS (Hyyrö)
    for (int i = 0; i < N; i++) {
        const uint64_t* Mc = Match[A[i] - 'A'];

        // T = (S << 1) | 1  (multi-word shift carry)
        // S = Match | S      (in-place로 X 저장)
        uint64_t shiftCarry = 1ULL;
        for (int k = 0; k < W; k++) {
            uint64_t Sk = S[k];
            T[k] = (Sk << 1) | shiftCarry;
            shiftCarry = Sk >> 63;
            S[k] = Mc[k] | Sk;
        }

        // D = X - T (multi-word subtract with borrow), T에 저장
        uint64_t borrow = 0;
        for (int k = 0; k < W; k++) {
            uint64_t Xk = S[k];
            uint64_t Tk = T[k];
            uint64_t diff = Xk - Tk - borrow;
            // borrow 발생 조건 (unsigned 비교)
            if (borrow == 0) {
                borrow = (Xk < Tk) ? 1 : 0;
            } else {
                borrow = (Xk <= Tk) ? 1 : 0;
            }
            T[k] = diff;
        }

        // S = X & ~D
        for (int k = 0; k < W; k++) {
            S[k] &= ~T[k];
        }
    }

    int ans = 0;
    for (int k = 0; k < W; k++) {
        ans += __builtin_popcountll(S[k]);
    }

    printf("%d\n", ans);
    return 0;
}
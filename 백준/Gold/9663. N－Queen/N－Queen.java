/*
문제
N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (1 ≤ N < 15)

출력
첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.

예제 입력 1 
8
예제 출력 1 
92
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int count = 0;
    static boolean[] col; // 열 체크
    static boolean[] diag1; // 대각선 체크 (좌상에서 우하)
    static boolean[] diag2; // 대각선 체크 (우상에서 좌하)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        col = new boolean[N]; // 열 체크 배열 초기화
        diag1 = new boolean[2 * N]; // 대각선 체크 배열 초기화
        diag2 = new boolean[2 * N]; // 대각선 체크 배열 초기화

        solve(0); // 첫 번째 행에서 시작
        System.out.println(count);
    }

    public static void solve(int row) {
        if (row == N) {
            count++; // 모든 퀸을 배치한 경우
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!col[i] && !diag1[row - i + N] && !diag2[row + i]) {
                // 퀸을 놓을 수 있는 위치
                col[i] = true; // 열 체크
                diag1[row - i + N] = true; // 대각선 체크 (좌상에서 우하)
                diag2[row + i] = true; // 대각선 체크 (우상에서 좌하)

                solve(row + 1); // 다음 행으로 이동

                // 원래 상태로 되돌리기
                col[i] = false;
                diag1[row - i + N] = false;
                diag2[row + i] = false;
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 2N 배열 + 누적합 (1-indexed)
        long[] dp = new long[2 * N + 1];
        for (int i = 1; i <= N; i++) {
            int v = Integer.parseInt(st.nextToken());
            dp[i] = v;
            dp[i + N] = v;
        }
        for (int i = 1; i <= 2 * N; i++) {
            dp[i] += dp[i - 1];
        }

        // 각 시작점 i (1..N)에서 길이 N 윈도우의 합 = T (전체합, 양수 보장)
        long T = dp[N];

        long ret = 0;
        for (int i = 1; i <= N; i++) {
            long base = dp[i - 1];
            for (int j = i; j < N + i; j++) {
                long ps = dp[j] - base; // 시작점 i부터 j까지의 누적합
                if (ps >= 0)
                    continue;
                long neg = -ps;
                // ceil(neg / T) — neg, T 둘 다 양수
                ret += (neg + T - 1) / T;
            }
        }

        System.out.println(ret);
    }
}
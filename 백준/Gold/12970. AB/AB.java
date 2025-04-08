import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // A 개수 a를 0부터 N까지 시도
        for (int a = 0; a <= N; a++) {
            int b = N - a;

            // A와 B로 만들 수 있는 최대 쌍 수는 a * b
            if (a * b < K) continue;

            // B를 먼저 배치하고, A를 어디에 넣을지 정한다
            int[] A = new int[b + 1];  // A[i]: i번째 B 뒤에 놓을 A의 수

            for (int i = 0; i < a; i++) {
                // 오른쪽부터 최대한 B 뒤에 넣기
                int idx = Math.min(K, b);
                A[idx]++;
                K -= idx;
            }

            // 출력 (B를 기준으로 A를 왼쪽에 붙이는 방식)
            StringBuilder sb = new StringBuilder();
            for (int i = b; i >= 0; i--) {
                for (int j = 0; j < A[i]; j++) {
                    sb.append("A");
                }
                if (i > 0) sb.append("B");
            }

            System.out.println(sb);
            return;
        }

        // 만들 수 없는 경우
        System.out.println("-1");
    }
}
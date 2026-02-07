import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int TEST_CASE = 0; TEST_CASE < T; TEST_CASE++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(dfs()).append("\n");
        }
        System.out.println(sb);
    }

    static int dfs() {
        int cnt = 0;
        boolean[] visited = new boolean[arr.length];
        for (int i = 1; i < arr.length; i++) {
            if (!visited[i]) {
                cnt++;
                int cur = i;
                while (!visited[cur]) {
                    visited[cur] = true;
                    cur = arr[cur];
                }
            }
        }
        return cnt;
    }
}
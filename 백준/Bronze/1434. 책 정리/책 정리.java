import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long sumA = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sumA += Integer.parseInt(st.nextToken());
        }

        long sumB = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            sumB += Integer.parseInt(st.nextToken());
        }

        System.out.println(sumA - sumB);
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 결과값 초기화 (a의 일의 자리부터 시작)
            int result = 1;
            
            // b번 거듭제곱하며 일의 자리만 남김
            for (int i = 0; i < b; i++) {
                result = (result * a) % 10;
            }

            // 결과가 0이면 10번 컴퓨터, 아니면 결과값 그대로
            if (result == 0) {
                sb.append(10).append("\n");
            } else {
                sb.append(result).append("\n");
            }
        }
        System.out.print(sb);
    }
}
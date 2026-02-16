import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine()); // 행성계 개수
            int count = 0;

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                // 출발점과 행성 중심 사이의 거리 제곱
                boolean startInside = Math.pow(x1 - cx, 2) + Math.pow(y1 - cy, 2) < Math.pow(r, 2);
                // 도착점과 행성 중심 사이의 거리 제곱
                boolean endInside = Math.pow(x2 - cx, 2) + Math.pow(y2 - cy, 2) < Math.pow(r, 2);

                // 둘 중 하나만 원 안에 있을 때 (XOR 조건)
                if (startInside != endInside) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
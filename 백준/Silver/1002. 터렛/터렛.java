import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            sb.append(solve(x1, y1, r1, x2, y2, r2)).append('\n');
        }
        System.out.println(sb);
    }

    private static int solve(int x1, int y1, int r1, int x2, int y2, int r2) {
        // 거리의 제곱 계산 (오차 방지)
        int distancePow = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        // 1. 두 원의 중심이 같은 경우
        if (x1 == x2 && y1 == y2) {
            if (r1 == r2) return -1; // 완전히 일치 (무한대)
            else return 0; // 중심은 같으나 반지름이 다름 (동심원)
        }

        // 2. 외접하거나 내접하는 경우 (교점 1개)
        if (distancePow == Math.pow(r1 + r2, 2)) return 1; // 외접
        if (distancePow == Math.pow(r2 - r1, 2)) return 1; // 내접

        // 3. 교점이 없는 경우 (0개)
        if (distancePow > Math.pow(r1 + r2, 2)) return 0; // 멀리 떨어짐
        if (distancePow < Math.pow(r2 - r1, 2)) return 0; // 원 안의 원

        // 4. 그 외의 경우 (2개)
        return 2;
    }
}
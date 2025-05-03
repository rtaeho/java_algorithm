import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String findNum_s;
    static int d;
    static long x, y;
    static long find_x = 0;
    static long find_y = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        d = Integer.parseInt(st.nextToken());
        findNum_s = st.nextToken();

        st = new StringTokenizer(br.readLine());
        y = Long.parseLong(st.nextToken()); // 위아래
        x = Long.parseLong(st.nextToken()); // 좌우

        long size = 1L << d; // 전체 맵 크기
        findPosition(0, 0, 0, size, size);

        find_x -= x;
        find_y += y;

        if (0 <= find_x && find_x < size && 0 <= find_y && find_y < size) {
            getQuadrant(d, find_x, find_y);
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }

    static void findPosition(int idx, long lx, long ly, long rx, long ry) {
        if (idx == d) {
            find_x = lx;
            find_y = ly;
            return;
        }

        int num = findNum_s.charAt(idx) - '0';
        long mx = (lx + rx) / 2;
        long my = (ly + ry) / 2;

        switch (num) {
            case 1: findPosition(idx + 1, lx, my, mx, ry); break;
            case 2: findPosition(idx + 1, lx, ly, mx, my); break;
            case 3: findPosition(idx + 1, mx, ly, rx, my); break;
            case 4: findPosition(idx + 1, mx, my, rx, ry); break;
        }
    }

    static void getQuadrant(int len, long tx, long ty) {
        if (len == 0) return;

        long half = 1L << (len - 1);

        if (tx < half && ty >= half) {
            sb.append("1");
            getQuadrant(len - 1, tx, ty - half);
        } else if (tx < half && ty < half) {
            sb.append("2");
            getQuadrant(len - 1, tx, ty);
        } else if (tx >= half && ty < half) {
            sb.append("3");
            getQuadrant(len - 1, tx - half, ty);
        } else {
            sb.append("4");
            getQuadrant(len - 1, tx - half, ty - half);
        }
    }
}
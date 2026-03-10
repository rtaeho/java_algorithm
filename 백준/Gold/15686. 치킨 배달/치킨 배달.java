import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<int[]> houses = new ArrayList<>();
    static ArrayList<int[]> chickens = new ArrayList<>();
    static int[] selected;
    static int minTotalDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                int type = Integer.parseInt(st.nextToken());
                if (type == 1) houses.add(new int[]{r, c});
                else if (type == 2) chickens.add(new int[]{r, c});
            }
        }

        selected = new int[M];
        combination(0, 0);

        System.out.println(minTotalDistance);
    }

    static void combination(int start, int count) {
        if (count == M) {
            calculateChickenDistance();
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected[count] = i;
            combination(i + 1, count + 1);
        }
    }

    static void calculateChickenDistance() {
        int cityDistance = 0;

        for (int[] h : houses) {
            int minHouseDist = Integer.MAX_VALUE;
            for (int idx : selected) {
                int[] c = chickens.get(idx);
                int dist = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                minHouseDist = Math.min(minHouseDist, dist);
            }
            cityDistance += minHouseDist;

            if (cityDistance >= minTotalDistance) return;
        }

        minTotalDistance = Math.min(minTotalDistance, cityDistance);
    }
}
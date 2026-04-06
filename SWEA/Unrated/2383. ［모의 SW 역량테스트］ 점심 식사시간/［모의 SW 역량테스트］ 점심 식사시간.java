import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int T, N;
    static int[][] map;
    static List<int[]> people;
    static List<int[]> stairs;
    static int[] selectedStair;
    static int minTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int TEST_CASE = 0; TEST_CASE < T; TEST_CASE++) {
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            people = new ArrayList<>();
            stairs = new ArrayList<>();
            minTime = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        people.add(new int[]{i, j});
                    } else if (map[i][j] > 1) {
                        stairs.add(new int[]{i, j, map[i][j]});
                    }
                }
            }

            selectedStair = new int[people.size()];
            subset(0);

            sb.append("#").append(TEST_CASE + 1).append(" ").append(minTime).append("\n");
        }
        System.out.print(sb);
    }

    static void subset(int cnt) {
        if (cnt == people.size()) {
            minTime = Math.min(minTime, calculateTime());
            return;
        }

        selectedStair[cnt] = 0;
        subset(cnt + 1);
        selectedStair[cnt] = 1;
        subset(cnt + 1);
    }

    static int calculateTime() {
        int maxTime = 0;

        for (int S = 0; S < 2; S++) {
            List<Integer> timeForArrive = new ArrayList<>();
            for (int P = 0; P < people.size(); P++) {
                if (selectedStair[P] == S) {
                    int[] p = people.get(P);
                    int[] s = stairs.get(S);
                    int dist = Math.abs(p[0] - s[0]) + Math.abs(p[1] - s[1]);
                    timeForArrive.add(dist);
                }
            }

            Collections.sort(timeForArrive);

            Queue<Integer> stairQ = new LinkedList<>();
            int len = stairs.get(S)[2];
            int finish = 0;

            for (int arrivalTime : timeForArrive) {
                int timeForStart = arrivalTime + 1;

                if (stairQ.size() == 3) {
                    int firstOutTime = stairQ.poll();
                    timeForStart = Math.max(timeForStart, firstOutTime);
                }

                finish = timeForStart + len;
                stairQ.add(finish);
            }
            maxTime = Math.max(maxTime, finish);
        }
        return maxTime;
    }
}
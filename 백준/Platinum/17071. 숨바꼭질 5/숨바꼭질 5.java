import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    final static int MAX = 500000;
    static int[][] visited = new int[2][MAX + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 동생은 이전 거리 + 회차 수 만큼 이동
        // 수빈이는 순간이동 or 한칸 앞뒤로 이동
        // 동생이 수빈이와 같은 위치에 도착하는 시간

        if (N == K) {
            System.out.println(0);
        } else {
            System.out.println(bfs());
        }
    }
    static int bfs() {
        int time = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[0][N] = 0;

        while(!queue.isEmpty()) {
            // 수빈이가 해당 시간에 지나갔던 위치를 동생이 지나가는지 보고
            // 맞다면 해당 시간에서 수빈이가 앞뒤로 움직이며서 동생이 올 때까지 기다리는 식으로
            int size = queue.size();
            int mod = ++time % 2;

            for (int i = 0; i < size; i++) {
                int cur = queue.poll();

                // 순간이동
                int nextPos = cur * 2;
                if (nextPos <= MAX && visited[mod][nextPos] == 0) {
                    visited[mod][nextPos] = time;
                    queue.offer(nextPos);
                }

                // 한칸 뒤로
                nextPos = cur - 1;
                if (nextPos >= 0 && visited[mod][nextPos] == 0) {
                    visited[mod][nextPos] = time;
                    queue.offer(nextPos);
                }

                // 한칸 앞으로
                nextPos = cur + 1;
                if (nextPos <= MAX && visited[mod][nextPos] == 0) {
                    visited[mod][nextPos] = time;
                    queue.offer(nextPos);
                }
            }
            int Kpos = K + (time * (time + 1)) / 2; // 등비수열 공식
            if (Kpos > MAX) {
                break;
            }
            if (visited[mod][Kpos] != 0) {
                return time;
            }
        }
        return -1;
    }

}

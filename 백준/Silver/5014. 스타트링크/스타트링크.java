import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int floor, start, goal, up, down;
    static int[] map;
    static boolean[] visited;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        floor = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());
        up = Integer.parseInt(st.nextToken());
        down = Integer.parseInt(st.nextToken());

        visited = new boolean[floor + 1];
        queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int answer = bfs();

        if (answer == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(answer);
        }
    }

    private static int bfs() {
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == goal) {
                    return cnt;
                }
                if (cur + up <= floor && !visited[cur + up]) {
                    queue.offer(cur + up);
                    visited[cur + up] = true;
                }
                if (cur - down >= 1 && !visited[cur - down]) {
                    queue.offer(cur - down);
                    visited[cur - down] = true;
                }
            }
            cnt++;
        }
        return -1;
    }
}

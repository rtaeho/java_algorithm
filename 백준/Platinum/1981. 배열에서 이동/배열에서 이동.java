/*
 * 문제
n×n짜리의 배열이 하나 있다. 이 배열의 (1, 1)에서 (n, n)까지 이동하려고 한다. 이동할 때는 상, 하, 좌, 우의 네 인접한 칸으로만 이동할 수 있다.

이와 같이 이동하다 보면, 배열에서 몇 개의 수를 거쳐서 이동하게 된다. 이동하기 위해 거쳐 간 수들 중 최댓값과 최솟값의 차이가 가장 작아지는 경우를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 n(2 ≤ n ≤ 100)이 주어진다. 다음 n개의 줄에는 배열이 주어진다. 배열의 각 수는 0보다 크거나 같고, 200보다 작거나 같은 정수이다.

출력
첫째 줄에 (최대 - 최소)가 가장 작아질 때의 그 값을 출력한다.

예제 입력 1 
5
1 1 3 6 8
1 2 2 5 5
4 4 0 3 3
8 0 2 3 4
4 3 0 2 1
예제 출력 1 
2
 */
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        int min = 200, max = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, arr[i][j]);
                max = Math.max(max, arr[i][j]);
            }
        }

        int left = 0, right = max - min;
        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            boolean found = false;

            for (int bottom = min; bottom <= max; bottom++) {
                int top = bottom + mid;
                if (top > max)
                    break;
                if (isPossible(bottom, top)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static boolean isPossible(int bottom, int top) {
        if (arr[0][0] < bottom || arr[0][0] > top)
            return false;

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0 });
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == n - 1 && cur[1] == n - 1)
                return true;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;
                if (visited[nx][ny])
                    continue;
                if (arr[nx][ny] < bottom || arr[nx][ny] > top)
                    continue;

                visited[nx][ny] = true;
                queue.offer(new int[] { nx, ny });
            }
        }

        return false;
    }
}

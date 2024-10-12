/*
문제
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

예제 입력 1
5 17
예제 출력 1
4
 */
import java.io.*;
import java.util.*;

public class Main {
    static int N; // 수빈이의 위치
    static int K; // 동생의 위치
    static boolean[] visited; // 방문 여부 체크 배열
    static int[] time; // 각 위치까지 도달하는 데 걸리는 시간

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 범위를 고려하여 visited와 time 배열 초기화
        visited = new boolean[100001];
        time = new int[100001];

        // BFS 탐색
        bfs(N);

        // 결과 출력
        System.out.println(time[K]);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 이동할 수 있는 위치들
            int[] nextPositions = {current - 1, current + 1, current * 2};

            for (int next : nextPositions) {
                if (next >= 0 && next <= 100000 && !visited[next]) { // 유효한 범위 체크
                    visited[next] = true; // 방문 처리
                    time[next] = time[current] + 1; // 시간 갱신
                    queue.add(next); // 큐에 추가

                    // 동생을 찾았을 때
                    if (next == K) {
                        return;
                    }
                }
            }
        }
    }
}

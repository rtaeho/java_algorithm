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
package baekjoon.year2025.july;

import java.io.*;
import java.util.*;

/**
 * 백준 1981 - 배열에서 이동
 * 
 * 문제 핵심 개념:
 * 1. 이분 탐색 - 최대값과 최소값의 차이를 찾기 위해 사용
 * 2. BFS - 현재 차이값으로 경로가 존재하는지 확인
 * 3. 매개 변수 탐색 - 특정 차이값에 대한 가능성을 판단
 */
public class BOJ1981 {
    // 전역 변수 선언
    static int n; // 배열의 크기
    static int[][] arr; // 입력받을 n x n 배열
    static int[] dx = { -1, 1, 0, 0 }; // 상하좌우 이동을 위한 x방향 배열 (상,하,좌,우)
    static int[] dy = { 0, 0, -1, 1 }; // 상하좌우 이동을 위한 y방향 배열 (상,하,좌,우)

    public static void main(String[] args) throws IOException {
        // 입출력을 위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 배열의 크기 입력
        arr = new int[n][n]; // n x n 크기의 2차원 배열 생성

        // 배열에서 나올 수 있는 최소값과 최대값을 저장할 변수
        // 최소값은 최대로, 최대값은 최소로 초기화하여 입력값과 비교하며 갱신
        int min = 200, max = 0;

        // 배열 입력 받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, arr[i][j]); // 최소값 갱신
                max = Math.max(max, arr[i][j]); // 최대값 갱신
            }
        }

        // 이분 탐색을 위한 변수 설정
        int left = 0; // 최소 차이값 (가능한 최소 차이)
        int right = max - min; // 최대 차이값 (가능한 최대 차이)
        int answer = right; // 정답을 저장할 변수 (최악의 경우로 초기화)

        // 이분 탐색 시작
        while (left <= right) {
            int mid = (left + right) / 2; // 현재 탐색할 차이값
            boolean found = false; // 현재 차이값으로 경로를 찾았는지 여부

            // 현재 차이값(mid)에 대해 가능한 모든 최소값을 시도
            for (int bottom = min; bottom <= max; bottom++) {
                int top = bottom + mid; // 최대값 = 최소값 + 차이값
                if (top > max)
                    break; // 최대값이 배열의 최대값을 넘어가면 더 이상 시도할 필요 없음

                // 현재 범위(bottom~top)로 (1,1)에서 (n,n)까지 이동이 가능한지 확인
                if (isPossible(bottom, top)) {
                    found = true;
                    break;
                }
            }

            // 이분 탐색 범위 조정
            if (found) {
                answer = mid; // 현재 차이값으로 경로를 찾았다면 정답 갱신
                right = mid - 1; // 더 작은 차이값도 가능한지 확인하기 위해 오른쪽 범위를 줄임
            } else {
                left = mid + 1; // 현재 차이값으로 불가능하다면 더 큰 차이값을 확인하기 위해 왼쪽 범위를 늘림
            }
        }

        // 최종 정답 출력
        System.out.println(answer);
    }

    /**
     * BFS를 사용하여 주어진 범위 내에서 (1,1)에서 (n,n)까지 이동이 가능한지 확인하는 메서드
     * 
     * @param bottom 허용되는 최소값
     * @param top    허용되는 최대값
     * @return 이동 가능 여부 (true/false)
     */
    static boolean isPossible(int bottom, int top) {
        // 시작점의 값이 범위를 벗어나면 이동 불가능
        if (arr[0][0] < bottom || arr[0][0] > top)
            return false;

        // BFS 구현을 위한 변수들
        boolean[][] visited = new boolean[n][n]; // 방문 여부를 체크할 배열
        Queue<int[]> queue = new LinkedList<>(); // BFS에 사용할 큐
        queue.offer(new int[] { 0, 0 }); // 시작점 (0,0) 추가
        visited[0][0] = true; // 시작점 방문 체크

        // BFS 시작
        while (!queue.isEmpty()) {
            int[] cur = queue.poll(); // 현재 위치 꺼내기

            // 도착점에 도달했다면 true 반환
            if (cur[0] == n - 1 && cur[1] == n - 1)
                return true;

            // 상하좌우 네 방향에 대해 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i]; // 다음 x좌표
                int ny = cur[1] + dy[i]; // 다음 y좌표

                // 다음 위치가 배열 범위를 벗어나면 스킵
                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;
                // 이미 방문한 위치면 스킵
                if (visited[nx][ny])
                    continue;
                // 다음 위치의 값이 허용 범위를 벗어나면 스킵
                if (arr[nx][ny] < bottom || arr[nx][ny] > top)
                    continue;

                // 방문 체크 후 큐에 추가
                visited[nx][ny] = true;
                queue.offer(new int[] { nx, ny });
            }
        }

        // 도착점에 도달하지 못했다면 false 반환
        return false;
    }
}

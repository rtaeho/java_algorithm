/*
문제
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

예제 입력 1
5 17
예제 출력 1
2
 */
package baekjoon.basic_algorithm_2.BFS;

import java.io.*;
import java.util.*;

public class BOJ13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
        int K = Integer.parseInt(st.nextToken()); // 동생의 위치

        // 수빈이와 동생의 위치 범위
        int maxPosition = 100000;
        int[] time = new int[maxPosition + 1]; // 각 위치에 도달하는 최소 시간
        Arrays.fill(time, Integer.MAX_VALUE); // 초기 시간을 무한대로 설정

        // BFS 초기화
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        time[N] = 0; // 시작 위치의 시간은 0초

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 현재 위치에서 가능한 모든 이동
            // 1. 순간 이동
            int teleport = current * 2;
            if (teleport <= maxPosition && time[teleport] > time[current]) {
                time[teleport] = time[current]; // 순간 이동은 0초
                queue.add(teleport);
            }

            // 2. 이동 (X - 1)
            if (current - 1 >= 0 && time[current - 1] > time[current] + 1) {
                time[current - 1] = time[current] + 1; // 이동은 1초 소요
                queue.add(current - 1);
            }

            // 3. 이동 (X + 1)
            if (current + 1 <= maxPosition && time[current + 1] > time[current] + 1) {
                time[current + 1] = time[current] + 1; // 이동은 1초 소요
                queue.add(current + 1);
            }
        }

        // 동생의 위치 K에 도달하는 최소 시간 출력
        System.out.println(time[K]);
    }
}
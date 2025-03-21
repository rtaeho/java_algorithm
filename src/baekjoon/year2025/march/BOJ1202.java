/*
문제
세계적인 도둑 상덕이는 보석점을 털기로 결심했다.

상덕이가 털 보석점에는 보석이 총 N개 있다. 각 보석은 무게 Mi와 가격 Vi를 가지고 있다. 상덕이는 가방을 K개 가지고 있고, 각 가방에 담을 수 있는 최대 무게는 Ci이다. 가방에는 최대 한 개의 보석만 넣을 수 있다.

상덕이가 훔칠 수 있는 보석의 최대 가격을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 주어진다. (1 ≤ N, K ≤ 300,000)

다음 N개 줄에는 각 보석의 정보 Mi와 Vi가 주어진다. (0 ≤ Mi, Vi ≤ 1,000,000)

다음 K개 줄에는 가방에 담을 수 있는 최대 무게 Ci가 주어진다. (1 ≤ Ci ≤ 100,000,000)

모든 숫자는 양의 정수이다.

출력
첫째 줄에 상덕이가 훔칠 수 있는 보석 가격의 합의 최댓값을 출력한다.

예제 입력 1
2 1
5 10
100 100
11
예제 출력 1
10
예제 입력 2
3 2
1 65
5 23
2 99
10
2
예제 출력 2
164
힌트
두 번째 예제의 경우 첫 번째 보석을 두 번째 가방에, 세 번째 보석을 첫 번째 가방에 넣으면 된다.
 */
package baekjoon.year2025.march;

import java.io.*;
import java.util.*;

public class BOJ1202 {
    static class Jewel implements Comparable<Jewel> {
        int weight, value;
        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Jewel o) {
            return this.weight - o.weight; // 무게 오름차순 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 보석 개수
        int K = Integer.parseInt(st.nextToken()); // 가방 개수

        // 보석 정보 입력
        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 보석 무게
            int V = Integer.parseInt(st.nextToken()); // 보석 가격
            jewels[i] = new Jewel(M, V);
        }

        // 가방 정보 입력
        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 1. 보석 무게 기준 오름차순 정렬
        Arrays.sort(jewels);

        // 2. 가방 용량 기준 오름차순 정렬
        Arrays.sort(bags);

        // 3. 최대 힙 (PriorityQueue) -> 보석의 가격 기준 내림차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long maxProfit = 0;
        int jewelIndex = 0;

        // 4. 작은 가방부터 탐색하면서 넣을 수 있는 보석을 PQ에 추가
        for (int bag : bags) {
            while (jewelIndex < N && jewels[jewelIndex].weight <= bag) {
                pq.add(jewels[jewelIndex].value);
                jewelIndex++;
            }

            // 가장 비싼 보석을 가방에 담는다.
            if (!pq.isEmpty()) {
                maxProfit += pq.poll();
            }
        }

        System.out.println(maxProfit);
    }
}
/*
 * 문제
N개의 수로 이루어진 1차원 배열이 있다. 이 배열을 M개 이하의 구간으로 나누어서 구간의 점수의 최댓값을 최소로 하려고 한다. 구간은 다음과 같은 조건을 만족해야 한다.

하나의 구간은 하나 이상의 연속된 수들로 이루어져 있다.
배열의 각 수는 모두 하나의 구간에 포함되어 있어야 한다.
구간의 점수란 구간에 속한 수의 최댓값과 최솟값의 차이이다.

예를 들어, 배열이 [1, 5, 4, 6, 2, 1, 3, 7] 이고, M = 3인 경우가 있다.

이때, [1, 5], [4, 6, 2], [1, 3, 7]로 구간을 나누면 각 구간의 점수는 4, 4, 6점이 된다. 이때, 최댓값은 6점이다.

만약, [1, 5, 4], [6, 2, 1], [3, 7]로 구간을 나누었다면, 각 구간의 점수는 4, 5, 4점이 되고, 이때 최댓값은 5점이 된다.

두 경우 중에서 최댓값이 최소인 것은 5점인 것이고, 5점보다 최댓값을 작게 만드는 방법은 없다.

배열과 M이 주어졌을 때, 구간의 점수의 최댓값의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 배열의 크기 N과 M이 주어진다. (1 ≤ N ≤ 5,000, 1 ≤ M ≤ N)

둘째 줄에 배열에 들어있는 수가 순서대로 주어진다. 배열에 들어있는 수는 1보다 크거나 같고, 10,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 구간의 점수의 최댓값의 최솟값을 출력한다.

예제 입력 1 
8 3
1 5 4 6 2 1 3 7
예제 출력 1 
5
예제 입력 2 
4 2
1 1 1 1
예제 출력 2 
0
예제 입력 3 
7 4
1 2 3 1 2 3 1
예제 출력 3 
2
예제 입력 4 
5 1
1 100 99 2 3
예제 출력 4 
99
예제 입력 5 
5 2
1 100 99 2 3
예제 출력 5 
98
예제 입력 6 
5 3
1 100 99 2 3
예제 출력 6 
1
 */
package baekjoon.year2025.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        // 배열 입력받으면서 최대값 찾기
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        // 이분 탐색
        int left = 0; // 최소 점수 차이
        int right = max; // 최대 점수 차이

        while (left < right) {
            int mid = (left + right) / 2;

            if (isPossible(arr, N, M, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }

    // 주어진 점수 차이(score)로 M개 이하의 구간으로 나눌 수 있는지 확인
    private static boolean isPossible(int[] arr, int N, int M, int score) {
        int count = 1; // 구간의 개수
        int min = arr[0]; // 현재 구간의 최솟값
        int max = arr[0]; // 현재 구간의 최댓값

        for (int i = 1; i < N; i++) {
            int curr = arr[i];
            int nextMin = Math.min(min, curr);
            int nextMax = Math.max(max, curr);

            // 현재 구간에 포함시켰을 때 점수가 기준을 초과하면 새로운 구간 시작
            if (nextMax - nextMin > score) {
                count++;
                min = curr;
                max = curr;
            } else {
                min = nextMin;
                max = nextMax;
            }
        }

        return count <= M; // M개 이하의 구간으로 나눌 수 있으면 true
    }
}

/*
문제
수열 S가 주어졌을 때, 수열 S의 부분 수열의 합으로 나올 수 없는 가장 작은 자연수를 구하는 프로그램을 작성하시오.

예를 들어, S = [5, 1, 2]인 경우에 1, 2, 3(=1+2), 5, 6(=1+5), 7(=2+5), 8(=1+2+5)을 만들 수 있다. 하지만, 4는 만들 수 없기 때문에 정답은 4이다.

입력
첫째 줄에 수열 S의 크기 N이 주어진다. (1 ≤ N ≤ 20)

둘째 줄에는 수열 S가 주어진다. S를 이루고있는 수는 100,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 수열 S의 부분 수열의 합으로 나올 수 없는 가장 작은 자연수를 출력한다.

예제 입력 1
3
5 1 2
예제 출력 1
4
예제 입력 2
3
2 1 4
예제 출력 2
8
예제 입력 3
4
2 1 2 7
예제 출력 3
6
 */
package baekjoon.intermediate_algorithm_1.bruteforce_permutation_recur;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ14225 {
    static int N;
    static int[] S;
    static HashSet<Integer> sums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N];
        sums = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        findSums(0, 0); // 부분 수열의 합을 찾기 위한 재귀 호출

        // 1부터 시작하여 만들어진 부분 수열의 합 중 없는 자연수 찾기
        int answer = 1;
        while (sums.contains(answer)) {
            answer++;
        }

        System.out.println(answer);
    }

    static void findSums(int index, int currentSum) {
        if (index == N) {
            sums.add(currentSum); // 부분 수열의 합 추가
            return;
        }

        // 현재 인덱스의 숫자를 포함하지 않는 경우
        findSums(index + 1, currentSum);
        // 현재 인덱스의 숫자를 포함하는 경우
        findSums(index + 1, currentSum + S[index]);
    }
}
/*
 * 문제
로마 숫자에서는 수를 나타내기 위해서 I, V, X, L을 사용한다. 각 문자는 1, 5, 10, 50을 의미하고, 이 문제에서 다른 문자는 사용하지 않는다.

하나 또는 그 이상의 문자를 이용해서 수를 나타낼 수 있다. 문자열이 나타내는 값은, 각 문자가 의미하는 수를 모두 합한 값이다. 예를 들어, XXXV는 35, IXI는 12를 의미한다.

실제 로마 숫자에서는 문자의 순서가 중요하지만, 이 문제에서는 순서는 신경쓰지 않는다. 예를 들어, 실제 로마 숫자에서 IX는 9를 의미하지만, 이 문제에서는 11을 의미한다.

로마 숫자를 N개 사용해서 만들 수 있는 서로 다른 수의 개수를 구해보자.

입력
첫째 줄에 사용할 수 있는 문자의 개수 N (1 ≤ N ≤ 20)이 주어진다.

출력
첫째 줄에 로마 숫자 N개를 사용해서 만들 수 있는 서로 다른 수의 개수를 출력한다.

예제 입력 1 
1
예제 출력 1 
4
I, V, X, L을 만들 수 있다.

예제 입력 2 
2
예제 출력 2 
10
2, 6, 10, 11, 15, 20, 51, 55, 60, 100을 만들 수 있다.

예제 입력 3 
10
예제 출력 3 
244
 */
package baekjoon.year2025.august;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class BOJ16922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 각 문자가 나타내는 값
        int[] values = { 1, 5, 10, 50 };

        // 가능한 모든 수를 저장할 Set (중복 제거)
        Set<Integer> possibleSums = new HashSet<>();

        // N개의 문자를 선택하는 모든 경우의 수를 생성
        generateSums(values, N, 0, 0, possibleSums);

        System.out.println(possibleSums.size());
        br.close();
    }

    // 재귀적으로 모든 가능한 합을 생성하는 메서드
    private static void generateSums(int[] values, int remaining, int start, int currentSum, Set<Integer> sums) {
        // 남은 문자가 없으면 현재 합을 결과에 추가
        if (remaining == 0) {
            sums.add(currentSum);
            return;
        }

        // 각 문자를 선택하는 경우를 시도
        for (int i = start; i < values.length; i++) {
            generateSums(values, remaining - 1, i, currentSum + values[i], sums);
        }
    }

}
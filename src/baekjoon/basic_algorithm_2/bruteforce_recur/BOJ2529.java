/*
문제
두 종류의 부등호 기호 ‘<’와 ‘>’가 k개 나열된 순서열 A가 있다. 우리는 이 부등호 기호 앞뒤에 서로 다른 한 자릿수 숫자를 넣어서 모든 부등호 관계를 만족시키려고 한다. 예를 들어, 제시된 부등호 순서열 A가 다음과 같다고 하자.

A ⇒ < < < > < < > < >

부등호 기호 앞뒤에 넣을 수 있는 숫자는 0부터 9까지의 정수이며 선택된 숫자는 모두 달라야 한다. 아래는 부등호 순서열 A를 만족시키는 한 예이다.

3 < 4 < 5 < 6 > 1 < 2 < 8 > 7 < 9 > 0

이 상황에서 부등호 기호를 제거한 뒤, 숫자를 모두 붙이면 하나의 수를 만들 수 있는데 이 수를 주어진 부등호 관계를 만족시키는 정수라고 한다. 그런데 주어진 부등호 관계를 만족하는 정수는 하나 이상 존재한다. 예를 들어 3456128790 뿐만 아니라 5689023174도 아래와 같이 부등호 관계 A를 만족시킨다.

5 < 6 < 8 < 9 > 0 < 2 < 3 > 1 < 7 > 4

여러분은 제시된 k개의 부등호 순서를 만족하는 (k+1)자리의 정수 중에서 최댓값과 최솟값을 찾아야 한다. 앞서 설명한 대로 각 부등호의 앞뒤에 들어가는 숫자는 { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }중에서 선택해야 하며 선택된 숫자는 모두 달라야 한다.

입력
첫 줄에 부등호 문자의 개수를 나타내는 정수 k가 주어진다. 그 다음 줄에는 k개의 부등호 기호가 하나의 공백을 두고 한 줄에 모두 제시된다. k의 범위는 2 ≤ k ≤ 9 이다.

출력
여러분은 제시된 부등호 관계를 만족하는 k+1 자리의 최대, 최소 정수를 첫째 줄과 둘째 줄에 각각 출력해야 한다. 단 아래 예(1)과 같이 첫 자리가 0인 경우도 정수에 포함되어야 한다. 모든 입력에 답은 항상 존재하며 출력 정수는 하나의 문자열이 되도록 해야 한다.

예제 입력 1
2
< >
예제 출력 1
897
021
예제 입력 2
9
> < < < > > > < <
예제 출력 2
9567843012
1023765489
 */
package baekjoon.basic_algorithm_2.bruteforce_recur;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class BOJ2529 {
    static int k;
    static char[] operators;
    static boolean[] used = new boolean[10];
    static ArrayList<String> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        operators = new char[k];

        String[] ops = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            operators[i] = ops[i].charAt(0);
        }

        backtrack("", 0);

        results.sort(null);  // 문자열 비교로 정렬
        System.out.println(results.getLast());  // 최대값
        System.out.println(results.getFirst());  // 최소값
    }

    static void backtrack(String num, int depth) {
        if (depth == k + 1) {
            results.add(num);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!used[i]) {
                if (depth == 0 || isValid(num.charAt(depth - 1) - '0', i, operators[depth - 1])) {
                    used[i] = true;
                    backtrack(num + i, depth + 1);
                    used[i] = false;
                }
            }
        }
    }

    static boolean isValid(int a, int b, char op) {
        if (op == '<') {
            return a < b;
        } else {
            return a > b;
        }
    }
}


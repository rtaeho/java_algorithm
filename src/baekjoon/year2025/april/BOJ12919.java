/*
문제
수빈이는 A와 B로만 이루어진 영어 단어 존재한다는 사실에 놀랐다. 대표적인 예로 AB (Abdominal의 약자), BAA (양의 울음 소리), AA (용암의 종류), ABBA (스웨덴 팝 그룹)이 있다.

이런 사실에 놀란 수빈이는 간단한 게임을 만들기로 했다. 두 문자열 S와 T가 주어졌을 때, S를 T로 바꾸는 게임이다. 문자열을 바꿀 때는 다음과 같은 두 가지 연산만 가능하다.

문자열의 뒤에 A를 추가한다.
문자열의 뒤에 B를 추가하고 문자열을 뒤집는다.
주어진 조건을 이용해서 S를 T로 만들 수 있는지 없는지 알아내는 프로그램을 작성하시오.

입력
첫째 줄에 S가 둘째 줄에 T가 주어진다. (1 ≤ S의 길이 ≤ 49, 2 ≤ T의 길이 ≤ 50, S의 길이 < T의 길이)

출력
S를 T로 바꿀 수 있으면 1을 없으면 0을 출력한다.

예제 입력 1
A
BABA
예제 출력 1
1
예제 입력 2
BAAAAABAA
BAABAAAAAB
예제 출력 2
1
예제 입력 3
A
ABBA
예제 출력 3
0
 */
package baekjoon.year2025.april;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ12919 {

    static String S, T;
    static boolean possible = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        dfs(T);

        System.out.println(possible ? 1 : 0);
    }

    // DFS로 역방향 탐색
    static void dfs(String current) {
        if (possible) {
            return; // 이미 정답 찾음
        }

        if (current.length() == S.length()) {
            if (current.equals(S)) {
                possible = true;
            }
            return;
        }

        // 1. A 제거 (뒤에 있는 A 제거)
        if (current.endsWith("A")) {
            dfs(current.substring(0, current.length() - 1));
        }

        // 2. B 제거 (앞에 있는 B 제거 + 뒤집기)
        if (current.startsWith("B")) {
            StringBuilder reversed = new StringBuilder(current.substring(1)).reverse();
            dfs(reversed.toString());
        }
    }
}
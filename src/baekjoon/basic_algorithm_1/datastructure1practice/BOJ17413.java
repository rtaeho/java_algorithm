/*
문제
문자열 S가 주어졌을 때, 이 문자열에서 단어만 뒤집으려고 한다.

먼저, 문자열 S는 아래와과 같은 규칙을 지킨다.

알파벳 소문자('a'-'z'), 숫자('0'-'9'), 공백(' '), 특수 문자('<', '>')로만 이루어져 있다.
문자열의 시작과 끝은 공백이 아니다.
'<'와 '>'가 문자열에 있는 경우 번갈아가면서 등장하며, '<'이 먼저 등장한다. 또, 두 문자의 개수는 같다.
태그는 '<'로 시작해서 '>'로 끝나는 길이가 3 이상인 부분 문자열이고, '<'와 '>' 사이에는 알파벳 소문자와 공백만 있다. 단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열이고, 연속하는 두 단어는 공백 하나로 구분한다. 태그는 단어가 아니며, 태그와 단어 사이에는 공백이 없다.

입력
첫째 줄에 문자열 S가 주어진다. S의 길이는 100,000 이하이다.

출력
첫째 줄에 문자열 S의 단어를 뒤집어서 출력한다.

예제 입력 1
baekjoon online judge
예제 출력 1
noojkeab enilno egduj
예제 입력 2
<open>tag<close>
예제 출력 2
<open>gat<close>
예제 입력 3
<ab cd>ef gh<ij kl>
예제 출력 3
<ab cd>fe hg<ij kl>
예제 입력 4
one1 two2 three3 4fourr 5five 6six
예제 출력 4
1eno 2owt 3eerht rruof4 evif5 xis6
예제 입력 5
<int><max>2147483647<long long><max>9223372036854775807
예제 출력 5
<int><max>7463847412<long long><max>7085774586302733229
예제 입력 6
<problem>17413<is hardest>problem ever<end>
예제 출력 6
<problem>31471<is hardest>melborp reve<end>
예제 입력 7
<   space   >space space space<    spa   c e>
예제 출력 7
<   space   >ecaps ecaps ecaps<    spa   c e>
 */
package baekjoon.basic_algorithm_1.datastructure1practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        Boolean flag = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                flag = true;
            } else if (s.charAt(i) == '>') {
                flag = false;
                sb.append(s.charAt(i));
                continue;
            }
            if (flag) {
                sb.append(s.charAt(i));
            } else {
                if (s.charAt(i) == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                    continue;
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        if (s.charAt(s.length() - 1) != '>') {
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
        }
        System.out.println(sb);
        br.close();
    }
    // stack을 생각 못 하고  string을 그대로 분할하려다가 실패
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        int flag = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                flag = 1;
            }
            if (s.charAt(i) == ' ' && flag == 0) {
                sb.append(tmp.reverse()).append(" ");
                tmp = new StringBuilder();
            } else if (s.charAt(i) == '>') {
                flag = 0;
                sb.append(tmp).append(">");
                tmp = new StringBuilder();
            } else {
                tmp.append(s.charAt(i));
            }
        }
        if (s.charAt(s.length() - 1) != '>') {
            sb.append(tmp.reverse());
        }
        System.out.println(sb);
        br.close();
    }*/
}

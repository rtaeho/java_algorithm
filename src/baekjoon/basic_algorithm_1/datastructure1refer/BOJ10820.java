/*
문제
문자열 N개가 주어진다. 이때, 문자열에 포함되어 있는 소문자, 대문자, 숫자, 공백의 개수를 구하는 프로그램을 작성하시오.

각 문자열은 알파벳 소문자, 대문자, 숫자, 공백으로만 이루어져 있다.

입력
첫째 줄부터 N번째 줄까지 문자열이 주어진다. (1 ≤ N ≤ 100) 문자열의 길이는 100을 넘지 않는다.

출력
첫째 줄부터 N번째 줄까지 각각의 문자열에 대해서 소문자, 대문자, 숫자, 공백의 개수를 공백으로 구분해 출력한다.

예제 입력 1
This is String
SPACE    1    SPACE
 S a M p L e I n P u T
0L1A2S3T4L5I6N7E8
예제 출력 1
10 2 0 2
0 10 1 8
5 6 0 16
0 8 9 0
 */
package baekjoon.basic_algorithm_1.datastructure1refer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        while (s != null) {
            int lower, upper, number, space;
            lower = upper = number = space = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if ('a' <= c && c <= 'z') lower++;
                else if ('A' <= c && c <= 'Z') upper++;
                else if ('0' <= c && c <= '9') number++;
                else if (c == ' ') space++;
            }
            sb.append(lower).append(" ").append(upper).append(" ").append(number).append(" ").append(space).append("\n");
            s = br.readLine();
        }
        System.out.println(sb);
        br.close();
    }
}

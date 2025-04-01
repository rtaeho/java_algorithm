/*
문제
어느 날, 미르코는 우연히 길거리에서 양수 N을 보았다. 미르코는 30이란 수를 존경하기 때문에, 그는 길거리에서 찾은 수에 포함된 숫자들을 섞어 30의 배수가 되는 가장 큰 수를 만들고 싶어한다.

미르코를 도와 그가 만들고 싶어하는 수를 계산하는 프로그램을 작성하라.

입력
N을 입력받는다. N는 최대 105개의 숫자로 구성되어 있으며, 0으로 시작하지 않는다.

출력
미르코가 만들고 싶어하는 수가 존재한다면 그 수를 출력하라. 그 수가 존재하지 않는다면, -1을 출력하라.

예제 입력 1
30
예제 출력 1
30
예제 입력 2
102
예제 출력 2
210
예제 입력 3
2931
예제 출력 3
-1
예제 입력 4
80875542
예제 출력 4
88755420
 */
package baekjoon.year2025.march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        char[] digits = input.toCharArray();
        int sum = 0;
        boolean hasZero = false;

        for (char c : digits) {
            int num = c - '0';
            sum += num;
            if (num == 0) {
                hasZero = true;
            }
        }

        // 30의 배수 조건 체크
        if (!hasZero || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }
        // 내림차순 정렬해서 최대 수 만들기
        Arrays.sort(digits);
        StringBuilder sb = new StringBuilder(new String(digits));
        System.out.println(sb.reverse().toString());
    }
}

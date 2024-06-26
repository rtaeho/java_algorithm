/*
문제
제연이는 그의 생일(2000년 3월 3일)을 기념해 자신이 가장 좋아하는 수를 20000303으로 나눈 나머지를 구해 그 수만큼 잠을 자기로 했다. 제연이가 얼마나 잠을 잘 수 있을지 구하자.

입력
첫째 줄에 제연이가 가장 좋아하는 수 N이 주어진다. (N ≤ 101,000,000)

출력
N을 20000303으로 나눈 나머지를 출력한다.

예제 입력 1
20000303200003032000030320000303200003032000030320000303200003032000030320000303
예제 출력 1
0
예제 입력 2
123456789123456789123456789123456789123456789123456789123456789123456789
예제 출력 2
1313652
 */
package baekjoon.busyday.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ14928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        final int num = 20000303;
        long remain = 0;

        for (int i = 0; i < N.length(); i++) {
            remain = (remain * 10 + N.charAt(i) - '0') % num;
        }
        System.out.println(remain);
        br.close();
    }
}

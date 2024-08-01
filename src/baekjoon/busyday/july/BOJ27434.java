/*
문제
0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N(0 ≤ N ≤ 100,000)이 주어진다.

출력
첫째 줄에 N!을 출력한다.

예제 입력 1
10
예제 출력 1
3628800
예제 입력 2
0
예제 출력 2
1
 */
package baekjoon.busyday.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ27434 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.valueOf(br.readLine());
        System.out.println(factorial(1, N));
    }

    public static BigInteger factorial(int a, int n) {
        BigInteger num = BigInteger.valueOf(a);

        if (a < n) {
            int b = (a + n) / 2;
            num = factorial(a, b).multiply(factorial(b + 1, n));
        }
        return num;
    }
}

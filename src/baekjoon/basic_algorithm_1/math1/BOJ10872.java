/*
문제
0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.

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
package baekjoon.basic_algorithm_1.math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(factorial(N));
        br.close();
    }

    public static int factorial(int N) {
        if (N <= 1) return 1;
        return N * factorial(N - 1);
    }
}

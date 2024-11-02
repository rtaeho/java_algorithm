/*
문제
자연수
\(N\)과 정수
\(K\)가 주어졌을 때 이항 계수
\(\binom{N}{K}\)를 구하는 프로그램을 작성하시오.

입력
첫째 줄에
\(N\)과
\(K\)가 주어진다. (1 ≤
\(N\) ≤ 10, 0 ≤
\(K\) ≤
\(N\))

출력

\(\binom{N}{K}\)를 출력한다.

예제 입력 1
5 2
예제 출력 1
10

 */
package baekjoon.busyday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        // 이항 계수 계산
        System.out.println(binomialCoefficient(N, K));
    }

    // 이항 계수 계산 함수
    private static int binomialCoefficient(int n, int k) {
        if (k == 0 || k == n) {
            return 1; // 경계 조건
        }
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    // 팩토리얼 계산 함수
    private static int factorial(int num) {
        int result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
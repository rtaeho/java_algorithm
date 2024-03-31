/*
문제
정수 n(0 ≤ n ≤ 4*109)가 주어졌을 때, n보다 크거나 같은 소수 중 가장 작은 소수 찾는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다.

출력
각각의 테스트 케이스에 대해서 n보다 크거나 같은 소수 중 가장 작은 소수를 한 줄에 하나씩 출력한다.

예제 입력 1
3
6
20
100
예제 출력 1
7
23
101
 */
package baekjoon.practice.factorsmultiplesanddecimals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ4143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String num = br.readLine();
            BigInteger prime = new BigInteger(num);
            long val = Long.parseLong(num);
            long sqrt = (long) Math.sqrt(val);
            boolean s = false;
            for (int i = 2; i <= sqrt; i++) {
                if (val % i == 0) {
                    s = true;
                    break;
                }
            }
            if (s)
                sb.append(prime.nextProbablePrime());
            else if (val == 0 || val == 1) {
                sb.append(prime.nextProbablePrime());
            } else
                sb.append(val);

            sb.append("\n");


        }
        System.out.println(sb);
        br.close();
    }
}


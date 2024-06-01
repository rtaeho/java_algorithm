/*
문제
Given two integers, calculate and output their sum.

입력
The input contains several test cases. The first line contains and integer t (t ≤ 100) denoting the number of test cases. Then t tests follow, each of them consisiting of two space separated integers x and y (−109 ≤ x, y ≤ 109).

출력
For each test case output output the sum of the corresponding integers.

예제 입력 1
4
-100 100
2 3
0 110101
-1000000000 1
예제 출력 1
0
5
110101
-999999999
 */
package baekjoon.busyday.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ7891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(a+b).append('\n');
        }
        System.out.println(sb);
    }
}

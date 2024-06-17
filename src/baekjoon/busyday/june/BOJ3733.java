/*
문제
A group of N persons and the ACM Chief Judge share equally a number of S shares (not necessary all of them). Let x be the number of shares aquired by each person (x must be an integer). The problem is to compute the maximum value of x.

Write a program that reads pairs of integer numbers from an input text file. Each pair contains the values of 1 ≤ N ≤ 10000 and 1 ≤ S ≤ 109 in that order. The input data are separated freely by white spaces, are correct, and terminate with an end of file. For each pair of numbers the program computes the maximum value of x and prints that value on the standard output from the beginning of a line, as shown in the example below.

예제 입력 1
1 100
2 7
10 9
10 10
예제 출력 1
50
2
0
0
 */
package baekjoon.busyday.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3733 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String cur = br.readLine();
            if (cur == null) break;
            StringTokenizer st = new StringTokenizer(cur);
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            sb.append(s / (n + 1)).append('\n');
        }
        System.out.println(sb);
    }
}

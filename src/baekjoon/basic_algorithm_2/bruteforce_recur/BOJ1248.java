/*
문제
Given a sequence of integers, a1, a2, …, an, we define its sign matrix S such that, for 1 ≤ i ≤ j ≤ n, Sij="+" if ai + … + aj > 0; Sij="−" if ai + … + aj < 0; and Sij="0" otherwise.

For example, if (a1, a2, a3, a4)=( −1, 5, −4, 2), then its sign matrix S is a 4×4 matrix:

 	1	2	3	4
1	-	+	0	+
2	 	+	+	+
3	 	 	-	-
4	 	 	 	+
We say that the sequence (−1, 5, −4, 2) generates the sign matrix. A sign matrix is valid if it can be generated by a sequence of integers.

Given a sequence of integers, it is easy to compute its sign matrix. This problem is about the opposite direction: Given a valid sign matrix, find a sequence of integers that generates the sign matrix. Note that two or more different sequences of integers can generate the same sign matrix. For example, the sequence (−2, 5, −3, 1) generates the same sign matrix as the sequence (−1,5, −4,2).

Write a program that, given a valid sign matrix, can find a sequence of integers that generates the sign matrix. You may assume that every integer in a sequence is between −10 and 10, both inclusive.

입력
The first line contains an integer n(1 ≤ n ≤ 10), where n is the length of a sequence of integers. The second line contains a string of n(n+1)/2 characters such that the first n characters correspond to the first row of the sign matrix, the next n−1 characters  to the second row, ..., and the last character to the n-th row.

출력
Output exactly one line containing a sequence of n integers which generates the sign matrix. If more than one sequence generates the sign matrix, you may output any one of them. Every integer in the sequence must be between −10 and 10, both inclusive.

예제 입력 1
4
-+0++++--+
예제 출력 1
-2 5 -3 1
예제 입력 2
2
+++
예제 출력 2
3 4
예제 입력 3
5
++0+-+-+--+-+--
예제 출력 3
1 2 -3 4 -5
 */
package baekjoon.basic_algorithm_2.bruteforce_recur;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1248 {
    public static int N;
    public static int ans[];
    public static boolean visited[][];
    public static String query;
    public static int len;
    public static char str[][];

    public static boolean check(int idx) {
        int sum = 0;
        for (int i = idx; i >= 0; i--) {
            sum += ans[i];
            if (str[i][idx] == '+' && sum <= 0) return false;
            if (str[i][idx] == '0' && sum != 0) return false;
            if (str[i][idx] == '-' && sum >= 0) return false;
        }
        return true;
    }

    public static void dfs(int idx) {
        if (idx == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(ans[i] + " ");

            }
            System.exit(0);
        }
        for (int i = -10; i <= 10; i++) {
            ans[idx] = i;
            if (check(idx)) {
                dfs(idx + 1);
            }

        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ans = new int[N];
        visited = new boolean[11][22]; //N번째 원소, 21개의 수
        query = br.readLine();
        len = N * (N - 1) / 2;
        str = new char[N][N];
        int temp = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                str[i][j] = query.charAt(temp++);
            }
        }
        dfs(0);
    }
}
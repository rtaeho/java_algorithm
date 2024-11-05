/*
문제
It is not hard to draw a triangle of stars of any given size. For example, a size 5 triangle would look like this (5 stars high and 5 stars wide):

*
**
***
****
*****
Your task is to draw triangles in a number of sizes.

입력
Each line of input contains a single positive integer, n, 1 <= n <= 100. The last line of input contains 0. For each non-zero number, draw a triangle of that size.

출력
Output consists of triangles of the appropriate sizes. Each triangle is wider at the bottom. There are no gaps between the triangles.

예제 입력 1
5
3
2
7
0
예제 출력 1
*
**
***
****
*****
*
**
***
*
**
*
**
***
****
*****
******
*******
 */
package baekjoon.busyday.november;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ7592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;  // 0이 입력되면 종료
            }

            // 입력된 크기 n에 대한 삼각형 출력
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");  // 별 출력
                }
                System.out.println();  // 줄 바꿈
            }
        }

        br.close();  // BufferedReader 닫기
    }
}

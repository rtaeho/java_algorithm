/*
문제
Read two integer numbers R and C from the standard input and then print R lines with C asterisks (*) each.

Example (R=3, C=5):

*****
*****
*****
Example (R=2, C=10):

**********
**********
입력
The first line will contain an interger R. The number of lines to print.

The second line will contain an integer C. The number of asterisks to print in each line.

R, C will be at most 20.

출력
Print a rectangle of R lines and C columns.

예제 입력 1
3
5
예제 출력 1
*****
*****
*****
 */
package baekjoon.busyday.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15232 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 17);
        int r = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append('*');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}

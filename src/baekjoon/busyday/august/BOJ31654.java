/*
문제
Your friend Bob is really bad at adding numbers, and he’d like some help to make sure he’s doing it correctly! Can you help Bob make sure he is adding correctly? Given 3 integers
$A$,
$B$,
$C$, make sure that
$A + B = C$, and that Bob indeed added
$A$ and
$B$ correctly.

입력
The input consists of a single line with 3 integers
$A, B, C$ where
$-10^9 \le A, B, C \le 10^9$.

출력
Output either correct! if
$A + B = C$, or wrong! if
$A + B \ne C$.

예제 입력 1
2 3 5
예제 출력 1
correct!
예제 입력 2
1 1 3
예제 출력 2
wrong!
예제 입력 3
-1 1 0
예제 출력 3
correct!
 */
package baekjoon.busyday.august;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ31654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        System.out.println(a + b == c ? "correct!" : "wrong!");
    }
}

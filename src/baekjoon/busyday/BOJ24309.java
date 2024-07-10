/*
문제
Учителката по математика дала на учениците да намерят неизвестното x от равенството: a·x = b-c. Числата а, b и c са естествени числа и са такива, че решението x е цяло число. Знайко посещавал школата по информатика и опитал да направи програма, но се затруднил. Помогнете му, като напишете програма equation, която намира неизвестното x.

입력
На първия ред на стандартния вход се задават три естествени числа а, b, c.

출력
На стандартния изход програмата трябва да изведе естествено число x, така че да е изпълнено даденото равенство.

제한
0 < c < b ≤ 10100
0 < a ≤ 1017
예제 입력 1
4
20
8
예제 출력 1
3
 */
package baekjoon.busyday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ24309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());
        BigInteger c = new BigInteger(br.readLine());
        b = b.subtract(c);
        b = b.divide(a);
        System.out.println(b);
    }
}

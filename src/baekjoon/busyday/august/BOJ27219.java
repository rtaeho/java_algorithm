/*
문제
Робинзон Крузо на необитаемом острове отмечает дни стене своей хижины.

Каждый день он ставит зарубку, которую будем обозначать английской буквой <<I>>, а раз в 5 дней зачеркивает четыре предыдущие зарубки, получая символ, который мы обозначим как <<V>>.

Какая запись получится на стене хижины Робинзона на
$n$-й день?

입력
На ввод подается одно число
$n$ (
$1 \le n \le 10\,000$).

출력
Выведите запись, которая получится на стене хижины Робинзона на
$n$-й день.

예제 입력 1
13
예제 출력 1
VVIII
 */
package baekjoon.busyday.august;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ27219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n / 5; i++) {
            System.out.print("V");
        }

        for (int i = 0; i < n % 5; i++) {
            System.out.print("I");
        }
    }
}

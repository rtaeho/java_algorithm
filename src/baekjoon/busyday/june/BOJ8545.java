/*
문제
Napisz program, który odwraca podane słowo trzyliterowe.

입력
W pierwszym i jedynym wierszu podane jest jedno słowo trzyliterowe.

출력
Pierwszy i jedyny wiersz wyjścia powinien zawierać odwrócone słowo wejściowe.

예제 입력 1
abc
예제 출력 1
cba
 */
package baekjoon.busyday.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ8545 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(new StringBuilder(br.readLine()).reverse());
    }
}

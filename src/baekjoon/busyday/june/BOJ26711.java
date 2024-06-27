/*
문제
Mamy dla was zadanie stare jak świat, ale w nieco odświeżonej wersji. Polega ono na dodaniu do siebie dwóch liczb, które tym razem mogą być dość duże. Gdyby tylko na Potyczkach Algorytmicznych było jakieś narzędzie, które pomaga radzić sobie z dużymi liczbami...

입력
W pierwszym wierszu wierszu standardowego wejścia znajduje się jedna dodatnia liczba całkowita a, która składa się z nie więcej niż 5 000 cyfr.

W drugim wierszu wierszu standardowego wejścia znajduje się jedna dodatnia liczba całkowita b, która składa się z nie więcej niż 5 000 cyfr.

Liczby a i b są podane bez zer wiodących.

출력
W jedynym wierszu wyjścia powinien znaleźć się wynik dodawania a + b.

예제 입력 1
1997
25
예제 출력 1
2022
 */
package baekjoon.busyday.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ26711 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger n = new BigInteger(br.readLine());
        BigInteger m = new BigInteger(br.readLine());
        System.out.println(n.add(m));
    }
}

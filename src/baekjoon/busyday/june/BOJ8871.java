/*
문제
Wyobraźmy sobie przez chwilę, że w tym roku konkurs SKI'10 składa się z n punktowanych rund i jednej rundy próbnej. Ile zgodnie z regulaminem może się pojawić zadań w czasie całych zawodów?

입력
W pierwszej i jedynej linii znajduje się liczba naturalna n (1<=n<=1000).

출력
Twój program powinien wypisać dwie liczby oddzielone pojedynczym odstępem. Pierwsza liczba to minimalna liczba zadań jaka może pojawić się podczas n rund punktowanych i jednej rundy próbnej w trakcie SKI'10. Druga liczba to maksymalna liczba zadań w tym konkursie.

예제 입력 1
5
예제 출력 1
12 18
 */
package baekjoon.busyday.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ8871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.printf("%d %d", (n + 1) * 2, (n + 1) * 3);
    }
}

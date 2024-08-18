/*
문제
Informatycy to też ludzie, więc jak wszyscy potrzebują trochę miłości. Bajtek właśnie postanowił wyznać miłość pięknej Bajtolinie i w tym celu zamierza narysować jej N serduszek w ASCII art złożonych ze znaków małpy (@).

Jedno serduszko wygląda następująco:

 @@@   @@@
@   @ @   @
@    @    @
@         @
 @       @
  @     @
   @   @
    @ @
     @
Bajtek chciałby, żeby serduszka były wypisane jedno pod drugim. Pomóż mu!

Napisz program, który: wczyta liczbę N – liczbę serduszek, które Bajtek chce narysować Bajtolinie i wypisze na standardowe wyjście N serduszek w formacie opisanym powyżej.

입력
W pierwszym (jedynym) wierszu wejścia znajduje się jedna liczba całkowita dodatnia N, określająca liczbę serduszek do wypisania. Liczba ta będzie równa co najmniej 1 i co najwyżej 100 000.

출력
Twój program powinien wypisać na wyjście dokładnie N serduszek, jedno pod drugim.

예제 입력 1
2
예제 출력 1
 @@@   @@@
@   @ @   @
@    @    @
@         @
 @       @
  @     @
   @   @
    @ @
     @
 @@@   @@@
@   @ @   @
@    @    @
@         @
 @       @
  @     @
   @   @
    @ @
     @
 */
package baekjoon.busyday.august;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ26766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            System.out.println(" @@@   @@@ ");
            System.out.println("@   @ @   @");
            System.out.println("@    @    @");
            System.out.println("@         @");
            System.out.println(" @       @ ");
            System.out.println("  @     @  ");
            System.out.println("   @   @   ");
            System.out.println("    @ @    ");
            System.out.println("     @     ");
        }
    }
}

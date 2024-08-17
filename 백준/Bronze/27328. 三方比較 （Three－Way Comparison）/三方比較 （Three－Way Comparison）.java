/*
문제
2 つの整数 A, B が与えられる．

A と B の大小を比較し，A ＜ B ならば -1 を，A ＝ B ならば 0 を，A ＞ B ならば 1 を出力せよ．

입력
入力は以下の形式で標準入力から与えられる．

A
B
출력
A ＜ B ならば -1 を，A ＝ B ならば 0 を，A ＞ B ならば 1 を出力せよ．

제한
1 ≦ A ≦ 1000．
1 ≦ B ≦ 1000．
A, B は整数である．
예제 입력 1
3
7
예제 출력 1
-1
3 ＜ 7 であるから，-1 を出力する．

예제 입력 2
10
10
예제 출력 2
0
10 ＝ 10 であるから，0 を出力する．

예제 입력 3
1000
1
예제 출력 3
1
1000 ＞ 1 であるから，1 を出力する．
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        if (a < b) {
            System.out.println("-1");
        } else if (a == b) {
            System.out.println("0");
        } else {
            System.out.println("1");
        }
        sc.close();
    }
}

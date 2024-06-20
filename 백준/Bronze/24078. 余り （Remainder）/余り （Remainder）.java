/*
문제
正の整数 X が与えられる．X を 21 で割った余りを出力せよ．

입력
入力は以下の形式で標準入力から与えられる．

X
출력
X を 21 で割った余りを出力せよ．

제한
1 ≦ X ≦ 100．
X は整数である．
예제 입력 1
50
예제 출력 1
8
50 を 21 で割った余りは 8 であるので，8 を出力する．
예제 입력 2
42
예제 출력 2
0
X が 21 で割り切れる場合もある．このとき余りは 0 であるので，0 を出力する．
예제 입력 3
5
예제 출력 3
5
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Integer.parseInt(br.readLine()) % 21);
    }
}

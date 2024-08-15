/*
문제
十進法で 2 桁の整数 N が与えられる．

N の十の位の数字と一の位の数字が同じである場合は 1 を，そうでない場合は 0 を出力せよ．

입력
入力は以下の形式で標準入力から与えられる．

N
출력
N の十の位の数字と一の位の数字が同じである場合は 1 を，そうでない場合は 0 を出力せよ．

제한
10 ≦ N ≦ 99．
N は整数である．
예제 입력 1
22
예제 출력 1
1
22 は十の位が 2 ，一の位が 2 と同じであるので，1 を出力する．

예제 입력 2
10
예제 출력 2
0
 */
package baekjoon.busyday.august;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ27324 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(n / 10 == n % 10 ? 1 : 0);
    }
}

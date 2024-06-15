/*
문제
一辺の長さが x cm の立方体の体積は (x × x × x) cm3 である．

整数 X が与えられる．一辺の長さが X cm の立方体の体積は何 cm3 か求めよ．

입력
入力は以下の形式で標準入力から与えられる．

X
출력
一辺の長さが X cm の立方体の体積が何 cm3 か，単位 (cm3) を省いて出力せよ．
 */
package baekjoon.busyday.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ24082 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(n * n * n);
    }
}

/*
문제
整数 H, M が与えられる．

H 時間 M 分が何分かを求めよ．

입력
入力は以下の形式で与えられる．

H
M
출력
H 時間 M 分が何分かを，単位 (分) を省いて出力せよ．

答え以外は何も出力しないこと．(入力を促す文章なども出力しないこと．)

제한
0 ≦ H ≦ 23．
0 ≦ M ≦ 59．
入力される値はすべて整数である．
예제 입력 1
8
30
예제 출력 1
510
8 時間 30 分は 510 分であるので，510 を出力する．
예제 입력 2
14
0
예제 출력 2
840
14 時間 0 分は 840 分であるので，840 を出力する．
예제 입력 3
0
29
예제 출력 3
29
0 時間 29 分は 29 分であるので，29 を出力する．
예제 입력 4
23
59
예제 출력 4
1439
 */
package baekjoon.busyday.august;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ31614 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int h = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        System.out.println(h * 60 + m);
    }
}

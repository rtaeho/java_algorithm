/*
문제
1 日は 24 時間である．

整数 X が与えられる． X 日は何時間か求めよ．

입력
入力は以下の形式で標準入力から与えられる．

X
출력
X 日は何時間か，単位 (時間) を省いて出力せよ．

제한
1 ≦ X ≦ 365．
X は整数である．
예제 입력 1 
3
예제 출력 1 
72
3 日は 72 時間であるから，72 を出力する．

예제 입력 2 
100
예제 출력 2 
2400
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println((n * 24));
    }
}

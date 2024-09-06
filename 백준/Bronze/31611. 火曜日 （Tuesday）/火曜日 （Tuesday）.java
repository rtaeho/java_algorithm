/*
문제
整数 X が与えられる．

今日は日曜日である．今日の X 日後が火曜日であるならば 1 を，そうでないならば 0 を出力せよ．

입력
入力は以下の形式で与えられる．

X
출력
今日の X 日後が火曜日であるならば 1 を，そうでないならば 0 を出力せよ．

答え以外は何も出力しないこと．(入力を促す文章なども出力しないこと．)

제한
1 ≦ X ≦ 100．
X は整数である．
예제 입력 1
2
예제 출력 1
1
今日の 2 日後は火曜日である．したがって，1 を出力する．
예제 입력 2
10
예제 출력 2
0
今日の 10 日後は水曜日であり，火曜日ではない．したがって，0 を出力する．
예제 입력 3
100
예제 출력 3
1
今日の 100 日後は火曜日である．したがって，1 を出力する．
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        System.out.println(x % 7 == 2 ? "1" : "0");

    }
}

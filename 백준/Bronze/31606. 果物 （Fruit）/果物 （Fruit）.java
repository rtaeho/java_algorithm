/*
문제
リンゴが X 個，ミカンが Y 個，バナナが 3 個ある．リンゴとミカンとバナナが合わせて何個あるかを求めよ．

입력
入力は以下の形式で与えられる．

X
Y
출력
リンゴとミカンとバナナが合わせて何個あるか，単位 (個) を省いて出力せよ．

結果以外は何も出力しないこと．(入力を促す文章なども出力しないこと．)

제한
0 ≦ X ≦ 100．
0 ≦ Y ≦ 100．
入力される値はすべて整数である．
예제 입력 1
2
4
예제 출력 1
9
リンゴが 2 個，ミカンが 4 個，バナナが 3 個ある．リンゴとミカンとバナナは合わせて 9 個あるため，9 を出力する．
예제 입력 2
15
30
예제 출력 2
48
リンゴとミカンとバナナは合わせて 48 個あるため，48 を出力する．
예제 입력 3
0
0
예제 출력 3
3
リンゴとミカンとバナナは合わせて 3 個あるため，3 を出力する．
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        System.out.println(x + y + 3);
    }
}

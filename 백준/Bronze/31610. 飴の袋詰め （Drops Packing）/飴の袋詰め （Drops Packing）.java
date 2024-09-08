/*
문제
1 個 A 円の飴を B 個と，C 円の袋を 1 つ買う．合計金額はいくらか求めよ．

입력
入力は以下の形式で与えられる．

A
B
C
출력
合計金額を，単位 (円) を省いて出力せよ．

答え以外は何も出力しないこと．(入力を促す文章なども出力しないこと．)

제한
1 ≦ A ≦ 100．
1 ≦ B ≦ 100．
1 ≦ C ≦ 100．
入力される値はすべて整数である．
예제 입력 1 
20
3
10
예제 출력 1 
70
1 個 20 円の飴を 3 個と， 10 円の袋を 1 つ買うとき，合計金額は 70 円なので，70 を出力する．
예제 입력 2 
70
2
100
예제 출력 2 
240
1 個 70 円の飴を 2 個と， 100 円の袋を 1 つ買うとき，合計金額は 240 円なので，240 を出力する．
예제 입력 3 
23
10
15
예제 출력 3 
245
1 個 23 円の飴を 10 個と， 15 円の袋を 1 つ買うとき，合計金額は 245 円なので，245 を出力する．
예제 입력 4 
100
100
100
예제 출력 4 
10100
1 個 100 円の飴を 100 個と， 100 円の袋を 1 つ買うとき，合計金額は 10100 円なので，10100 を出力する．
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int total = A * B + C;

        System.out.println(total);
    }
}

/*
문제
JOI 君の 1 年前の身長は A cm であった．JOI 君の今の身長は B cm である．

この 1 年間で JOI 君の身長は伸びたことがわかっている．

JOI 君のこの 1 年間の身長の伸びは何 cm であるか出力せよ．

입력
入力は以下の形式で標準入力から与えられる．

A
B
출력
JOI 君のこの 1 年間の身長の伸びは何 cm であるか，単位 (cm) を省いて出力せよ．

제한
100 ≦ A ＜ B ≦ 200．
入力される値はすべて整数である．
예제 입력 1
150
155
예제 출력 1
5
JOI 君の 1 年前の身長は 150 cm であり，JOI 君の今の身長は 155 cm である．JOI 君のこの 1 年間の身長の伸びは 5 cm であるので，5 を出力する．
예제 입력 2
100
101
예제 출력 2
1
예제 입력 3
100
200
예제 출력 3
100
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        System.out.println(b - a);
    }
}

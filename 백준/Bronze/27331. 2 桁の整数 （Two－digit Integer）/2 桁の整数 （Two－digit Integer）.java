/*
문제
2 つの数字 A, B が与えられる．

十の位が A であり，一の位が B である 2 桁の正の整数を出力せよ．

입력
入力は以下の形式で与えられる．

A
B
출력
十の位が A であり，一の位が B である 2 桁の正の整数を出力せよ．

제한
A は 1，2，3，4，5，6，7，8，9 のいずれかである．
B は 0，1，2，3，4，5，6，7，8，9 のいずれかである．
예제 입력 1
2
2
예제 출력 1
22
十の位が 2 であり，一の位が 2 である 2 桁の正の整数は 22 であるため，22 を出力する．

예제 입력 2
1
0
예제 출력 2
10
十の位が 1 であり，一の位が 0 である 2 桁の正の整数は 10 であるため，10 を出力する．

예제 입력 3
1
9
예제 출력 3
19
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        System.out.println(a * 10 + b);
    }
}

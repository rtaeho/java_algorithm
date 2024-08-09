/*
문제
HI-ARC 학회는 일상 속의 문장들을 수식으로 표현하는 것을 즐기는 특이한 문화를 가지고 있다.

HI-ARC 수식은 HI-ARC 학회에서 최근에 개발한 독특한 수식으로, 아래와 같은 규칙으로 계산한다.

 
$H$와
$I$의 곱이 첫 번째 항이다.
 
$A$와
$R$과
$C$의 곱이 두 번째 항이다.
결과값은 첫 번째 항에서 두 번째 항을 뺀 값이다.
각각의 문자에 대응되는 숫자가 입력될 때, 결과값을 출력하자!

입력
첫째 줄에 각 문자에 들어갈 값
$H, I, A, R, C$ (
$0 \leq H,I,A,R,C \leq 100$,
$H,I,A,R,C$는 정수) 가 공백을 사이에 두고 순서대로 주어진다.

출력
수식을 계산한 결과값을 출력한다.

예제 입력 1
4 6 1 2 3
예제 출력 1
18

 */
package baekjoon.busyday.august;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ28444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int I = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(H * I - A * R * C);
    }
}

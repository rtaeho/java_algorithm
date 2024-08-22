/*
문제
화은이는 제3회 SMUPC를 맞이하여 환영의 의미로 "WelcomeToSMUPC"가 반복적으로 적혀 있는 라벨지를 프린트했다. 라벨지에는 공백 없이 글자들이 이어져 있고 "WelcomeToSMUPC"의 마지막 글자인 C 이후에는 W부터 다시 "WelcomeToSMUPC"가 반복된다.
$N$번째 글자가 있는 곳까지 라벨지를 자르려 할 때,
$N$번째에는 어떤 글자가 있을지 구해보자.


[
$N$=15 일 때 라벨지를 자르는 위치 ]
입력
첫째 줄에
$N$(
$ 1 \leq N \leq 1\,000\,000$)이 주어진다.

출력
첫째 줄에
$N$번째에 해당하는 글자를 출력한다.

예제 입력 1
2
예제 출력 1
e
예제 입력 2
15
예제 출력 2
W
 */
package baekjoon.busyday.august;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ29699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n % 14 == 1) {
            System.out.println("W");
        } else if (n % 14 == 2 || n % 14 == 7) {
            System.out.println("e");
        } else if (n % 14 == 3) {
            System.out.println("l");
        } else if (n % 14 == 4) {
            System.out.println("c");
        } else if (n % 14 == 5 || n % 14 == 9) {
            System.out.println("o");
        } else if (n % 14 == 6) {
            System.out.println("m");
        } else if (n % 14 == 8) {
            System.out.println("T");
        } else if (n % 14 == 10) {
            System.out.println("S");
        } else if (n % 14 == 11) {
            System.out.println("M");
        } else if (n % 14 == 12) {
            System.out.println("U");
        } else if (n % 14 == 13) {
            System.out.println("P");
        } else if (n % 14 == 0) {
            System.out.println("C");
        }
        br.close();
    }

}

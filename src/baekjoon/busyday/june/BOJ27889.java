/*
문제
GEC에는 여러 학교가 있다. 각 학교의 약칭과 정식 명칭은 다음과 같다.

NLCS: North London Collegiate School
BHA: Branksome Hall Asia
KIS: Korea International School
SJA: St. Johnsbury Academy
학교 이름을 좋아하는 규빈이는, 학교 이름을 짧게 부르는 것을 싫어하기 때문에, 각 학교의 약칭이 주어졌을 때 정식 명칭을 출력하는 프로그램을 만들기로 하였다.

각 학교의 약칭이 주어졌을 때, 정식 명칭을 출력하는 프로그램을 작성하시오.

입력
첫 번째 줄에 학교의 약칭 중 하나가 주어진다.

출력
첫 번째 줄에 입력된 학교의 정식 명칭을 출력한다.

예제 입력 1
NLCS
예제 출력 1
North London Collegiate School

 */
package baekjoon.busyday.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ27889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s.equals("NLCS")) {
            System.out.println("North London Collegiate School");
        } else if (s.equals("BHA")) {
            System.out.println("Branksome Hall Asia");
        } else if (s.equals("KIS")) {
            System.out.println("Korea International School");
        } else if (s.equals("SJA")) {
            System.out.println("St. Johnsbury Academy");
        }
    }
}

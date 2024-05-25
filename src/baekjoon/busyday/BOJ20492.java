/*
문제
선린인터넷고등학교의 한 학생은 프로그래밍 대회에 참가하여 거액의 상금을 수상하는 영광을 누리게 되었다. 하지만, 이 학생이 상금 금액의 전부를 수령하게 되는 것은 아니다. 상금의 일부를 제세공과금으로 납부하고, 나머지 금액을 수령하게 된다.

일반적으로, 대회에서 상금을 받으면 전체 금액의 22%를 제세공과금으로 국가에 납부하고, 나머지 금액을 수령하게 된다. 하지만, 상금의 80%를 필요 경비로 인정하게 되면, 나머지 20% 중 22%만을 제세공과금으로 납부해도 된다.

대회 상금의 금액이 주어질 때, 다음 두 경우 각각에 대해 이 학생이 실제로 수령하는 금액을 구해보자.

전체 상금의 22%를 제세공과금으로 납부하는 경우
상금의 80%를 필요 경비로 인정받고, 나머지 금액 중 22%만을 제세공과금으로 납부하는 경우
입력
상금의 금액을 나타내는 하나의 정수
$N$이 주어진다.

출력
1번 경우에 대한 답과 2번 경우에 대한 답을 사이에 공백을 두고 출력한다.

제한
 
$1\,000 \le N \le 10\,000\,000$ 
 
$N$은
$1\,000$의 배수
예제 입력 1
10000000
예제 출력 1
7800000 9560000
예제 입력 2
1000
예제 출력 2
780 956
 */
package baekjoon.busyday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ20492 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int a = (int) (n * 0.78);
        int b = (int) (n * 0.8 + (n * 0.2) * 0.78);
        System.out.println(a);
        System.out.println(b);
    }
}

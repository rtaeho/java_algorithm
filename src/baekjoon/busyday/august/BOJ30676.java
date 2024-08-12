/*
문제
스타는 안에 별이 담긴 기계장치를 보았다. 기계장치 내부를 볼 수 없어 별을 구경할 순 없었지만, 기계장치에는 별빛의 파장을 알려주는 계기판이 있었다. 계기판에 표시된 파장의 값을 토대로 스타는 별의 색을 알아낼 수 있었다. 스타가 알아낸 별의 색은 무엇이었을까?

색상별 파장의 범위는 다음과 같다.

빨간색: 620nm 이상 780nm 이하
주황색: 590nm 이상 620nm 미만
노란색: 570nm 이상 590nm 미만
초록색: 495nm 이상 570nm 미만
파란색: 450nm 이상 495nm 미만
남색: 425nm 이상 450nm 미만
보라색: 380nm 이상 425nm 미만
입력
계기판에 표시된 별빛의 파장
$\lambda$ 가 주어진다. 파장은 항상 정수로 주어지며 단위는
$\textrm{nm}$이다.
$(380 \leq \lambda \leq 780)$ 

출력
별의 색을 출력한다. 빨간색이면 "Red", 주황색이면 "Orange", 노란색이면 "Yellow", 초록색이면 "Green", 파란색이면 "Blue", 남색이면 "Indigo", 보라색이면 "Violet"을 출력한다.

예제 입력 1
627
예제 출력 1
Red
예제 입력 2
516
예제 출력 2
Green
 */
package baekjoon.busyday.august;

import java.util.Scanner;

public class BOJ30676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (620 <= n && n <= 780) {
            System.out.println("Red");
        } else if (590 <= n && n < 620) {
            System.out.println("Orange");
        } else if (570 <= n && n < 590) {
            System.out.println("Yellow");
        } else if (495 <= n && n < 570) {
            System.out.println("Green");
        } else if (450 <= n && n < 495) {
            System.out.println("Blue");
        } else if (425 <= n && n < 450) {
            System.out.println("Indigo");
        } else if (380 <= n && n < 425) {
            System.out.println("Violet");
        }
        sc.close();
    }
}

/*
문제
양의 정수
$W$,
$H$가 주어진다. 밑변의 길이가
$W$이고, 높이가
$H$인 삼각형의 넓이를 구하시오.



입력
정수
$W$,
$H$가 공백으로 구분되어 주어진다.
$(1 \le W, H \le 100)$ 

출력
밑변의 길이가
$W$이고, 높이가
$H$인 삼각형의 넓이를 출력한다. 넓이는 항상 소수점 아래 첫 번째 자리까지 출력한다.

예제 입력 1
1 1
예제 출력 1
0.5
예제 입력 2
2 3
예제 출력 2
3.0
 */
package baekjoon.busyday;

import java.util.Scanner;

public class BOJ29751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double w = sc.nextDouble();
        double h = sc.nextDouble();
        double area = w * h / 2;

        System.out.println(String.format("%.1f", area));
        sc.close();
    }
}

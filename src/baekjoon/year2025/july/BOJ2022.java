/*
 * 문제
아래의 그림과 같이 높은 빌딩 사이를 따라 좁은 길이 나있다. 두 개의 사다리가 있는데 길이가 x인 사다리는 오른쪽 빌딩의 아래를 받침대로 하여 왼쪽 빌딩에 기대져 있고 길이가 y인 사다리는 왼쪽 빌딩의 아래를 받침대로 하여 오른쪽 빌딩에 기대져 있다. 그리고 두 사다리는 땅에서부터 정확하게 c인 지점에서 서로 교차한다. 그렇다면 두 빌딩은 얼마나 떨어져 있는 걸까?



입력
첫째 줄에 차례대로 x, y, c에 해당하는 양의 실수 세 개가 입력된다. 수는 소수점 여섯째 자리까지 주어질 수 있으며, 3,000,000,000보다 작거나 같다.

출력
두 빌딩사이에 너비가 되는 수치를 출력한다. 절대/상대 오차는 10-3까지 허용한다.

예제 입력 1 
30 40 10
예제 출력 1 
26.033
예제 입력 2 
12.619429 8.163332 3
예제 출력 2 
7.000
예제 입력 3 
10 10 3
예제 출력 3 
8.000
예제 입력 4 
10 10 1
예제 출력 4 
9.798
 */

package baekjoon.year2025.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());

        double left = 0;
        double right = Math.min(x, y);

        while (right - left > 1e-6) {
            double mid = (left + right) / 2;
            double h1 = Math.sqrt(x * x - mid * mid);
            double h2 = Math.sqrt(y * y - mid * mid);
            double h = (h1 * h2) / (h1 + h2);

            if (h >= c) {
                left = mid;
            } else {
                right = mid;
            }
        }

        System.out.println(String.format("%.3f", left));
    }
}
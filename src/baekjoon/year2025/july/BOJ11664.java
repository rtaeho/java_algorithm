/*
 * 문제
3차원 좌표 평면 위에 선분 하나와 점 하나가 있다. 선분의 양 끝점은 A(Ax, Ay, Az)와 B(Bx, By, Bz)로 나타낼 수 있다. 점의 좌표는 C(Cx, Cy, Cz) 이다.

선분과 점 사이의 거리의 최솟값을 구하는 프로그램을 작성하시오.

두 점 (x1, y1, z1)과 (x2, y2, z2) 사이의 거리는 
\(\sqrt{(x2-x1)^2+(y2-y1)^2+(z2-z1)^2}\) 이다.

입력
첫째 줄에 선분과 점의 좌표 Ax, Ay, Az, Bx, By, Bz, Cx, Cy, Cz가 주어진다. 좌표는 0보다 크거나 같고, 10,000보다 작거나 같은 정수이다.

출력
첫째 줄에 선분과 점 사이의 거리의 최솟값을 출력한다. 절대/상대 오차는 10-6까지 허용한다.

예제 입력 1 
0 0 0 1 1 1 2 2 2
예제 출력 1 
1.7320508076
예제 입력 2 
0 0 0 10 10 10 5 5 5
예제 출력 2 
0.0000000000
예제 입력 3 
10 20 30 40 50 60 45 35 25
예제 출력 3 
28.2842712475
예제 입력 4 
0 0 0 1 1 1 0 0 1
예제 출력 4 
0.8164965809
예제 입력 5 
0 0 0 1 0 1 0 1 0
예제 출력 5 
1.0000000000
예제 입력 6 
0 0 0 1 1 1 7 6 5
예제 출력 6 
8.7749643874
 */
package baekjoon.year2025.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11664 {
    static class Point {
        double x, y, z;

        Point(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        double distanceTo(Point other) {
            return Math.sqrt(Math.pow(x - other.x, 2) +
                    Math.pow(y - other.y, 2) +
                    Math.pow(z - other.z, 2));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Point A = new Point(Double.parseDouble(st.nextToken()),
                Double.parseDouble(st.nextToken()),
                Double.parseDouble(st.nextToken()));
        Point B = new Point(Double.parseDouble(st.nextToken()),
                Double.parseDouble(st.nextToken()),
                Double.parseDouble(st.nextToken()));
        Point C = new Point(Double.parseDouble(st.nextToken()),
                Double.parseDouble(st.nextToken()),
                Double.parseDouble(st.nextToken()));

        // 삼분 탐색을 사용하여 최소 거리를 찾습니다
        double lo = 0, hi = 1;
        for (int i = 0; i < 10000; i++) {
            double p = (2 * lo + hi) / 3;
            double q = (lo + 2 * hi) / 3;

            if (getDistance(A, B, C, p) > getDistance(A, B, C, q)) {
                lo = p;
            } else {
                hi = q;
            }
        }

        System.out.printf("%.10f%n", getDistance(A, B, C, lo));
    }

    // t는 0에서 1 사이의 값으로, 선분 AB 위의 한 점을 나타냅니다
    static double getDistance(Point A, Point B, Point C, double t) {
        double x = A.x + (B.x - A.x) * t;
        double y = A.y + (B.y - A.y) * t;
        double z = A.z + (B.z - A.z) * t;
        return new Point(x, y, z).distanceTo(C);
    }
}
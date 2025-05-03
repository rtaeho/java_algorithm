/*
문제
하나의 좌표평면은 다음과 같이 네 개의 사분면으로 나뉜다.



그러면, 각각의 사분면을 다시 사분면으로 나누어 번호를 붙여 보면 어떨까? 예를 들어 1번 사분면의 1번 사분면은 11번 사분면, 3번 사분면의 2번 사분면은 32번 사분면이라고 하면 좋지 않을까? 물론 한 번 더 나눠 볼 수도 있겠다. 3번 사분면의 4번 사분면의 1번 사분면은 341번 사분면이다.



사분면의 번호 길이가 길어짐에 따라 각각의 사분면의 크기는 급격히 작아지며, 그 개수는 기하급수적으로 증가한다.

사분면에 번호를 붙이는 이러한 규칙을 상정하고서, 어떤 사분면 조각을 이동시켰을 때, 그 조각이 위치하게 되는 사분면의 번호가 궁금하다. 예를 들어, 341번 사분면을 오른쪽으로 두 번, 위쪽으로 한 번 이동시키면 424번 사분면에 온다.



하나의 사분면 조각을 이동시켰을 때, 그 조각이 도착한 사분면의 번호를 알아내는 프로그램을 작성하라.

입력
첫 줄에 이동시키려는 사분면 조각 번호의 자릿수를 나타내는 정수 d와, 그 사분면 조각의 번호가 주어진다. (1 ≤ d ≤ 50) 둘째 줄에는 이동의 내용을 나타내는 두 정수가 x, y가 주어진다. (|x|, |y| ≤ 250) 오른쪽으로 이동한 경우 x가 양수, 왼쪽으로 이동한 경우 음수이며, 그 절댓값은 오른쪽 왼쪽 방향 이동 횟수를 나타낸다. 위쪽으로 이동한 경우 y가 양수, 아래쪽으로 이동한 경우 음수이며, 역시 그 절댓값은 아래위 방향 이동 횟수를 나타낸다.

출력
첫 줄에 도착한 사분면의 번호를 출력한다. 만약, 존재하지 않는 사분면인 경우에는 -1을 출력한다.

예제 입력 1
3 341
2 1
예제 출력 1
424
 */
package baekjoon.year2025.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1891 {
    static String findNum_s;
    static int d;
    static long x, y;
    static long find_x = 0;
    static long find_y = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        d = Integer.parseInt(st.nextToken());
        findNum_s = st.nextToken();

        st = new StringTokenizer(br.readLine());
        y = Long.parseLong(st.nextToken()); // 위아래
        x = Long.parseLong(st.nextToken()); // 좌우

        long size = 1L << d; // 전체 맵 크기
        findPosition(0, 0, 0, size, size);

        find_x -= x;
        find_y += y;

        if (0 <= find_x && find_x < size && 0 <= find_y && find_y < size) {
            getQuadrant(d, find_x, find_y);
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }

    static void findPosition(int idx, long lx, long ly, long rx, long ry) {
        if (idx == d) {
            find_x = lx;
            find_y = ly;
            return;
        }

        int num = findNum_s.charAt(idx) - '0';
        long mx = (lx + rx) / 2;
        long my = (ly + ry) / 2;

        switch (num) {
            case 1:
                findPosition(idx + 1, lx, my, mx, ry);
                break;
            case 2:
                findPosition(idx + 1, lx, ly, mx, my);
                break;
            case 3:
                findPosition(idx + 1, mx, ly, rx, my);
                break;
            case 4:
                findPosition(idx + 1, mx, my, rx, ry);
                break;
        }
    }

    static void getQuadrant(int len, long tx, long ty) {
        if (len == 0) {
            return;
        }

        long half = 1L << (len - 1);

        if (tx < half && ty >= half) {
            sb.append("1");
            getQuadrant(len - 1, tx, ty - half);
        } else if (tx < half && ty < half) {
            sb.append("2");
            getQuadrant(len - 1, tx, ty);
        } else if (tx >= half && ty < half) {
            sb.append("3");
            getQuadrant(len - 1, tx - half, ty);
        } else {
            sb.append("4");
            getQuadrant(len - 1, tx - half, ty - half);
        }
    }
}
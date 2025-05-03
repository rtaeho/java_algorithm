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

import java.io.*;

public class BOJ1891 {

    static int d;
    static String code;
    static int dx, dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력
        String[] input = br.readLine().split(" ");
        d = Integer.parseInt(input[0]);
        code = input[1];

        String[] move = br.readLine().split(" ");
        dx = Integer.parseInt(move[0]);
        dy = Integer.parseInt(move[1]);

        // 2. 사분면 번호 → 좌표
        long size = 1L << d; // 2^d
        long x = 0, y = 0;

        for (int i = 0; i < d; i++) {
            size /= 2;
            char ch = code.charAt(i);
            if (ch == '1') {
                x += size;
                y += size;
            } else if (ch == '2') {
                y += size;
            } else if (ch == '3') {
                // nothing
            } else if (ch == '4') {
                x += size;
            }
        }

        // 3. 이동
        x += dx;
        y += dy;

        long max = 1L << d;
        if (x < 0 || y < 0 || x >= max || y >= max) {
            System.out.println(-1);
            return;
        }

        // 4. 좌표 → 사분면 번호
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < d; i++) {
            max /= 2;
            if (x >= max && y >= max) {
                sb.append('1');
                x -= max;
                y -= max;
            } else if (x < max && y >= max) {
                sb.append('2');
                y -= max;
            } else if (x < max && y < max) {
                sb.append('3');
            } else { // x >= max && y < max
                sb.append('4');
                x -= max;
            }
        }

        System.out.println(sb);
    }
}
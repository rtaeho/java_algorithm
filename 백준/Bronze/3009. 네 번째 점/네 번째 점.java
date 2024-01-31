/*
문제
세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.

입력
세 점의 좌표가 한 줄에 하나씩 주어진다. 좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.

출력
직사각형의 네 번째 점의 좌표를 출력한다.

예제 입력 1
5 5
5 7
7 5
예제 출력 1
7 7
예제 입력 2
30 20
10 10
10 20
예제 출력 2
30 10

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());

        int x;
        int y;

        if (x1 == x2) {
            x = x3;
        } else if (x1 == x3) {
            x = x2;
        } else {
            x = x1;
        }

        if (y1 == y2) {
            y = y3;
        } else if (y1 == y3) {
            y = y2;
        } else {
            y = y1;
        }

        System.out.println(x + " " + y);
        br.close();
    }
}

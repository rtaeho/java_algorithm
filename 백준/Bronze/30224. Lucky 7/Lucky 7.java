/*
문제
Fact or Fiction, some people consider 7 to be a lucky digit/number.

Given a number, determine how lucky the number is by printing one of four values:

Print 0 if the number does not contain 7 and is not divisible by 7.
Print 1 if the number does not contain 7 but is divisible by 7.
Print 2 if the number does contain 7 but is not divisible by 7.
Print 3 if the number does contain 7 and is divisible by 7.
입력
There is only one input line; it contains an integer between 1 and 109, inclusive.

출력
Print one of the four messages as described above.

예제 입력 1
25
예제 출력 1
0
예제 입력 2
42
예제 출력 2
1
예제 입력 3
170
예제 출력 3
2
예제 입력 4
777
예제 출력 4
3
예제 입력 5
1
예제 출력 5
0
예제 입력 6
70
예제 출력 6
3
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(bf.readLine());

        if (check(num)) { // 7이 포함된다면
            if (num % 7 != 0) { // 7로 나뉘지 않는다면
                bw.write(2 + "\n");
            } else { // 나뉜다면
                bw.write(3 + "\n");
            }
        } else { // 포함 안된다면
            if (num % 7 != 0) {
                bw.write(0 + "\n");
            } else {
                bw.write(1 + "\n");
            }
        }


        bw.flush();
        bw.close();

    }

    public static boolean check(int num) {
        return Integer.toString(num).contains("7");
    } // 숫자 -> 문자열 변환 뒤, 7 포함 여부를 반환

}

/*
문제
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 A와 B (-1010000 ≤ A, B ≤ 1010000)가 주어진다.

출력
첫째 줄에 A+B를 출력한다.

서브태스크
번호	배점	제한
1	5
0 ≤ A, B ≤ 10

2	10
-100 ≤ A, B ≤ 100

3	10
0 ≤ A, B ≤ 109

4	15
-109 ≤ A, B ≤ 109

5	15
0 ≤ A, B ≤ 260

6	20
-260 ≤ A, B ≤ 260

7	20
0 ≤ A, B ≤ 1010000

8	5
-1010000 ≤ A, B ≤ 1010000

예제 입력 1
1 2
예제 출력 1
3
예제 입력 2
-60 40
예제 출력 2
-20
예제 입력 3
-999999999 1000000000
예제 출력 3
1
예제 입력 4
1099511627776 1073741824
예제 출력 4
1100585369600
예제 입력 5
123456789123456789123456789 987654321987654321987654321
예제 출력 5
1111111111111111111111111110
 */
package baekjoon.busyday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ15740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());
        System.out.print(a.add(b));
    }
}

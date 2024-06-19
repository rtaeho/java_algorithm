/*
문제
당신은 싸이컴을 향해 절을 하려고 합니다. 하지만, 당신이 싸이컴에 들어오고 싶어서 절을 한 번 할 수도 있고, 싸이컴을 매우 싫어해 절을 두 번 할 수도 있습니다.

당신이 절을 할 횟수가 주어질 때, 그 횟수만큼 절하는 프로그램을 작성하세요. 실제로 프로그램을 이용해 절을 할 수는 없기 때문에, 대신 “SciComLove”를 출력하도록 합니다.

입력
첫 줄에 정수
$N$이 주어집니다.

출력
"SciComLove"를 예제와 같이
$N$번 출력합니다. 단, 따옴표는 출력하지 않습니다.

제한
 
$1 \le N \le 2$ 
서브태스크
번호	배점	제한
1	40
 
$N = 1$ 

2	40
 
$N = 2$ 

3	20
추가 제한 조건이 없습니다.

예제 입력 1
1
예제 출력 1
SciComLove
예제 입력 2
2
예제 출력 2
SciComLove
SciComLove
 */
package baekjoon.busyday.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ21598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            sb.append("SciComLove").append("\n");
        }
        System.out.print(sb);
    }
}

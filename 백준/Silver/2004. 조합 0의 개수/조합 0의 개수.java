/*
문제
 
$n \choose m$의 끝자리 
$0$의 개수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 
$n$, 
$m$ (
$0 \le m \le n \le 2,000,000,000$, 
$n \ne 0$)이 들어온다.

출력
첫째 줄에 
$n \choose m$의 끝자리 
$0$의 개수를 출력한다.

예제 입력 1 
25 12
예제 출력 1 
2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        // 각각의 승수를 구해준다.
        long count5 = five_power_n(N) - five_power_n(N - M) - five_power_n(M);
        long count2 = two_power_n(N) - two_power_n(N - M) - two_power_n(M);
        System.out.println(Math.min(count5, count2));

    }

    // 5의 승수를 구하는 함수
    static long five_power_n(long num) {
        int count = 0;

        while (num >= 5) {
            count += (num / 5);
            num /= 5;
        }
        return count;
    }

    // 2의 승수를 구하는 함수
    static long two_power_n(long num) {
        int count = 0;

        while (num >= 2) {
            count += (num / 2);
            num /= 2;
        }
        return count;
    }

}

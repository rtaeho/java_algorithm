/*
문제
주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

입력
첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

출력
주어진 수들 중 소수의 개수를 출력한다.

예제 입력 1
4
1 3 5 7
예제 출력 1
3
 */
package baekjoon.practice.factorsmultiplesanddecimals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1978 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            for (int p = 2; p <= num; p++) {
                if (p == num) {
                    cnt++;
                }
                if (num % p == 0) {
                    break;
                }
            }
        }
        System.out.println(cnt);
        br.close();
    }
}

/*
문제
1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.

1234567891011121314151617181920212223...

이렇게 만들어진 새로운 수에서, 앞에서 k번째 자리 숫자가 어떤 숫자인지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 100,000,000)과, k(1 ≤ k ≤ 1,000,000,000)가 주어진다. N과 k 사이에는 공백이 하나 이상 있다.

출력
첫째 줄에 앞에서 k번째 자리 숫자를 출력한다. 수의 길이가 k보다 작아서 k번째 자리 숫자가 없는 경우는 -1을 출력한다.

예제 입력 1
20 23
예제 출력 1
6
 */
package baekjoon.year2025.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1709 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long len = 1;
        long count = 9;
        long start = 1;

        while (k > len * count && start + count - 1 <= N) {
            k -= len * count;
            start *= 10;
            len++;
            count *= 10;
        }

        long end = Math.min(N, start + count - 1);

        long numberIndex = (k - 1) / len;
        long digitIndex = (k - 1) % len;

        long target = start + numberIndex;

        if (target > end) {
            System.out.println(-1);
        } else {
            System.out.println(Long.toString(target).charAt((int) digitIndex));
        }
    }
}
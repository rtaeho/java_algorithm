/*
최대공약수와 최소공배수
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	108119	62379	50767	57.844%
문제
두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.

출력
첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.

예제 입력 1
24 18
예제 출력 1
6
72
 */
package baekjoon.basic_algorithm_1.math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int max = Math.min(A, B);
        int min = Math.max(A, B);
        for (int i = 1; i <= Math.min(A, B); i++) {
            if (A % i == 0 && B % i == 0) {
                max = i;
            }
        }
        System.out.println(max);
        int i;
        for (i = Math.max(A, B); !(i % A == 0 && i % B == 0); i++) {
        }
        System.out.println(i);
    }
    /*
    public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int d = gcd(a, b);	// 최대공약수

		System.out.println(d);
		System.out.println(a * b / d);

	}

	// 최대공약수 재귀 방식
	public static int gcd(int a, int b) {
		if (b == 0)
			return a;

		// GCD(a, b) = GCD(b, r)이므로 (r = a % b)
		return gcd(b, a % b);
	}
     */
}

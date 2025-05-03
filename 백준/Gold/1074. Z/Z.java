/*
문제
한수는 크기가 2N × 2N인 2차원 배열을 Z모양으로 탐색하려고 한다. 예를 들어, 2×2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.



N > 1인 경우, 배열을 크기가 2N-1 × 2N-1로 4등분 한 후에 재귀적으로 순서대로 방문한다.

다음 예는 22 × 22 크기의 배열을 방문한 순서이다.



N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.

다음은 N=3일 때의 예이다.



입력
첫째 줄에 정수 N, r, c가 주어진다.

출력
r행 c열을 몇 번째로 방문했는지 출력한다.

제한
1 ≤ N ≤ 15
0 ≤ r, c < 2N
예제 입력 1
2 3 1
예제 출력 1
11
예제 입력 2
3 7 7
예제 출력 2
63
예제 입력 3
1 0 0
예제 출력 3
0
예제 입력 4
4 7 7
예제 출력 4
63
예제 입력 5
10 511 511
예제 출력 5
262143
예제 입력 6
10 512 512
예제 출력 6
786432문제
한수는 크기가 2N × 2N인 2차원 배열을 Z모양으로 탐색하려고 한다. 예를 들어, 2×2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.



N > 1인 경우, 배열을 크기가 2N-1 × 2N-1로 4등분 한 후에 재귀적으로 순서대로 방문한다.

다음 예는 22 × 22 크기의 배열을 방문한 순서이다.



N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.

다음은 N=3일 때의 예이다.



입력
첫째 줄에 정수 N, r, c가 주어진다.

출력
r행 c열을 몇 번째로 방문했는지 출력한다.

제한
1 ≤ N ≤ 15
0 ≤ r, c < 2N
예제 입력 1
2 3 1
예제 출력 1
11
예제 입력 2
3 7 7
예제 출력 2
63
예제 입력 3
1 0 0
예제 출력 3
0
예제 입력 4
4 7 7
예제 출력 4
63
예제 입력 5
10 511 511
예제 출력 5
262143
예제 입력 6
10 512 512
예제 출력 6
786432
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(getOrder(N, r, c));
    }

    // Z 탐색에서 (r, c)가 몇 번째로 방문되는가?
    static int getOrder(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }

        int half = 1 << (n - 1); // 2^(n-1)
        int blockSize = half * half;

        if (r < half && c < half) { // 1사분면 (왼쪽 위)
            return getOrder(n - 1, r, c);
        } else if (r < half && c >= half) { // 2사분면 (오른쪽 위)
            return blockSize + getOrder(n - 1, r, c - half);
        } else if (r >= half && c < half) { // 3사분면 (왼쪽 아래)
            return 2 * blockSize + getOrder(n - 1, r - half, c);
        } else { // 4사분면 (오른쪽 아래)
            return 3 * blockSize + getOrder(n - 1, r - half, c - half);
        }
    }
}
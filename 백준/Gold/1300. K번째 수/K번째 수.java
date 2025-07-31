/*
 * 문제
세준이는 크기가 N×N인 배열 A를 만들었다. 배열에 들어있는 수 A[i][j] = i×j 이다. 이 수를 일차원 배열 B에 넣으면 B의 크기는 N×N이 된다. B를 오름차순 정렬했을 때, B[k]를 구해보자.

배열 A와 B의 인덱스는 1부터 시작한다.

입력
첫째 줄에 배열의 크기 N이 주어진다. N은 105보다 작거나 같은 자연수이다. 둘째 줄에 k가 주어진다. k는 min(109, N2)보다 작거나 같은 자연수이다.

출력
B[k]를 출력한다.

예제 입력 1 
3
7
예제 출력 1 
6
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long k = Long.parseLong(br.readLine());

        long left = 1;
        long right = k;
        long answer = 0;

        // 이분 탐색
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            // mid보다 작거나 같은 수의 개수 계산
            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }

            if (count < k) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}

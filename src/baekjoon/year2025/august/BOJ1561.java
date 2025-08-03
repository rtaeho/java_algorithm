/*
 *
 * 문제
N명의 아이들이 한 줄로 줄을 서서 놀이공원에서 1인승 놀이기구를 기다리고 있다. 이 놀이공원에는 총 M종류의 1인승 놀이기구가 있으며, 1번부터 M번까지 번호가 매겨져 있다.

모든 놀이기구는 각각 운행 시간이 정해져 있어서, 운행 시간이 지나면 탑승하고 있던 아이는 내리게 된다. 놀이 기구가 비어 있으면 현재 줄에서 가장 앞에 서 있는 아이가 빈 놀이기구에 탑승한다. 만일 여러 개의 놀이기구가 동시에 비어 있으면, 더 작은 번호가 적혀 있는 놀이기구를 먼저 탑승한다고 한다.

놀이기구가 모두 비어 있는 상태에서 첫 번째 아이가 놀이기구에 탑승한다고 할 때, 줄의 마지막 아이가 타게 되는 놀이기구의 번호를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 2,000,000,000)과 M(1 ≤ M ≤ 10,000)이 빈칸을 사이에 두고 주어진다. 둘째 줄에는 각 놀이기구의 운행 시간을 나타내는 M개의 자연수가 순서대로 주어진다. 운행 시간은 1 이상 30 이하의 자연수이며, 단위는 분이다.

출력
첫째 줄에 마지막 아이가 타게 되는 놀이기구의 번호를 출력한다.

예제 입력 1 
3 5
7 8 9 7 8
예제 출력 1 
3
예제 입력 2 
7 2
3 2
예제 출력 2 
2
예제 입력 3 
22 5
1 2 3 4 5
예제 출력 3 
4 
 */
package baekjoon.year2025.august;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1561 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] rides = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            rides[i] = Integer.parseInt(st.nextToken());
        }

        // N이 M보다 작거나 같으면 N번째 놀이기구를 타게 됨
        if (N <= M) {
            System.out.println(N);
            return;
        }

        // 이분 탐색으로 마지막 아이가 타는 시간을 찾음
        long left = 0;
        long right = N * 30L; // 최대 시간
        long time = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = M; // 처음 M명은 0분에 탑승

            // mid 시간까지 탑승한 아이들의 수 계산
            for (int i = 0; i < M; i++) {
                count += mid / rides[i];
            }

            if (count >= N) {
                time = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // time-1분까지 탑승한 아이들의 수 계산
        long before = M;
        for (int i = 0; i < M; i++) {
            before += (time - 1) / rides[i];
        }

        // time분에 탑승하는 아이들 중 마지막 아이가 타는 놀이기구 찾기
        for (int i = 0; i < M; i++) {
            if (time % rides[i] == 0) { // time분에 비는 놀이기구
                before++;
                if (before == N) {
                    System.out.println(i + 1);
                    break;
                }

            }
        }
    }
}

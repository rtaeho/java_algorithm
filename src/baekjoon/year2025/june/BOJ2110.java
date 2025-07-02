/*
문제
도현이의 집 N개가 수직선 위에 있다. 각각의 집의 좌표는 x1, ..., xN이고, 집 여러개가 같은 좌표를 가지는 일은 없다.

도현이는 언제 어디서나 와이파이를 즐기기 위해서 집에 공유기 C개를 설치하려고 한다. 최대한 많은 곳에서 와이파이를 사용하려고 하기 때문에, 한 집에는 공유기를 하나만 설치할 수 있고, 가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치하려고 한다.

C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램을 작성하시오.

입력
첫째 줄에 집의 개수 N (2 ≤ N ≤ 200,000)과 공유기의 개수 C (2 ≤ C ≤ N)이 하나 이상의 빈 칸을 사이에 두고 주어진다. 둘째 줄부터 N개의 줄에는 집의 좌표를 나타내는 xi (0 ≤ xi ≤ 1,000,000,000)가 한 줄에 하나씩 주어진다.

출력
첫째 줄에 가장 인접한 두 공유기 사이의 최대 거리를 출력한다.

예제 입력 1 
5 3
1
2
8
4
9
예제 출력 1 
3
 */
package baekjoon.year2025.june;

import java.io.*;
import java.util.*;

public class BOJ2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        // 이진 탐색을 위해 정렬
        Arrays.sort(houses);

        // 최소 거리는 1, 최대 거리는 마지막 집 - 첫 집
        int left = 1;
        int right = houses[N - 1] - houses[0];
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canInstall(houses, mid, C)) {
                result = mid;
                left = mid + 1; // 더 큰 거리 탐색
            } else {
                right = mid - 1; // 더 작은 거리 탐색
            }
        }

        System.out.println(result);
    }

    // 주어진 거리로 C개 이상의 공유기를 설치할 수 있는지 확인
    private static boolean canInstall(int[] houses, int distance, int C) {
        int count = 1; // 첫 번째 집에 무조건 설치
        int lastInstalled = houses[0];

        for (int i = 1; i < houses.length; i++) {
            if (houses[i] - lastInstalled >= distance) {
                count++;
                lastInstalled = houses[i];
            }
        }
        return count >= C;
    }
}

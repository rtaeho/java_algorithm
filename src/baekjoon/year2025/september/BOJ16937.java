/*
 * 문제
크기가 H×W인 모눈종이와 스티커 N개가 있다. i번째 스티커의 크기는 Ri×Ci이다. 모눈종이는 크기가 1×1인 칸으로 나누어져 있으며, 간격 1을 두고 선이 그어져 있다.

오늘은 모눈종이에 스티커 2개를 붙이려고 한다. 스티커의 변은 격자의 선과 일치하게 붙여야 하고, 두 스티커가 서로 겹치면 안 된다. 단, 스티커가 접하는 것은 가능하다. 스티커를 90도 회전시키는 것은 가능하다. 스티커가 모눈종이를 벗어나는 것은 불가능하다.

두 스티커가 붙여진 넓이의 최댓값을 구해보자.

입력
첫째 줄에 모눈종이의 크기 H, W, 둘째 줄에 스티커의 수 N이 주어진다. 다음 N개의 줄에는 스티커의 크기 Ri, Ci가 주어진다.

출력
첫째 줄에 두 스티커가 붙여진 넓이의 최댓값을 출력한다. 두 스티커를 붙일 수 없는 경우에는 0을 출력한다.


제한
1 ≤ H, W, N ≤ 100
1 ≤ Ri, Ci ≤ 100
예제 입력 1 
2 2
2
1 2
2 1
예제 출력 1 
4
예제 입력 2 
10 9
4
2 3
1 1
5 10
9 11
예제 출력 2 
56
예제 입력 3 
10 10
3
6 6
7 7
20 5
예제 출력 3 
0
 */
package baekjoon.year2025.september;

import java.io.*;
import java.util.*;

public class BOJ16937 {
    static int H, W, N;
    static int[][] stickers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());

        stickers = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stickers[i][0] = Integer.parseInt(st.nextToken());
            stickers[i][1] = Integer.parseInt(st.nextToken());
        }

        int maxArea = 0;

        // 모든 스티커 쌍을 확인
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                // 각 스티커의 4가지 회전 상태를 확인
                int[][] orientations1 = {
                        { stickers[i][0], stickers[i][1] }, // 원본
                        { stickers[i][1], stickers[i][0] } // 90도 회전
                };

                int[][] orientations2 = {
                        { stickers[j][0], stickers[j][1] }, // 원본
                        { stickers[j][1], stickers[j][0] } // 90도 회전
                };

                for (int[] ori1 : orientations1) {
                    for (int[] ori2 : orientations2) {
                        if (canPlace(ori1[0], ori1[1], ori2[0], ori2[1])) {
                            int area = ori1[0] * ori1[1] + ori2[0] * ori2[1];
                            maxArea = Math.max(maxArea, area);
                        }
                    }
                }
            }
        }

        System.out.println(maxArea);
    }

    // 두 스티커를 겹치지 않게 붙일 수 있는지 확인
    static boolean canPlace(int r1, int c1, int r2, int c2) {
        // 첫 번째 스티커가 모눈종이를 벗어나는 경우
        if (r1 > H || c1 > W)
            return false;
        // 두 번째 스티커가 모눈종이를 벗어나는 경우
        if (r2 > H || c2 > W)
            return false;

        // 경우 1: 가로로 나란히 배치 (스티커1 + 스티커2)
        if (c1 + c2 <= W && Math.max(r1, r2) <= H) {
            return true;
        }

        // 경우 2: 세로로 나란히 배치 (스티커1 위에 스티커2)
        if (r1 + r2 <= H && Math.max(c1, c2) <= W) {
            return true;
        }
        return false;
    }
}
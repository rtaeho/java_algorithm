/*
문제
상근이는 어렸을 적에 "봄보니 (Bomboni)" 게임을 즐겨했다.

가장 처음에 N×N크기에 사탕을 채워 놓는다. 사탕의 색은 모두 같지 않을 수도 있다. 상근이는 사탕의 색이 다른 인접한 두 칸을 고른다. 그 다음 고른 칸에 들어있는 사탕을 서로 교환한다. 이제, 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹는다.

사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의 최대 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 보드의 크기 N이 주어진다. (3 ≤ N ≤ 50)

다음 N개 줄에는 보드에 채워져 있는 사탕의 색상이 주어진다. 빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y로 주어진다.

사탕의 색이 다른 인접한 두 칸이 존재하는 입력만 주어진다.

출력
첫째 줄에 상근이가 먹을 수 있는 사탕의 최대 개수를 출력한다.

예제 입력 1
3
CCP
CCP
PPC
예제 출력 1
3
예제 입력 2
4
PPPP
CYZY
CCPY
PPCC
예제 출력 2
4
예제 입력 3
5
YCPZY
CYZZP
CCPPP
YCYZC
CPPZZ
예제 출력 3
4
힌트
예제 3의 경우 4번 행의 Y와 C를 바꾸면 사탕 네 개를 먹을 수 있다.
 */
package baekjoon.basic_algorithm_2.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3085 {
    static int N;
    static char[][] arr;
    static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(i, j, i, j + 1);
                find();
                swap(i, j + 1, i, j);
            }
        } // 열바꿈
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                swap(i, j, i + 1, j);
                find();
                swap(i + 1, j, i, j);
            }
        } // 행바꿈
        System.out.println(max);
    }

    public static void swap(int i1, int j1, int i2, int j2) {
        char tmp = arr[i1][j1];
        arr[i1][j1] = arr[i2][j2];
        arr[i2][j2] = tmp;
    }

    public static void find() {
        int cnt;
        for (int i = 0; i < N; i++) {
            cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) {
                    cnt++;
                    max = Math.max(cnt, max);
                } else cnt = 1;
            }
        }

        for (int i = 0; i < N; i++) {
            cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (arr[j][i] == arr[j + 1][i]) {
                    cnt++;
                    max = Math.max(cnt, max);
                } else cnt = 1;
            }
        }

    }
}

/*
문제
0과 1로만 이루어진 행렬 A와 행렬 B가 있다. 이때, 행렬 A를 행렬 B로 바꾸는데 필요한 연산의 횟수의 최솟값을 구하는 프로그램을 작성하시오.

행렬을 변환하는 연산은 어떤 3×3크기의 부분 행렬에 있는 모든 원소를 뒤집는 것이다. (0 → 1, 1 → 0)

입력
첫째 줄에 행렬의 크기 N M이 주어진다. N과 M은 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 행렬 A가 주어지고, 그 다음줄부터 N개의 줄에는 행렬 B가 주어진다.

출력
첫째 줄에 문제의 정답을 출력한다. 만약 A를 B로 바꿀 수 없다면 -1을 출력한다.

예제 입력 1
3 4
0000
0010
0000
1001
1011
1001
예제 출력 1
2
예제 입력 2
3 3
111
111
111
000
000
000
예제 출력 2
1
예제 입력 3
1 1
1
0
예제 출력 3
-1
예제 입력 4
18 3
001
100
100
000
011
010
100
100
010
010
010
110
101
101
000
110
000
110
001
100
011
000
100
010
011
100
101
101
010
001
010
010
111
110
111
001
예제 출력 4
7
 */
package baekjoon.year2025.march;

import java.io.*;
import java.util.*;

public class BOJ1080 {
    static int N, M;
    static int[][] A, B;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        A = new int[N][M];
        B = new int[N][M];
        
        // 행렬 A 입력
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                A[i][j] = line.charAt(j) - '0';
            }
        }
        
        // 행렬 B 입력
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                B[i][j] = line.charAt(j) - '0';
            }
        }
        
        System.out.println(solve());
    }
    
    static int solve() {
        // 3x3 행렬로 변환할 수 없는 경우
        if(N < 3 || M < 3) {
            return isEqual() ? 0 : -1;
        }
        
        int count = 0;
        
        // 왼쪽 상단부터 3x3 영역을 확인
        for(int i = 0; i <= N-3; i++) {
            for(int j = 0; j <= M-3; j++) {
                // 현재 위치의 원소가 다르면 3x3 뒤집기 연산 수행
                if(A[i][j] != B[i][j]) {
                    flip(i, j);
                    count++;
                }
            }
        }
        return isEqual() ? count : -1;
    }
    
    // 3x3 영역의 모든 원소를 뒤집는 메서드
    static void flip(int x, int y) {
        for(int i = x; i < x+3; i++) {
            for(int j = y; j < y+3; j++) {
                A[i][j] = 1 - A[i][j];
            }
        }
    }
    // 행렬 A와 B가 같은지 확인하는 메서드
    static boolean isEqual() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(A[i][j] != B[i][j]) return false;
            }
        }
        return true;
    }
}

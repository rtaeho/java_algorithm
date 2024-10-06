/*
문제
Two Dots는 Playdots, Inc.에서 만든 게임이다. 게임의 기초 단계는 크기가 N×M인 게임판 위에서 진행된다.



각각의 칸은 색이 칠해진 공이 하나씩 있다. 이 게임의 핵심은 같은 색으로 이루어진 사이클을 찾는 것이다.

다음은 위의 게임판에서 만들 수 있는 사이클의 예시이다.


점 k개 d1, d2, ..., dk로 이루어진 사이클의 정의는 아래와 같다.

모든 k개의 점은 서로 다르다.
k는 4보다 크거나 같다.
모든 점의 색은 같다.
모든 1 ≤ i ≤ k-1에 대해서, di와 di+1은 인접하다. 또, dk와 d1도 인접해야 한다. 두 점이 인접하다는 것은 각각의 점이 들어있는 칸이 변을 공유한다는 의미이다.
게임판의 상태가 주어졌을 때, 사이클이 존재하는지 아닌지 구해보자.

입력
첫째 줄에 게임판의 크기 N, M이 주어진다. 둘째 줄부터 N개의 줄에 게임판의 상태가 주어진다. 게임판은 모두 점으로 가득차 있고, 게임판의 상태는 점의 색을 의미한다. 점의 색은 알파벳 대문자 한 글자이다.

출력
사이클이 존재하는 경우에는 "Yes", 없는 경우에는 "No"를 출력한다.

제한
2 ≤ N, M ≤ 50
예제 입력 1
3 4
AAAA
ABCA
AAAA
예제 출력 1
Yes
예제 입력 2
3 4
AAAA
ABCA
AADA
예제 출력 2
No
예제 입력 3
4 4
YYYR
BYBY
BBBY
BBBY
예제 출력 3
Yes
예제 입력 4
7 6
AAAAAB
ABBBAB
ABAAAB
ABABBB
ABAAAB
ABBBAB
AAAAAB
예제 출력 4
Yes
예제 입력 5
2 13
ABCDEFGHIJKLM
NOPQRSTUVWXYZ
예제 출력 5
No
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static char[][] board; // 게임판
    static boolean[][] visited; // 방문 체크 배열
    static int N, M;

    // 상하좌우 이동을 위한 배열
    static int[] dx = {0, 0, 1, -1}; // x 좌표 변화 (우, 좌, 하, 상)
    static int[] dy = {1, -1, 0, 0}; // y 좌표 변화 (우, 좌, 하, 상)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 게임판 크기 입력
        String[] firstLine = br.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]); // 행의 개수
        M = Integer.parseInt(firstLine[1]); // 열의 개수

        board = new char[N][M]; // 게임판 초기화
        for (int i = 0; i < N; i++) {
            String line = br.readLine(); // 각 행의 색상 정보를 읽음
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j); // 문자 배열로 저장
            }
        }

        visited = new boolean[N][M]; // 방문 체크 배열 초기화

        // 모든 칸을 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) { // 방문하지 않은 정점이면
                    if (dfs(i, j, -1, -1, board[i][j])) { // DFS 탐색
                        System.out.println("Yes"); // 사이클 발견
                        return;
                    }
                }
            }
        }
        System.out.println("No"); // 사이클이 없으면
    }

    // DFS 탐색 함수
    private static boolean dfs(int x, int y, int fromX, int fromY, char color) {
        visited[x][y] = true; // 현재 정점 방문 체크

        for (int i = 0; i < 4; i++) { // 4방향 탐색
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            // 유효한 범위인지 확인
            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                if (board[nextX][nextY] == color) { // 같은 색일 경우
                    if (!visited[nextX][nextY]) { // 방문하지 않은 정점이면 DFS 수행
                        if (dfs(nextX, nextY, x, y, color)) {
                            return true; // 사이클 발견
                        }
                    } else if (nextX != fromX || nextY != fromY) { // 이미 방문한 정점이고, 이전 정점이 아니면 사이클 발견
                        return true;
                    }
                }
            }
        }

        return false; // 사이클이 발견되지 않음
    }
}

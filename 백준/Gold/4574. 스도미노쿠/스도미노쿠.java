/*
문제
스도쿠가 세계적으로 유행이 된 이후에, 비슷한 퍼즐이 매우 많이 나왔다. 게임 매거진 2009년 7월호에는 스도쿠와 도미노를 혼합한 게임인 스도미노쿠가 소개되었다.

이 퍼즐은 스도쿠 규칙을 따른다. 스도쿠는 9×9 크기의 그리드를 1부터 9까지 숫자를 이용해서 채워야 한다. 스도쿠는 다음과 같은 조건을 만족하게 숫자를 채워야 한다.

각 행에는 1부터 9까지 숫자가 하나씩 있어야 한다.
각 열에는 1부터 9까지 숫자가 하나씩 있어야 한다.
3×3크기의 정사각형에는 1부터 9가지 숫자가 하나씩 있어야 한다.
스도미노쿠의 그리드에는 1부터 9까지 숫자가 쓰여져 있고, 나머지 72칸은 도미노 타일 36개로 채워야 한다. 도미노 타일은 1부터 9까지 서로 다른 숫자의 가능한 쌍이 모두 포함되어 있다. (1+2, 1+3, 1+4, 1+5, 1+6, 1+7, 1+8, 1+9, 2+3, 2+4, 2+5, ...) 1+2와 2+1은 같은 타일이기 때문에, 따로 구분하지 않는다. 도미노 타일은 회전 시킬 수 있다. 또, 3×3 크기의 정사각형의 경계에 걸쳐서 놓여질 수도 있다.

왼쪽 그림은 퍼즐의 초기 상태를 나타내고, 오른쪽은 퍼즐을 푼 상태이다.



스도미노쿠의 퍼즐의 초기 상태가 주어졌을 때, 퍼즐을 푸는 프로그램을 작성하시오.

입력
입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스의 첫째 줄에는 채워져 있는 도미노의 개수 N이 주어진다. (10 ≤ N ≤ 35) 다음 N개 줄에는 도미노 하나를 나타내는 U LU V LV가 주어진다. U는 도미노에 쓰여 있는 한 숫자이고, LU는 길이가 2인 문자열로 U의 위치를 나타낸다. V와 LV는 도미노에 쓰여 있는 다른 숫자를 나타낸다. 도미노의 위치는 문제에 나와있는 그림을 참고한다. 입력으로 주어지는 도미노의 각 숫자 위치는 항상 인접해 있다.

N개의 도미노의 정보가 주어진 다음 줄에는 채워져 있는 숫자의 위치가 1부터 9까지 차례대로 주어진다. 위치는 도미노의 위치를 나타낸 방법과 같은 방법으로 주어진다.

모든 도미노와 숫자가 겹치는 경우는 없다.

입력의 마지막 줄에는 0이 하나 주어진다.

출력
각 퍼즐에 대해서, 스도쿠를 푼 결과를 출력한다. 항상 답이 유일한 경우만 입력으로 주어진다.

예제 입력 1
10
6 B2 1 B3
2 C4 9 C3
6 D3 8 E3
7 E1 4 F1
8 B7 4 B8
3 F5 2 F6
7 F7 6 F8
5 G4 9 G5
7 I8 8 I9
7 C9 2 B9
C5 A3 D9 I4 A9 E5 A2 C6 I1
11
5 I9 2 H9
6 A5 7 A6
4 B8 6 C8
3 B5 8 B4
3 C3 2 D3
9 D2 8 E2
3 G2 5 H2
1 A2 8 A1
1 H8 3 I8
8 I3 7 I4
4 I6 9 I7
I5 E6 D1 F2 B3 G9 H7 C9 E5
0
예제 출력 1
Puzzle 1
872643195
361975842
549218637
126754983
738169254
495832761
284597316
657381429
913426578
Puzzle 2
814267593
965831247
273945168
392176854
586492371
741358629
137529486
459683712
628714935
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static boolean[][] visitedDomino;
    private static int[][] board;
    private static int[] dx = {1, 0}; // 아래, 오른쪽
    private static int[] dy = {0, 1};
    private static int puzzleCount = 1; // 퍼즐 번호
    private static boolean flag; // 퍼즐이 출력되었는지 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            visitedDomino = new boolean[10][10]; // 도미노 사용 여부
            board = new int[9][9]; // 9x9 보드
            n = Integer.parseInt(br.readLine()); // 도미노 개수

            // n 입력이 0이면 루프문 탈출
            if (n == 0) {
                break;
            }

            // 도미노 정보 입력
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                char[] lu = st.nextToken().toCharArray();
                int v = Integer.parseInt(st.nextToken());
                char[] lv = st.nextToken().toCharArray();

                // 도미노 체크
                visitedDomino[u][v] = true;
                visitedDomino[v][u] = true;

                // 위치 변환
                board[lu[0] - 'A'][lu[1] - '1'] = u;
                board[lv[0] - 'A'][lv[1] - '1'] = v;
            }

            // 고정 숫자 위치 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 9; i++) {
                char[] point = st.nextToken().toCharArray();
                board[point[0] - 'A'][point[1] - '1'] = i;
            }

            flag = false; // flag 초기화
            dfs(0); // DFS 호출
            puzzleCount++; // 퍼즐 번호 증가
        }
    }

    public static void dfs(int idx) {
        // 스도미노쿠를 완성했다면 출력합니다.
        if (idx == 81) {
            // flag는 해당 퍼즐이 출력된 적이 있는지 확인합니다.
            if (flag) {
                return;
            }
            flag = true;
            System.out.printf("Puzzle %d%n", puzzleCount);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            return;
        }

        // idx를 9 * 9 좌표로 변환합니다.
        int x = idx / 9;
        int y = idx % 9;

        // 해당 좌표에 값이 있는 경우 다음 좌표로 넘어갑니다.
        if (board[x][y] != 0) {
            dfs(idx + 1);
            return;
        }

        // 1부터 9까지의 숫자를 시도합니다.
        for (int i = 1; i <= 9; i++) {
            if (isPosNum(x, y, i)) {
                // idx에 따라 순서대로 탐색하므로 해당 좌표에서 오른쪽, 아랫쪽에 숫자가 포함되는 도미노만 사용합니다.
                for (int d = 0; d < 2; d++) {
                    int newX = x + dx[d];
                    int newY = y + dy[d];
                    // 두 번째 좌표가 스도쿠를 벗어나는지 혹은 숫자가 이미 있는지 확인
                    if (newX >= 9 || newY >= 9 || board[newX][newY] != 0) {
                        continue;
                    }
                    for (int j = 1; j <= 9; j++) {
                        // 도미노 안의 숫자가 다르고, 사용하지 않은 도미노이고, 해당 좌표에 숫자 j를 쓸 수 있다면 다음점을 탐색
                        if (i != j && !visitedDomino[i][j] && isPosNum(newX, newY, j)) {
                            board[x][y] = i;
                            board[newX][newY] = j;
                            visitedDomino[i][j] = true;
                            visitedDomino[j][i] = true;
                            dfs(idx + 1);
                            // 탐색 후 원래 상태로 복구
                            board[x][y] = 0;
                            board[newX][newY] = 0;
                            visitedDomino[i][j] = false;
                            visitedDomino[j][i] = false;
                        }
                    }
                }
            }
        }
    }

    // 스도쿠 규칙에 따라 해당 숫자를 사용할 수 있는지 확인합니다.
    public static boolean isPosNum(int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            // 세로에 같은 숫자가 있는지 확인
            if (board[i][y] == num) {
                return false;
            }
            // 가로에 같은 숫자가 있는지 확인
            if (board[x][i] == num) {
                return false;
            }
        }

        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        // 해당 좌표가 포함되는 3 * 3 네모 안에 같은 숫자가 있는지 확인
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}

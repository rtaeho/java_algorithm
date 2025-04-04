/*
문제
2048 게임은 4×4 크기의 보드에서 혼자 즐기는 재미있는 게임이다. 이 링크를 누르면 게임을 해볼 수 있다.

이 게임에서 한 번의 이동은 보드 위에 있는 전체 블록을 상하좌우 네 방향 중 하나로 이동시키는 것이다. 이때, 같은 값을 갖는 두 블록이 충돌하면 두 블록은 하나로 합쳐지게 된다. 한 번의 이동에서 이미 합쳐진 블록은 또 다른 블록과 다시 합쳐질 수 없다. (실제 게임에서는 이동을 한 번 할 때마다 블록이 추가되지만, 이 문제에서 블록이 추가되는 경우는 없다)


<그림 1>	<그림 2>	<그림 3>
<그림 1>의 경우에서 위로 블록을 이동시키면 <그림 2>의 상태가 된다. 여기서, 왼쪽으로 블록을 이동시키면 <그림 3>의 상태가 된다.


<그림 4>	<그림 5>	<그림 6>	<그림 7>
<그림 4>의 상태에서 블록을 오른쪽으로 이동시키면 <그림 5>가 되고, 여기서 다시 위로 블록을 이동시키면 <그림 6>이 된다. 여기서 오른쪽으로 블록을 이동시켜 <그림 7>을 만들 수 있다.


<그림 8>	<그림 9>
<그림 8>의 상태에서 왼쪽으로 블록을 옮기면 어떻게 될까? 2가 충돌하기 때문에, 4로 합쳐지게 되고 <그림 9>의 상태가 된다.


<그림 10>	<그림 11>	<그림 12>	<그림 13>
<그림 10>에서 위로 블록을 이동시키면 <그림 11>의 상태가 된다.

<그림 12>의 경우에 위로 블록을 이동시키면 <그림 13>의 상태가 되는데, 그 이유는 한 번의 이동에서 이미 합쳐진 블록은 또 합쳐질 수 없기 때문이다.


<그림 14>	<그림 15>
마지막으로, 똑같은 수가 세 개가 있는 경우에는 이동하려고 하는 쪽의 칸이 먼저 합쳐진다. 예를 들어, 위로 이동시키는 경우에는 위쪽에 있는 블록이 먼저 합쳐지게 된다. <그림 14>의 경우에 위로 이동하면 <그림 15>를 만든다.

이 문제에서 다루는 2048 게임은 보드의 크기가 N×N 이다. 보드의 크기와 보드판의 블록 상태가 주어졌을 때, 최대 5번 이동해서 만들 수 있는 가장 큰 블록의 값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 보드의 크기 N (1 ≤ N ≤ 20)이 주어진다. 둘째 줄부터 N개의 줄에는 게임판의 초기 상태가 주어진다. 0은 빈 칸을 나타내며, 이외의 값은 모두 블록을 나타낸다. 블록에 쓰여 있는 수는 2보다 크거나 같고, 1024보다 작거나 같은 2의 제곱꼴이다. 블록은 적어도 하나 주어진다.

출력
최대 5번 이동시켜서 얻을 수 있는 가장 큰 블록을 출력한다.

예제 입력 1
3
2 2 2
4 4 4
8 8 8
예제 출력 1
16
 */
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static int maxBlock = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, board);
        System.out.println(maxBlock);
    }

    // DFS 탐색
    static void dfs(int depth, int[][] curBoard) {
        if (depth == 5) {
            // 최대값 갱신
            updateMax(curBoard);
            return;
        }

        // 4방향으로 이동
        for (int dir = 0; dir < 4; dir++) {
            int[][] nextBoard = move(dir, curBoard);
            dfs(depth + 1, nextBoard);
        }
    }

    // 현재 보드에서 최대값 갱신
    static void updateMax(int[][] curBoard) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxBlock = Math.max(maxBlock, curBoard[i][j]);
            }
        }
    }

    // 특정 방향으로 이동
    static int[][] move(int dir, int[][] curBoard) {
        int[][] newBoard = new int[N][N];
        boolean[][] merged = new boolean[N][N]; // 이미 합쳐진 블록 관리

        // 복사
        for (int i = 0; i < N; i++) {
            System.arraycopy(curBoard[i], 0, newBoard[i], 0, N);
        }

        // 방향에 따른 이동
        if (dir == 0) { // 위로 이동
            for (int j = 0; j < N; j++) {
                for (int i = 1; i < N; i++) {
                    if (newBoard[i][j] != 0) {
                        int x = i;
                        while (x > 0 && newBoard[x - 1][j] == 0) {
                            newBoard[x - 1][j] = newBoard[x][j];
                            newBoard[x][j] = 0;
                            x--;
                        }
                        if (x > 0 && newBoard[x - 1][j] == newBoard[x][j] && !merged[x - 1][j]) {
                            newBoard[x - 1][j] *= 2;
                            newBoard[x][j] = 0;
                            merged[x - 1][j] = true;
                        }
                    }
                }
            }
        } else if (dir == 1) { // 아래로 이동
            for (int j = 0; j < N; j++) {
                for (int i = N - 2; i >= 0; i--) {
                    if (newBoard[i][j] != 0) {
                        int x = i;
                        while (x < N - 1 && newBoard[x + 1][j] == 0) {
                            newBoard[x + 1][j] = newBoard[x][j];
                            newBoard[x][j] = 0;
                            x++;
                        }
                        if (x < N - 1 && newBoard[x + 1][j] == newBoard[x][j] && !merged[x + 1][j]) {
                            newBoard[x + 1][j] *= 2;
                            newBoard[x][j] = 0;
                            merged[x + 1][j] = true;
                        }
                    }
                }
            }
        } else if (dir == 2) { // 왼쪽으로 이동
            for (int i = 0; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    if (newBoard[i][j] != 0) {
                        int y = j;
                        while (y > 0 && newBoard[i][y - 1] == 0) {
                            newBoard[i][y - 1] = newBoard[i][y];
                            newBoard[i][y] = 0;
                            y--;
                        }
                        if (y > 0 && newBoard[i][y - 1] == newBoard[i][y] && !merged[i][y - 1]) {
                            newBoard[i][y - 1] *= 2;
                            newBoard[i][y] = 0;
                            merged[i][y - 1] = true;
                        }
                    }
                }
            }
        } else if (dir == 3) { // 오른쪽으로 이동
            for (int i = 0; i < N; i++) {
                for (int j = N - 2; j >= 0; j--) {
                    if (newBoard[i][j] != 0) {
                        int y = j;
                        while (y < N - 1 && newBoard[i][y + 1] == 0) {
                            newBoard[i][y + 1] = newBoard[i][y];
                            newBoard[i][y] = 0;
                            y++;
                        }
                        if (y < N - 1 && newBoard[i][y + 1] == newBoard[i][y] && !merged[i][y + 1]) {
                            newBoard[i][y + 1] *= 2;
                            newBoard[i][y] = 0;
                            merged[i][y + 1] = true;
                        }
                    }
                }
            }
        }

        return newBoard;
    }
}
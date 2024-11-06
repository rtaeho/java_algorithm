/*
문제
세로
$R$칸, 가로
$C$칸으로 된 표 모양의 보드가 있다. 보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고, 좌측 상단 칸 (
$1$행
$1$열) 에는 말이 놓여 있다.

말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데, 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다. 즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.

좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하는 프로그램을 작성하시오. 말이 지나는 칸은 좌측 상단의 칸도 포함된다.

입력
첫째 줄에
$R$과
$C$가 빈칸을 사이에 두고 주어진다. (
$1 ≤ R,C ≤ 20$) 둘째 줄부터
$R$개의 줄에 걸쳐서 보드에 적혀 있는
$C$개의 대문자 알파벳들이 빈칸 없이 주어진다.

출력
첫째 줄에 말이 지날 수 있는 최대의 칸 수를 출력한다.

예제 입력 1
2 4
CAAB
ADCB
예제 출력 1
3
예제 입력 2
3 6
HFDFFB
AJHGDH
DGAGEH
예제 출력 2
6
예제 입력 3
5 5
IEFCJ
FHFKC
FFALF
HFGCF
HMCHH
예제 출력 3
10
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int R, C; // 행과 열의 크기
    static char[][] board; // 보드
    static boolean[] visited = new boolean[26]; // 알파벳 방문 여부
    static int maxCount = 0; // 최대 칸 수

    // 방향 배열 (상, 하, 좌, 우)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray(); // 보드 입력
        }

        // DFS 시작
        dfs(0, 0, 1); // 시작 위치 (0, 0)에서 시작하고 지나온 칸 수는 1
        System.out.println(maxCount); // 최대 칸 수 출력
    }

    static void dfs(int x, int y, int count) {
        // 현재 위치의 알파벳 방문 처리
        visited[board[x][y] - 'A'] = true;
        maxCount = Math.max(maxCount, count); // 최대 칸 수 업데이트

        // 상하좌우로 이동
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 다음 위치가 보드의 범위를 벗어나지 않고 방문하지 않은 알파벳인지 확인
            if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[board[nx][ny] - 'A']) {
                dfs(nx, ny, count + 1); // 재귀 호출
            }
        }

        // 백트래킹: 현재 위치의 알파벳 방문 처리 해제
        visited[board[x][y] - 'A'] = false;
    }
}
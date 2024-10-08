/*
문제
영선이는 숫자가 쓰여 있는 직사각형 종이를 가지고 있다. 종이는 1×1 크기의 정사각형 칸으로 나누어져 있고, 숫자는 각 칸에 하나씩 쓰여 있다. 행은 위에서부터 아래까지 번호가 매겨져 있고, 열은 왼쪽부터 오른쪽까지 번호가 매겨져 있다.

영선이는 직사각형을 겹치지 않는 조각으로 자르려고 한다. 각 조각은 크기가 세로나 가로 크기가 1인 직사각형 모양이다. 길이가 N인 조각은 N자리 수로 나타낼 수 있다. 가로 조각은 왼쪽부터 오른쪽까지 수를 이어 붙인 것이고, 세로 조각은 위에서부터 아래까지 수를 이어붙인 것이다.

아래 그림은 4×4 크기의 종이를 자른 한 가지 방법이다.



각 조각의 합은 493 + 7160 + 23 + 58 + 9 + 45 + 91 = 7879 이다.

종이를 적절히 잘라서 조각의 합을 최대로 하는 프로그램을 작성하시오.

입력
첫째 줄에 종이 조각의 세로 크기 N과 가로 크기 M이 주어진다. (1 ≤ N, M ≤ 4)

둘째 줄부터 종이 조각이 주어진다. 각 칸에 쓰여 있는 숫자는 0부터 9까지 중 하나이다.

출력
영선이가 얻을 수 있는 점수의 최댓값을 출력한다.

예제 입력 1
2 3
123
312
예제 출력 1
435
예제 입력 2
2 2
99
11
예제 출력 2
182
예제 입력 3
4 3
001
010
111
100
예제 출력 3
1131
예제 입력 4
1 1
8
예제 출력 4
8
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] p;
    static boolean[][] visit;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        p = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++)
                p[i][j] = input.charAt(j) - '0';
        }

        DFS(0, 0, 0);
        System.out.println(answer);
    }

    static void DFS(int depth, int num, int sum) {
        if (depth == N * M) {
            answer = Math.max(sum, answer);
            return;
        }

        int r = depth / M;
        int c = depth % M;

        if (visit[r][c]) {
            DFS(depth + 1, num, sum);
        } else {
            visit[r][c] = true;
            num = num * 10 + p[r][c];
            DFS(depth + 1, 0, sum + num);

            int i, temp = num;
            for (i = r + 1; i < N; i++) {
                if (visit[i][c])
                    break;

                visit[i][c] = true;
                temp = temp * 10 + p[i][c];
                DFS(depth + 1, 0, sum + temp);
            }

            for (int j = r + 1; j < i; j++)
                visit[j][c] = false;

            temp = num;
            for (i = c + 1; i < M; i++) {
                if (visit[r][i])
                    break;
                visit[r][i] = true;
                temp = temp * 10 + p[r][i];
                DFS(depth + i - c + 1, 0, sum + temp);
            }

            for (int j = c + 1; j < i; j++)
                visit[r][j] = false;

            visit[r][c] = false;
        }
    }
}

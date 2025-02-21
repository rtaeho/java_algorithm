/*
문제
소수를 유난히도 좋아하는 창영이는 게임 아이디 비밀번호를 4자리 ‘소수’로 정해놓았다. 어느 날 창영이는 친한 친구와 대화를 나누었는데:

“이제 슬슬 비번 바꿀 때도 됐잖아”
“응 지금은 1033으로 해놨는데... 다음 소수를 무엇으로 할지 고민중이야"
“그럼 8179로 해”
“흠... 생각 좀 해볼게. 이 게임은 좀 이상해서 비밀번호를 한 번에 한 자리 밖에 못 바꾼단 말이야. 예를 들어 내가 첫 자리만 바꾸면 8033이 되니까 소수가 아니잖아. 여러 단계를 거쳐야 만들 수 있을 것 같은데... 예를 들면... 1033 1733 3733 3739 3779 8779 8179처럼 말이야.”
“흠...역시 소수에 미쳤군. 그럼 아예 프로그램을 짜지 그래. 네 자리 소수 두 개를 입력받아서 바꾸는데 몇 단계나 필요한지 계산하게 말야.”
“귀찮아”
그렇다. 그래서 여러분이 이 문제를 풀게 되었다. 입력은 항상 네 자리 소수만(1000 이상) 주어진다고 가정하자. 주어진 두 소수 A에서 B로 바꾸는 과정에서도 항상 네 자리 소수임을 유지해야 하고, ‘네 자리 수’라 하였기 때문에 0039 와 같은 1000 미만의 비밀번호는 허용되지 않는다.

입력
첫 줄에 test case의 수 T가 주어진다. 다음 T줄에 걸쳐 각 줄에 1쌍씩 네 자리 소수가 주어진다.

출력
각 test case에 대해 두 소수 사이의 변환에 필요한 최소 회수를 출력한다. 불가능한 경우 Impossible을 출력한다.

예제 입력 1
3
1033 8179
1373 8017
1033 1033
예제 출력 1
6
7
0
 */
package baekjoon.year2025.february;

import java.io.*;
import java.util.*;

public class BOJ1963 {
    static boolean[] isPrime;
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 소수 판별 배열 초기화
        sieveOfEratosthenes();

        T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            // BFS 실행
            int result = bfs(start, target);
            sb.append(result == -1 ? "Impossible" : result).append("\n");
        }

        System.out.println(sb);
    }

    // **에라토스테네스의 체**를 사용하여 4자리 소수 판별
    static void sieveOfEratosthenes() {
        isPrime = new boolean[10000];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; // 0과 1은 소수가 아님

        for (int i = 2; i * i < 10000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 10000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    // **BFS**를 사용하여 최단 변경 횟수 찾기
    static int bfs(int start, int target) {
        if (start == target) return 0; // 같은 숫자일 경우 0 반환

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000];

        queue.add(new int[]{start, 0}); // {현재 숫자, 변경 횟수}
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int num = cur[0];
            int count = cur[1];

            // 각 자리수를 변경하여 새로운 숫자 생성
            for (int i = 0; i < 4; i++) {
                char[] numArr = String.valueOf(num).toCharArray();

                // 0~9까지 바꿔보기
                for (char digit = '0'; digit <= '9'; digit++) {
                    if (numArr[i] == digit) continue; // 같은 숫자는 패스

                    numArr[i] = digit;
                    int newNum = Integer.parseInt(new String(numArr));

                    // 4자리 숫자 & 소수 & 방문 X
                    if (newNum >= 1000 && isPrime[newNum] && !visited[newNum]) {
                        if (newNum == target) return count + 1; // 목표 도달

                        queue.add(new int[]{newNum, count + 1});
                        visited[newNum] = true;
                    }
                }
            }
        }

        return -1; // 변환 불가능
    }
}
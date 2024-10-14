/*
문제
영선이는 매우 기쁘기 때문에, 효빈이에게 스마일 이모티콘을 S개 보내려고 한다.

영선이는 이미 화면에 이모티콘 1개를 입력했다. 이제, 다음과 같은 3가지 연산만 사용해서 이모티콘을 S개 만들어 보려고 한다.

화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
화면에 있는 이모티콘 중 하나를 삭제한다.
모든 연산은 1초가 걸린다. 또, 클립보드에 이모티콘을 복사하면 이전에 클립보드에 있던 내용은 덮어쓰기가 된다. 클립보드가 비어있는 상태에는 붙여넣기를 할 수 없으며, 일부만 클립보드에 복사할 수는 없다. 또한, 클립보드에 있는 이모티콘 중 일부를 삭제할 수 없다. 화면에 이모티콘을 붙여넣기 하면, 클립보드에 있는 이모티콘의 개수가 화면에 추가된다.

영선이가 S개의 이모티콘을 화면에 만드는데 걸리는 시간의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 S (2 ≤ S ≤ 1000) 가 주어진다.

출력
첫째 줄에 이모티콘을 S개 만들기 위해 필요한 시간의 최솟값을 출력한다.

예제 입력 1
2
예제 출력 1
2
예제 입력 2
4
예제 출력 2
4
예제 입력 3
6
예제 출력 3
5
예제 입력 4
18
예제 출력 4
8
*/
import java.io.*;
import java.util.*;

public class Main {
    static class State {
        int screen; // 화면의 이모티콘 수
        int clipboard; // 클립보드의 이모티콘 수
        int time; // 경과 시간

        State(int screen, int clipboard, int time) {
            this.screen = screen;
            this.clipboard = clipboard;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[S + 1][S + 1]; // 방문 체크 배열
        Queue<State> queue = new LinkedList<>(); // BFS 큐

        queue.add(new State(1, 0, 0)); // 시작 상태: 화면 1개, 클립보드 0개, 시간 0초
        visited[1][0] = true; // 시작 상태 방문 처리

        while (!queue.isEmpty()) {
            State current = queue.poll();

            // 화면의 이모티콘 수가 목표 수에 도달하면 출력
            if (current.screen == S) {
                System.out.println(current.time);
                return;
            }

            // 1. 이모티콘을 복사해서 클립보드에 저장 (현재 화면의 수를 클립보드에 저장)
            if (current.screen > 0 && current.screen < S && !visited[current.screen][current.screen]) {
                visited[current.screen][current.screen] = true; // 방문 처리
                queue.add(new State(current.screen, current.screen, current.time + 1));
            }

            // 2. 클립보드에 있는 이모티콘을 붙여넣기 (화면에 클립보드의 수를 추가)
            if (current.clipboard > 0 && current.screen + current.clipboard <= S &&
                    !visited[current.screen + current.clipboard][current.clipboard]) {
                visited[current.screen + current.clipboard][current.clipboard] = true; // 방문 처리
                queue.add(new State(current.screen + current.clipboard, current.clipboard, current.time + 1));
            }

            // 3. 현재 화면의 이모티콘 중 하나를 삭제
            if (current.screen > 0 && !visited[current.screen - 1][current.clipboard]) {
                visited[current.screen - 1][current.clipboard] = true; // 방문 처리
                queue.add(new State(current.screen - 1, current.clipboard, current.time + 1));
            }
        }
    }
}
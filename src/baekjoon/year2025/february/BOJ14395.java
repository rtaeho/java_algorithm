/*
문제
정수 s가 주어진다. 정수 s의 값을 t로 바꾸는 최소 연산 횟수를 구하는 프로그램을 작성하시오.

사용할 수 있는 연산은 아래와 같다.

s = s + s; (출력: +)
s = s - s; (출력: -)
s = s * s; (출력: *)
s = s / s; (출력: /) (s가 0이 아닐때만 사용 가능)
입력
첫째 줄에 s와 t가 주어진다. (1 ≤ s, t ≤ 109)

출력
첫째 줄에 정수 s를 t로 바꾸는 방법을 출력한다. s와 t가 같은 경우에는 0을, 바꿀 수 없는 경우에는 -1을 출력한다. 가능한 방법이 여러 가지라면, 사전 순으로 앞서는 것을 출력한다.

연산의 아스키 코드 순서는 '*', '+', '-', '/' 이다.

예제 입력 1
7 392
예제 출력 1
+*+
예제 입력 2
7 256
예제 출력 2
/+***
예제 입력 3
4 256
예제 출력 3
**
예제 입력 4
7 7
예제 출력 4
0
예제 입력 5
7 9
예제 출력 5
-1
예제 입력 6
10 1
예제 출력 6
/
 */
package baekjoon.year2025.february;

import java.io.*;
import java.util.*;

public class BOJ14395 {
    static class Node {
        long value;
        String operations;

        public Node(long value, String operations) {
            this.value = value;
            this.operations = operations;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long s = Long.parseLong(st.nextToken());
        long t = Long.parseLong(st.nextToken());

        System.out.println(bfs(s, t));
    }

    static String bfs(long s, long t) {
        if (s == t) {
            return "0";  // 시작값과 목표값이 같으면 연산 필요 없음
        }

        Set<Long> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(s, ""));
        visited.add(s);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            long val = cur.value;
            String op = cur.operations;

            if (val == t) {
                return op; // 목표 값 도달 시 연산 출력
            }

            // 곱하기 (*)
            if (val * val <= t && visited.add(val * val)) {
                queue.add(new Node(val * val, op + "*"));
            }
            // 더하기 (+)
            if (val + val <= t && visited.add(val + val)) {
                queue.add(new Node(val + val, op + "+"));
            }
            // 나누기 (/)
            if (val != 0 && visited.add(1L)) {
                queue.add(new Node(1, op + "/"));
            }
        }

        return "-1"; // 변환 불가능한 경우
    }
}

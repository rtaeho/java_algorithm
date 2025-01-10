import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int value; // 현재 레지스터 값
        String commands; // 지금까지의 명령어 기록

        public Node(int value, String commands) {
            this.value = value;
            this.commands = commands;
        }
    }

    static int D(int n) {
        return (2 * n) % 10000;
    }

    static int S(int n) {
        return n == 0 ? 9999 : n - 1;
    }

    static int L(int n) {
        return (n % 1000) * 10 + (n / 1000); // 자릿수 이동
    }

    static int R(int n) {
        return (n % 10) * 1000 + (n / 10); // 자릿수 이동
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append(bfs(A, B)).append("\n");
        }

        System.out.print(sb);
    }

    static String bfs(int start, int target) {
        boolean[] visited = new boolean[10000]; // 방문 여부 확인
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(start, ""));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.value == target) {
                return current.commands; // 목표값 도달 시 명령어 반환
            }

            // D 연산
            int next = D(current.value);
            if (!visited[next]) {
                visited[next] = true;
                queue.add(new Node(next, current.commands + "D"));
            }

            // S 연산
            next = S(current.value);
            if (!visited[next]) {
                visited[next] = true;
                queue.add(new Node(next, current.commands + "S"));
            }

            // L 연산
            next = L(current.value);
            if (!visited[next]) {
                visited[next] = true;
                queue.add(new Node(next, current.commands + "L"));
            }

            // R 연산
            next = R(current.value);
            if (!visited[next]) {
                visited[next] = true;
                queue.add(new Node(next, current.commands + "R"));
            }
        }
        return ""; // 도달 불가능한 경우 (문제에서 항상 가능하다고 가정)
    }
}
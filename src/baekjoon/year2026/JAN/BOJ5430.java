package baekjoon.year2026.JAN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arrayStr = br.readLine();

            // 양방향으로 사용을 위해 덱 사용
            Deque<Integer> deque = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(arrayStr, "[],");
            for (int j = 0; j < n; j++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            boolean isNormal = true; // 현재 방향
            boolean isError = false;

            for (char c : command.toCharArray()) {
                if (c == 'R') { // 뒤집기
                    isNormal = !isNormal; // 직접 뒤집지 않고 보는 방향만 변경
                } else { // 하나 삭제
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    // 방향에 따라 삭제 진행
                    if (isNormal) deque.pollFirst();
                    else deque.pollLast();
                }
            }

            if (isError) {
                sb.append("error\n");
            } else {
                sb.append("[");
                while (!deque.isEmpty()) {
                    // 방향에 따라 출력 진행
                    sb.append(isNormal ? deque.pollFirst() : deque.pollLast());
                    if (!deque.isEmpty()) sb.append(",");
                }
                sb.append("]\n");
            }
        }
        System.out.print(sb);
    }
}
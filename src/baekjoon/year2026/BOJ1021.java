package baekjoon.year2026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        int[] targets = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        int totalCount = 0;

        for (int target : targets) {
            int targetIdx = deque.indexOf(target);
            int midIdx;

            if (deque.size() % 2 == 0) {
                midIdx = deque.size() / 2 - 1;
            } else {
                midIdx = deque.size() / 2;
            }

            if (targetIdx <= midIdx) {
                for (int i = 0; i < targetIdx; i++) {
                    deque.addLast(deque.pollFirst());
                    totalCount++;
                }
            } else {
                for (int i = 0; i < deque.size() - targetIdx; i++) {
                    deque.addFirst(deque.pollLast());
                    totalCount++;
                }
            }
            deque.pollFirst();
        }

        System.out.println(totalCount);
    }
}
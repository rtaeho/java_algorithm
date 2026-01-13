package baekjoon.year2026;

import java.io.*;
import java.util.*;

public class BOJ11003 {
    static class Node implements Comparable<Node> {
        int value;
        int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
        // 기본 비교 메서드 오버라이딩
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.value, other.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            pq.add(new Node(now, i)); // compareTo를 통하여 add

            while (!pq.isEmpty() && pq.peek().index <= i - l) {
                pq.poll();
            }

            sb.append(pq.peek().value).append(" ");
        }

        System.out.println(sb.toString());
    }
}
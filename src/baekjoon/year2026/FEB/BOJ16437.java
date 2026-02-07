package baekjoon.year2026.FEB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ16437 {
    static class Node {
        char animal;
        long cnt;
        List<Integer> children;

        public Node(char animal, long cnt) {
            this.animal = animal;
            this.cnt = cnt;
            this.children = new ArrayList<>();
        }
    }

    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        nodes = new Node[N + 1];
        nodes[1] = new Node('S', 0);

        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char animal = st.nextToken().charAt(0);
            long cnt = Long.parseLong(st.nextToken());
            int parent = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(animal, cnt);
            nodes[parent].children.add(i);
        }

        System.out.println(dfs(1));
    }

    static long dfs(int currentIdx) {
        long totalSheep = 0;
        Node current = nodes[currentIdx];

        for (int childIdx : current.children) {
            totalSheep += dfs(childIdx);
        }

        if (current.animal == 'S') {
            totalSheep += current.cnt;
        } else {
            totalSheep -= current.cnt;
            if (totalSheep < 0) totalSheep = 0;
        }

        return totalSheep;
    }
}
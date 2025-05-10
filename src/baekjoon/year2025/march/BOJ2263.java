/*
문제
n개의 정점을 갖는 이진 트리의 정점에 1부터 n까지의 번호가 중복 없이 매겨져 있다. 이와 같은 이진 트리의 인오더와 포스트오더가 주어졌을 때, 프리오더를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 n(1 ≤ n ≤ 100,000)이 주어진다. 다음 줄에는 인오더를 나타내는 n개의 자연수가 주어지고, 그 다음 줄에는 같은 식으로 포스트오더가 주어진다.

출력
첫째 줄에 프리오더를 출력한다.

예제 입력 1
3
1 2 3
1 3 2
예제 출력 1
2 1 3
 */
package baekjoon.year2025.march;

import java.io.*;
import java.util.*;

public class BOJ2263 {
    static int n;
    static int[] inorder, postorder;
    static int[] inorderIndex;  // 값 -> 인덱스
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        inorder = new int[n];
        postorder = new int[n];
        inorderIndex = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            inorderIndex[inorder[i]] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        buildPreorder(0, n - 1, 0, n - 1);
        System.out.println(sb);
    }

    // inStart ~ inEnd: 인오더 범위, postStart ~ postEnd: 포스트오더 범위
    static void buildPreorder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return;
        }

        int root = postorder[postEnd];
        sb.append(root).append(" ");

        int rootIndex = inorderIndex[root];
        int leftSize = rootIndex - inStart;

        buildPreorder(inStart, rootIndex - 1, postStart, postStart + leftSize - 1); // 왼쪽
        buildPreorder(rootIndex + 1, inEnd, postStart + leftSize, postEnd - 1); // 오른쪽
    }
}

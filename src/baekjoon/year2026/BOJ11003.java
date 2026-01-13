package baekjoon.year2026;

import java.io.*;
import java.util.*;

public class BOJ11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dequeIdx = new int[n];
        int head = 0;
        int tail = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            while (tail > head && arr[dequeIdx[tail - 1]] >= arr[i]) {
                tail--;
            }
            dequeIdx[tail++] = i;
            if (dequeIdx[head] <= i - l) {
                head++;
            }
            sb.append(arr[dequeIdx[head]]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
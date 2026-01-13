package baekjoon.year2026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int start = Math.max(0, i - l + 1);
            int min = Integer.MAX_VALUE;
            for (int j = start; j <= i; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                }
            }
            sb.append(min).append(" ");
        }

        System.out.println(sb.toString());

    }
}

package baekjoon.year2025.december;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long min = Math.min(a, b);
        long max = Math.max(a, b);

        long count = max - min - 1;

        if (min == max || count < 1) {
            System.out.println(0);
            return;
        }

        System.out.println(count);

        StringBuilder sb = new StringBuilder();
        for (long i = min + 1; i < max; i++) {
            sb.append(i).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
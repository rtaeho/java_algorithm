package baekjoon.year2025.december;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ2442 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {

            for (int j = 1; j <= N - i; j++) {
                sb.append(" ");
            }

            for (int k = 1; k <= 2 * i - 1; k++) {
                sb.append("*");
            }

            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
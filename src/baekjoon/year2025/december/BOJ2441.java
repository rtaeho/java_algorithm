
package baekjoon.year2025.december;

import java.io.BufferedReader;
import java.io.IOException;

public class BOJ2441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = i; k < n; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

package baekjoon.year2025.december;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        int[] count = new int[10];
        for (int i = 0; i < n.length(); i++) {
            int num = n.charAt(i) - '0';
            count[num]++;
        }

        int sn = (count[6] + count[9] + 1) / 2;
        count[6] = sn;
        count[9] = sn;

        int max = 0;
        for (int i = 0; i < 10; i++) {
            if (count[i] > max) {
                max = count[i];
            }
        }

        System.out.println(max);
    }
}
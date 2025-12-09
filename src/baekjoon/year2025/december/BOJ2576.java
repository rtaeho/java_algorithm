package baekjoon.year2025.december;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ2576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sumOfOdds = 0;
        int minOdd = 101;

        for (int i = 0; i < 7; i++) {
            int number = Integer.parseInt(br.readLine());

            if (number % 2 != 0) {
                sumOfOdds += number;

                if (number < minOdd) {
                    minOdd = number;
                }
            }
        }

        if (sumOfOdds == 0) {
            System.out.println("-1");
        } else {
            System.out.println(sumOfOdds);
            System.out.println(minOdd);
        }
    }
}
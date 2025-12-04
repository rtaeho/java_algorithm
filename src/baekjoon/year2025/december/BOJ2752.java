package baekjoon.year2025.december;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2752 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[3];

        for (int i = 0; i < 3; i++) {
            numbers[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(numbers);
        // nlogn만큼 걸림

        System.out.println(numbers[0] + " " + numbers[1] + " " + numbers[2]);
    }
}

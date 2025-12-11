package baekjoon.year2025.december;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ10804 {

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cardArray = new int[21];
        for (int i = 1; i <= 20; i++) {
            cardArray[i] = i;
        }

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int start = a;
            int end = b;

            while (start < end) {
                swap(cardArray, start, end);
                start++;
                end--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 20; i++) {
            sb.append(cardArray[i]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
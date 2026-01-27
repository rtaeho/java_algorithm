package baekjoon.year2026.JAN;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();

            int[] alphabet = new int[26];
            boolean isPossible = true;

            if (s1.length() != s2.length()) {
                isPossible = false;
            } else {
                for (int j = 0; j < s1.length(); j++) {
                    alphabet[s1.charAt(j) - 'a']++;
                    alphabet[s2.charAt(j) - 'a']--;
                }

                for (int count : alphabet) {
                    if (count != 0) {
                        isPossible = false;
                        break;
                    }
                }
            }

            sb.append(isPossible ? "Possible" : "Impossible").append("\n");
        }

        System.out.print(sb.toString());
    }
}
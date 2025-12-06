package baekjoon.year2025.december;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2490 {
    public static void main(String[] args) throws IOException {
        // 도 A 개 B 걸 C 모 E
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ;
        for (int i = 0; i < 3; i++) {
            String s = br.readLine();
            String[] tmp = s.split(" ");
            int cnt = 0;
            for (int j = 0; j < 4; j++) {
                if (tmp[j].equals("0")) {
                    cnt++;
                }
            }
            switch (cnt) {
                case 0:
                    System.out.println("E");
                    break;
                case 1:
                    System.out.println("A");
                    break;
                case 2:
                    System.out.println("B");
                    break;
            }
        }
    }
}

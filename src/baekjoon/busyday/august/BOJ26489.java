/*
문제
You are lost in the museum and keep walking by a giant rock head that says “gum gum for jay jay” each time you walk by. Print out the number of times you have walked by the giant rock head after reading in the data file.

입력
The data file will contain an unknown number of lines.

출력
Print out the number of lines in the data file.

예제 입력 1
gum gum for jay jay
gum gum for jay jay
gum gum for jay jay
gum gum for jay jay
gum gum for jay jay
gum gum for jay jay
gum gum for jay jay
gum gum for jay jay
gum gum for jay jay
gum gum for jay jay
gum gum for jay jay
예제 출력 1
11

 */
package baekjoon.busyday.august;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ26489 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        while (true) {
            String tmp = br.readLine();
            if (tmp == null) break;
            cnt++;
        }
        System.out.println(cnt);
    }
}

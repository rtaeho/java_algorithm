/*
문제
There are five ways to score points in american professional football:

Touchdown - 6 points
Field Goal - 3 points
Safety - 2 points
After touchdown
1 point (Field Goal or Safety) - Typically called the “Point after”
2 points (touchdown) - Typically called the “Two-point conversion”
(https://operations.nfl.com/the-rules/nfl-video-rulebook/scoring-plays/)

Given the box score values for two competing teams, calculate the point total for each team.

입력
There are two lines of input each containing five space-separated non-negative integers, T, F, S, P and C representing the number of Touchdowns, Field goals, Safeties, Points-after-touchdown and two-point Conversions after touchdown respectively. (0 ≤ T ≤ 10), (0 ≤ F ≤ 10), (0 ≤ S ≤ 10), (0 ≤ (P+C) ≤ T). The first line represents the box score for the visiting team, and the second line represents the box score for the home team.

출력
The single output line consists of two space-separated integers showing the visiting score and the home score respectively.

예제 입력 1
1 3 0 0 1
3 1 1 1 1
예제 출력 1
17 26
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 5; i < 10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.print(arr[0] * 6 + arr[1] * 3 + arr[2] * 2 + arr[3] * 1 + arr[4] * 2);
        System.out.print(" ");
        System.out.println(arr[5] * 6 + arr[6] * 3 + arr[7] * 2 + arr[8] * 1 + arr[9] * 2);
    }
}

/*
문제
A Metronome is a mechanical device used by musicians for keeping time. It is a very clever device, based on a spring, an inverted pendulum, and an escapement gear. Milo is learning to play the glockenspiel, and has purchased a metronome to help him keep time. Milo has noticed that for every complete turn (one revolution) of the key, the metronome will give four ticks. Milo wants the metronome to stop at the end of each song that he tries to play.

For a given song, how many revolutions must he wind the key?

입력
The single line of input contains a single integer
$n$ (
$1 \le n \le 10^5$), which is the length of the song in ticks.

출력
Output a single real number, which is the number of revolutions Milo must turn the metronome's key so that it stops precisely at the end of the song. This number must be accurate to two decimal places.

예제 입력 1
16
예제 출력 1
4.0
예제 입력 2
99
예제 출력 2
24.75
 */
package baekjoon.busyday.august;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ27389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(N / 4.0);
    }
}

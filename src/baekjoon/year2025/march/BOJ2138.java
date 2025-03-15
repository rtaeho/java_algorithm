package baekjoon.year2025.march;public class BOJ2138 {
/*
문제
N개의 스위치와 N개의 전구가 있다. 각각의 전구는 켜져 있는 상태와 꺼져 있는 상태 중 하나의 상태를 가진다. i(1 < i < N)번 스위치를 누르면 i-1, i, i+1의 세 개의 전구의 상태가 바뀐다. 즉, 꺼져 있는 전구는 켜지고, 켜져 있는 전구는 꺼지게 된다. 1번 스위치를 눌렀을 경우에는 1, 2번 전구의 상태가 바뀌고, N번 스위치를 눌렀을 경우에는 N-1, N번 전구의 상태가 바뀐다.

N개의 전구들의 현재 상태와 우리가 만들고자 하는 상태가 주어졌을 때, 그 상태를 만들기 위해 스위치를 최소 몇 번 누르면 되는지 알아내는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 N(2 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 전구들의 현재 상태를 나타내는 숫자 N개가 공백 없이 주어진다. 그 다음 줄에는 우리가 만들고자 하는 전구들의 상태를 나타내는 숫자 N개가 공백 없이 주어진다. 0은 켜져 있는 상태, 1은 꺼져 있는 상태를 의미한다.

출력
첫째 줄에 답을 출력한다. 불가능한 경우에는 -1을 출력한다.

예제 입력 1
3
000
010
예제 출력 1
3
 */
package baekjoon.year2025.march;

import java.io.*;

public class BOJ2138 {
    static int N;
    static char[] initial, target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        initial = br.readLine().toCharArray();
        target = br.readLine().toCharArray();

        // 1번 스위치를 누르지 않는 경우
        int res1 = solve(initial.clone(), false);
        // 1번 스위치를 누르는 경우
        int res2 = solve(initial.clone(), true);

        // 두 경우 중 가능한 경우의 최소값을 출력
        int answer = Math.min(res1, res2);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static int solve(char[] state, boolean firstSwitch) {
        int count = 0;

        // 첫 번째 스위치를 누르는 경우
        if (firstSwitch) {
            flip(state, 0);
            count++;
        }

        for (int i = 1; i < N; i++) {
            // 이전 전구가 목표 상태와 다르면 현재 스위치를 눌러야 한다.
            if (state[i - 1] != target[i - 1]) {
                flip(state, i);
                count++;
            }
        }

        // 마지막 상태가 목표 상태와 같은지 확인
        if (isSame(state, target)) {
            return count;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    // 특정 위치의 전구를 눌러서 변경
    static void flip(char[] state, int idx) {
        for (int i = idx - 1; i <= idx + 1; i++) {
            if (i >= 0 && i < N) {
                state[i] = (state[i] == '0') ? '1' : '0';
            }
        }
    }

    // 현재 상태와 목표 상태가 같은지 비교
    static boolean isSame(char[] a, char[] b) {
        for (int i = 0; i < N; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}

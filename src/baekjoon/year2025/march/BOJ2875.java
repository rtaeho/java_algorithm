/*
문제
백준대학교에서는 대회에 나갈 때 2명의 여학생과 1명의 남학생이 팀을 결성해서 나가는 것이 원칙이다. (왜인지는 총장님께 여쭈어보는 것이 좋겠다.)

백준대학교는 뛰어난 인재들이 많아 올해에도 N명의 여학생과 M명의 남학생이 팀원을 찾고 있다. 대회에 참여하려는 학생들 중 K명은 반드시 인턴쉽 프로그램에 참여해야 한다. 인턴쉽에 참여하는 학생은 대회에 참여하지 못한다.

백준대학교에서는 뛰어난 인재들이 많기 때문에, 많은 팀을 만드는 것이 최선이다.

여러분은 여학생의 수 N, 남학생의 수 M, 인턴쉽에 참여해야하는 인원 K가 주어질 때 만들 수 있는 최대의 팀 수를 구하면 된다.

입력
첫째 줄에 N, M, K가 순서대로 주어진다. (0 ≤ M ≤ 100, 0 ≤ N ≤ 100, 0 ≤ K ≤ M+N),

출력
만들 수 있는 팀의 최대 개수을 출력하면 된다.

예제 입력 1
6 3 2
예제 출력 1
2
예제 입력 2
2 1 1
예제 출력 2
0
예제 입력 3
6 10 3
예제 출력 3
3
 */
package baekjoon.year2025.march;

import java.util.Scanner;

public class BOJ2875 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 여학생 수
        int M = sc.nextInt(); // 남학생 수
        int K = sc.nextInt(); // 인턴 수

        int team = 0;

        // 팀 최대 가능한 수부터 시작해서 하나씩 줄이기
        for (int t = Math.min(N / 2, M); t >= 0; t--) {
            int remain = (N - t * 2) + (M - t); // 남은 사람 수
            if (remain >= K) {
                team = t;
                break;
            }
        }

        System.out.println(team);
    }
}
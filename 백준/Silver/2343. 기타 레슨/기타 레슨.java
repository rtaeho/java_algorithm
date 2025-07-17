/*
 * 문제
강토는 자신의 기타 강의 동영상을 블루레이로 만들어 판매하려고 한다. 블루레이에는 총 N개의 강의가 들어가는데, 블루레이를 녹화할 때, 강의의 순서가 바뀌면 안 된다. 순서가 뒤바뀌는 경우에는 강의의 흐름이 끊겨, 학생들이 대혼란에 빠질 수 있기 때문이다. 즉, i번 강의와 j번 강의를 같은 블루레이에 녹화하려면 i와 j 사이의 모든 강의도 같은 블루레이에 녹화해야 한다.

강토는 이 블루레이가 얼마나 팔릴지 아직 알 수 없기 때문에, 블루레이의 개수를 가급적 줄이려고 한다. 오랜 고민 끝에 강토는 M개의 블루레이에 모든 기타 강의 동영상을 녹화하기로 했다. 이때, 블루레이의 크기(녹화 가능한 길이)를 최소로 하려고 한다. 단, M개의 블루레이는 모두 같은 크기이어야 한다.

강토의 각 강의의 길이가 분 단위(자연수)로 주어진다. 이때, 가능한 블루레이의 크기 중 최소를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 강의의 수 N (1 ≤ N ≤ 100,000)과 M (1 ≤ M ≤ N)이 주어진다. 다음 줄에는 강토의 기타 강의의 길이가 강의 순서대로 분 단위로(자연수)로 주어진다. 각 강의의 길이는 10,000분을 넘지 않는다.

출력
첫째 줄에 가능한 블루레이 크기중 최소를 출력한다.

예제 입력 1 
9 3
1 2 3 4 5 6 7 8 9
예제 출력 1 
17
힌트
강의는 총 9개이고, 블루레이는 총 3개 가지고 있다.

1번 블루레이에 1, 2, 3, 4, 5, 2번 블루레이에 6, 7, 3번 블루레이에 8, 9 를 넣으면 각 블루레이의 크기는 15, 13, 17이 된다. 블루레이의 크기는 모두 같아야 하기 때문에, 블루레이의 크기는 17이 된다. 17보다 더 작은 크기를 가지는 블루레이를 만들 수 없다.
 */
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] lectures = new int[N];
        st = new StringTokenizer(br.readLine());

        // 입력받으면서 최대값과 합계 계산
        int maxLength = 0;
        long totalLength = 0;
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            maxLength = Math.max(maxLength, lectures[i]);
            totalLength += lectures[i];
        }

        // 이분 탐색
        long left = maxLength; // 최소 크기는 가장 긴 강의 길이
        long right = totalLength; // 최대 크기는 모든 강의 길이의 합

        while (left < right) {
            long mid = (left + right) / 2;

            // 현재 크기(mid)로 몇 개의 블루레이가 필요한지 계산
            int count = 1;
            long sum = 0;

            for (int lecture : lectures) {
                if (sum + lecture > mid) {
                    count++;
                    sum = lecture;
                } else {
                    sum += lecture;
                }
            }

            if (count <= M) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}

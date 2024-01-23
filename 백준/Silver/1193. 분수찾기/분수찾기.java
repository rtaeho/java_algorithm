/*
문제
무한히 큰 배열에 다음과 같이 분수들이 적혀있다.

1/1	1/2	1/3	1/4	1/5	…
2/1	2/2	2/3	2/4	…	…
3/1	3/2	3/3	…	…	…
4/1	4/2	…	…	…	…
5/1	…	…	…	…	…
…	…	…	…	…	…
이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.

X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.

출력
첫째 줄에 분수를 출력한다.

예제 입력 1
1
예제 출력 1
1/1
예제 입력 2
2
예제 출력 2
1/2
예제 입력 3
3
예제 출력 3
2/1
예제 입력 4
4
예제 출력 4
3/1
예제 입력 5
5
예제 출력 5
2/2
예제 입력 6
6
예제 출력 6
1/3
예제 입력 7
7
예제 출력 7
1/4
예제 입력 8
8
예제 출력 8
2/3
예제 입력 9
9
예제 출력 9
3/2
예제 입력 10
14
예제 출력 10
2/4
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine()); //몇번째 분수인지.
        br.close();

        // 분수는 1/1부터 시작하는데, 해당 1/1의 대각선 라인에 칸의 개수는 1 => 초기값 1
        int squareCount = 1; // 해당 대각선(순회하는 대각선)에 있는 칸의 개수
        int squareSum = 0; // 해당 대각선의 전 대각선 칸을 누적 더하기 해서 저장하는 변수 (1/1보다 전은 없으니까 0)

        while (true) {
            //  해당 대각선의 전 대각선 칸의 누적 칸 + 현재 해당하는 대각선의 칸의 개수보다 X번째가 작다는 것은
            // 현재 해당하는 대각선에 해당 X번째의 분수가 있다는 것!
            if (X <= squareSum + squareCount) {
                if (squareCount % 2 == 1) { //해당 공식은 T와 같다. (해당 대각선의 칸 개수가 홀수, 분자+분모(T) = 짝수)
                    //대각선의 개수가 홀수인 범위 내에서는 위쪽(↗︎) 으로 순회 -> 분자 감소, 분모 증가
                    // ︎분자는 대각선에 있는 모든 칸의 개수 - (X - 해당 대각선의 전 대각선 칸누적 개수 -1)
                    System.out.println((squareCount - (X - squareSum - 1) + "/" + (X - squareSum)));
                    break;
                } else { //(해당 대각선의 칸의 개수가 짝수, 분자+분모(T) = 홀수)
                    //대각선의 개수가 짝수인 범위 내에서는 아래쪽(↙︎︎) 으로 순회 -> 분자 증가, 분모 감소
                    // ︎홀수와 반대로 계산하면 된다
                    System.out.println((X - squareSum) + "/" + (squareCount - (X - squareSum - 1)));
                    break;
                }
            } else { //아직 X번째 분수가 해당 대각선에 포함하지 않는 경우
                squareSum += squareCount;
                squareCount++; //대각선이 늘때마다 해당 칸의 개수도 +1늘기 때문에 +1
            }
        }

    }
}

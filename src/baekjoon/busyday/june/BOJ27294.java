/*
문제
고려대학교 로봇융합관에서 MatKor Cup을 준비하던 주영이는 같이 초밥을 먹자는 동우의 말에 호랭이 초밥 집에 갔다. 모듬 초밥을 먹으면서 동우와 주영이는 다음과 같은 대화를 하였다.

동우: "몇개고?"
주영: "응?"
동우: "밥알말이다. 몇개고?"
주영: "그건 또 뭔데?"
동우: "삼백 이십개다. 훈련된 초밥 장인이 이 한번 스시를 쥘 때 보통은 이 밥알이 삼백 이십개라. 점심 식사에는 삼백 이십개가 적당하다 캐도, 오늘 같은 날이나 술하고 같이 낼 때는 이백 팔십개만 해라, 어이? 배 안부르구로"
주영: "어디서 또 이상한거 배워왔냐"
동우: "너 혹시 재벌집 막내아들 뭔지 모르나?"
주영: "모른다"
대한민국을 뒤흔든 드라마를 모른다는 주영이의 말에 동우는 적잖은 충격을 받았다. 사태의 심각성을 느낀 동우는 주영이가 '재벌집 막내아들'을 보게 하기 위해 MatKor 사람들을 모았다. 주영이에게 그냥 영상을 보여주는 것보다 알고리즘을 이용해서 알려주어야 흥미를 가지게 할 수 있다고 생각한 MatKor 사람들은 주영이가 드라마에 흥미를 가지게 하기 초밥 밥알 갯수로 문제를 만들기로 했다. 자 MatKor에서 문제를 만들었고, 동우가 주영이에게 문제를 말했다.

동우: "오늘 나는 너가 만든 초밥을 먹을 거야. 너는 '재벌집 막내아들'의 진양철 회장님의 말에 따라 술하고 같이 초밥을 먹거나 점심 식사가 아닐 때는 초밥의 밥알을
$280$개로 하며, 점심 식사이면서 술과 같이 먹지 않을때는 초밥의 밥알을
$320$개로 하여 초밥을 만들어야 해, 근데, 내가 초밥을 언제 먹을지, 혹은 술과 같이 먹을지 아직 정하지 않았어. 내가 초밥을 먹는 시간과 술의 유무를 말하면, 그때 너는 너가 만들어야 하는 초밥의 밥알 갯수를 구해야해"
당신은 위의 문제를 읽고 주영이를 대신하여 동우의 문제를 해결하여라.

입력
첫 번째 줄에 시간을 의미하는 정수
$T$ (
$0 \le T \le 23$)와 술의 유무를 의미하는 정수
$S$ (
$0 \le S \le 1$)가 공백으로 구분되어 주어진다.
$T$가
$11$이하이면 아침 시간,
$12$이상
$16$ 이하이면 점심 시간, 그렇지 않으면 저녁 시간을 뜻한다.
$S$가
$1$ 이면 술과 함께 먹는 것을 의미하며,
$0$ 이면 술 없이 초밥을 먹는 것을 의미한다.

출력
첫 번째 줄에 주영이가 만들어야 하는 초밥 하나의 밥알의 갯수를 출력하여라.

예제 입력 1
16 0
예제 출력 1
320
점심 식사이며 술이 없으므로 320개이다.

예제 입력 2
14 1
예제 출력 2
280
점심 식사지만 술이 있으므로 280개이다.

예제 입력 3
17 0
예제 출력 3
280
저녁 식사 이므로 280개이다.

예제 입력 4
10 1
예제 출력 4
280
예제 입력 5
10 0
예제 출력 5
280
 */
package baekjoon.busyday.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ27294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        if (T <= 11) {
            System.out.println(280);
        } else if (T <= 16) {
            if (S == 0) {
                System.out.println(320);
            } else {
                System.out.println(280);
            }
        } else {
            System.out.println(280);
        }
    }
}

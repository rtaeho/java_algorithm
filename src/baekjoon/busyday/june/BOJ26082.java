/*
문제


Furiosa AI에서는 AI 연산에 최적화된 반도체인 WARBOY란 이름의 NPU(Neural Processing Unit)를 만들고 있다. NPU는 인공지능 모델의 학습 및 추론을 기존의 처리 유닛보다 훨씬 빠르게 할 수 있다.

WARBOY는 글로벌 AI 반도체 벤치마크 대회의 이미지 분류, 객체 검출 처리 속도 면에서 가장 좋은 성적을 받았다. 특히, WARBOY는 가격 대비 성능이 경쟁사 제품의 3배나 되어 많은 관심을 끌었다.

가격 대비 성능은 아래와 같은 수식으로 계산된다.

 가격대비성능
성능
가격

\[ \text{가격 대비 성능} = \frac{\text{성능}}{\text{가격}} \] 

경쟁사 제품의 가격
$A$, 경쟁사 제품의 성능
$B$, WARBOY의 가격
$C$가 주어질 때, WARBOY의 성능을 구해보자.

입력
첫째 줄에 세 양의 정수
$A$,
$B$,
$C$(
$1 \le A, B, C \le 1\,000$)가 공백으로 구분되어 주어진다.

 
$\mathbf{\mathit{B}}$는 항상
$\mathbf{\mathit{A}}$의 배수이다.

출력
첫째 줄에 WARBOY의 성능을 출력한다.

예제 입력 1
10 100 7
예제 출력 1
210
 */
package baekjoon.busyday.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ26082 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(b / a * 3 * c);
    }
}

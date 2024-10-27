/*
문제
N개의 에너지 구슬이 일렬로 놓여져 있고, 에너지 구슬을 이용해서 에너지를 모으려고 한다.

i번째 에너지 구슬의 무게는 Wi이고, 에너지를 모으는 방법은 다음과 같으며, 반복해서 사용할 수 있다.

에너지 구슬 하나를 고른다. 고른 에너지 구슬의 번호를 x라고 한다. 단, 첫 번째와 마지막 에너지 구슬은 고를 수 없다.
x번째 에너지 구슬을 제거한다.
Wx-1 × Wx+1의 에너지를 모을 수 있다.
N을 1 감소시키고, 에너지 구슬을 1번부터 N번까지로 다시 번호를 매긴다. 번호는 첫 구슬이 1번, 다음 구슬이 2번, ... 과 같이 매겨야 한다.
N과 에너지 구슬의 무게가 주어졌을 때, 모을 수 있는 에너지 양의 최댓값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 에너지 구슬의 개수 N(3 ≤ N ≤ 10)이 주어진다.

둘째 줄에는 에너지 구슬의 무게 W1, W2, ..., WN을 공백으로 구분해 주어진다. (1 ≤ Wi ≤ 1,000)

출력
첫째 줄에 모을 수 있는 에너지의 최댓값을 출력한다.

예제 입력 1
4
1 2 3 4
예제 출력 1
12
예제 입력 2
5
100 2 1 3 100
예제 출력 2
10400
예제 입력 3
7
2 2 7 6 90 5 9
예제 출력 3
1818
예제 입력 4
10
1 1 1 1 1 1 1 1 1 1
예제 출력 4
8
 */
package baekjoon.intermediate_algorithm_1.bruteforce_permutation_recur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ16198 {
    static int N;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        charge(list, 0);
        System.out.print(max);
    }

    static void charge(List<Integer> list, int sum) {
        if (list.size() == 2) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 1; i < list.size() - 1; i++) {
            int tmp = list.get(i);
            int chargeValue = list.get(i - 1) * list.get(i + 1);
            list.remove(i);
            charge(list, sum + chargeValue);
            list.add(i, tmp);
        }
    }
}
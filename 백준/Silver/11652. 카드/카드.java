/*
문제
준규는 숫자 카드 N장을 가지고 있다. 숫자 카드에는 정수가 하나 적혀있는데, 적혀있는 수는 -262보다 크거나 같고, 262보다 작거나 같다.

준규가 가지고 있는 카드가 주어졌을 때, 가장 많이 가지고 있는 정수를 구하는 프로그램을 작성하시오. 만약, 가장 많이 가지고 있는 정수가 여러 가지라면, 작은 것을 출력한다.

입력
첫째 줄에 준규가 가지고 있는 숫자 카드의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개 줄에는 숫자 카드에 적혀있는 정수가 주어진다.

출력
첫째 줄에 준규가 가장 많이 가지고 있는 정수를 출력한다.

예제 입력 1
5
1
2
1
2
1
예제 출력 1
1
예제 입력 2
6
1
2
1
2
1
2
예제 출력 2
1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<Long, Integer> countMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        long answer = 0;
        int maxCount = 0;

        for (Map.Entry<Long, Integer> entry : countMap.entrySet()) {
            long key = entry.getKey();
            int value = entry.getValue();

            if (value > maxCount) {
                maxCount = value;
                answer = key;
            } else if (value == maxCount) {
                answer = Math.min(answer, key);
            }
        }

        System.out.println(answer);
    }
}
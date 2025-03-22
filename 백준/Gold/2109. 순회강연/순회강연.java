/*
문제
한 저명한 학자에게 n(0 ≤ n ≤ 10,000)개의 대학에서 강연 요청을 해 왔다. 각 대학에서는 d(1 ≤ d ≤ 10,000)일 안에 와서 강연을 해 주면 p(1 ≤ p ≤ 10,000)만큼의 강연료를 지불하겠다고 알려왔다. 각 대학에서 제시하는 d와 p값은 서로 다를 수도 있다. 이 학자는 이를 바탕으로, 가장 많은 돈을 벌 수 있도록 순회강연을 하려 한다. 강연의 특성상, 이 학자는 하루에 최대 한 곳에서만 강연을 할 수 있다.

예를 들어 네 대학에서 제시한 p값이 각각 50, 10, 20, 30이고, d값이 차례로 2, 1, 2, 1 이라고 하자. 이럴 때에는 첫째 날에 4번 대학에서 강연을 하고, 둘째 날에 1번 대학에서 강연을 하면 80만큼의 돈을 벌 수 있다.

입력
첫째 줄에 정수 n이 주어진다. 다음 n개의 줄에는 각 대학에서 제시한 p값과 d값이 주어진다.

출력
첫째 줄에 최대로 벌 수 있는 돈을 출력한다.

예제 입력 1
7
20 1
2 1
10 3
100 2
8 2
5 20
50 10
예제 출력 1
185
 */
import java.io.*;
import java.util.*;

public class Main {
    static class Lecture {
        int pay, day;

        public Lecture(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Lecture> lectures = new ArrayList<>();
        int maxDay = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(p, d));
            maxDay = Math.max(maxDay, d);
        }

        // 마감일 오름차순, 마감일이 같다면 pay 내림차순 정렬
        lectures.sort((a, b) -> {
            if (a.day == b.day) {
                return b.pay - a.pay;
            }
            return a.day - b.day;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 최소 힙

        for (Lecture lec : lectures) {
            pq.offer(lec.pay);

            // 현재 마감일보다 더 많은 강연이 들어온 경우 수익 낮은 강연 제거
            if (pq.size() > lec.day) {
                pq.poll();
            }
        }

        int result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll();
        }

        System.out.println(result);
    }
}
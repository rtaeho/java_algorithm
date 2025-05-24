/*
문제
N개의 직사각형 모양의 건물들이 주어졌을 때, 스카이라인을 구해내는 프로그램을 작성하시오. 스카이라인은 건물 전체의 윤곽을 의미한다. 즉, 각각의 건물을 직사각형으로 표현했을 때, 그러한 직사각형들의 합집합을 구하는 문제이다.



예를 들어 직사각형 모양의 건물들이 위와 같이 주어졌다고 하자. 각각의 건물은 왼쪽 x좌표와 오른쪽 x좌표, 그리고 높이로 나타난다. 모든 건물들은 편의상 같은 높이의 지면(땅) 위에 있다고 가정하자. 위의 예에서 스카이라인을 구하면 아래와 같다.



입력
첫째 줄에 건물의 개수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 N개의 줄에는 N개의 건물에 대한 정보가 주어진다. 건물에 대한 정보는 세 정수 L, H, R로 나타나는데, 각각 건물의 왼쪽 x좌표, 높이, 오른쪽 x좌표를 의미한다. (1 ≤ L < R ≤ 1,000,000,000, 1 ≤ H ≤ 1,000,000,000)

출력
첫째 줄에 스카이라인을 출력한다. 출력을 할 때에는 높이가 변하는 지점에 대해서, 그 지점의 x좌표와 그 지점에서의 높이를 출력한다.

예제 입력 1
8
1 11 5
2 6 7
3 13 9
12 7 16
14 3 25
19 18 22
23 13 29
24 4 28
예제 출력 1
1 11 3 13 9 0 12 7 16 3 19 18 22 3 23 13 29 0
 */
import java.io.*;
import java.util.*;

public class Main {
    static class Event implements Comparable<Event> {
        int x, h;
        boolean isStart;

        Event(int x, int h, boolean isStart) {
            this.x = x;
            this.h = h;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Event other) {
            if (this.x != other.x) {
                return Integer.compare(this.x, other.x);
            }
            if (this.isStart && other.isStart) {
                return Integer.compare(other.h, this.h);
            }
            if (!this.isStart && !other.isStart) {
                return Integer.compare(this.h, other.h);
            }
            return this.isStart ? -1 : 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Event> events = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            events.add(new Event(L, H, true));
            events.add(new Event(R, H, false));
        }

        Collections.sort(events);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> heightCount = new HashMap<>();
        pq.add(0);
        heightCount.put(0, 1);

        int prevHeight = 0;
        StringBuilder sb = new StringBuilder();

        for (Event e : events) {
            if (e.isStart) {
                pq.add(e.h);
                heightCount.put(e.h, heightCount.getOrDefault(e.h, 0) + 1);
            } else {
                heightCount.put(e.h, heightCount.get(e.h) - 1);
            }

            while (!pq.isEmpty() && heightCount.get(pq.peek()) == 0) {
                pq.poll();
            }

            int currHeight = pq.peek();
            if (currHeight != prevHeight) {
                sb.append(e.x).append(" ").append(currHeight).append(" ");
                prevHeight = currHeight;
            }
        }

        System.out.println(sb.toString().trim());
    }
}

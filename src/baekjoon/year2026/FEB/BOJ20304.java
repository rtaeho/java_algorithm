package baekjoon.year2026.FEB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ20304 {
    static int N, M;
    static int[] safety;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        // 안전 거리: 서로 다른 자리의 개수 -> xor 연산
        // 안전도: 모든 시도의 안전 거리 중 최솟값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        safety = new int[N + 1];
        Arrays.fill(safety, -1);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            safety[tmp] = 0;
            queue.offer(tmp);
        }
        // 브루트 포스로 하면 시간 초과
        System.out.println(bfs());
    }
    static int bfs(){
        int maxSafety = 0;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            // 문제의 범위 1,000,000은 약 2^20 언저리
            for (int i = 0; i < 20; i++) {
                int next = cur ^ (1 << i);
                // 지금 숫자와 i번째의 비트가 다른 숫자
                if(next <= N){
                    if(safety[next] == -1){ // 방문 여부 체크
                        safety[next] = safety[cur] + 1; // 1비트 다르므로 안전도 + 1
                        queue.offer(next);
                        maxSafety = Math.max(maxSafety, safety[next]);
                    }
                }
            }
        }

        return maxSafety;
    }
}

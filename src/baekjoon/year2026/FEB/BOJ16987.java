package baekjoon.year2026.FEB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16987 {
    static class Egg {
        int durability;
        int weight;

        Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }

    static Egg[] eggs;
    static int answer = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        eggs = new Egg[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int durability = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(durability, weight);
        }
        solve(0, 0);
        System.out.println(answer);
    }

    static void solve(int idx, int brokenCount) {
        // 마지막 계란이거나 이미 다 깨진 경우
        if (idx == N || brokenCount == N - 1) {
            answer = Math.max(answer, brokenCount);
            return;
        }

        // 지금 계란이 깨져있는 경우
        if (eggs[idx].durability <= 0) {
            solve(idx + 1, brokenCount);
            return;
        }

        // 계란치기
        for (int i = 0; i < N; i++) {
            // 나 자신이거나 이미 깨진 경우
            if (i == idx || eggs[i].durability <= 0) {
                continue;
            }

            // 치기
            eggs[idx].durability -= eggs[i].weight;
            eggs[i].durability -= eggs[idx].weight;

            // 체크
            int nextBroken = brokenCount;
            if (eggs[idx].durability <= 0) {
                nextBroken++;
            }
            if (eggs[i].durability <= 0) {
                nextBroken++;
            }
            // 다음
            solve(idx + 1, nextBroken);

            // 복구
            eggs[idx].durability += eggs[i].weight;
            eggs[i].durability += eggs[idx].weight;
        }
    }
}

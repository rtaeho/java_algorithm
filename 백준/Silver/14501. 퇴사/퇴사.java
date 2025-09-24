import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] t = new int[n + 1]; // 걸리는 시간
        int[] p = new int[n + 1]; // 버는 돈
        
        // 기본 입력
        for(int i = 1; i <= n; i++){
            String[] input = br.readLine().split(" ");
            t[i] = Integer.parseInt(input[0]);
            p[i] = Integer.parseInt(input[1]);
        }
        
        int[] dp = new int[n + 2]; // i일 까지의 최대 수익
        
        for (int i = 1; i <= n; i++) {
            // 1. i일 상담을 하지 않는 경우, i+1일의 수익은 i일과 동일하거나 큼
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            // 2. i일 상담을 하는 경우
            int endDay = i + t[i]; // 끝나는 날
            if (endDay <= n + 1) { // 퇴사일 이전에 상담이 끝나는 경우
                dp[endDay] = Math.max(dp[endDay], dp[i] + p[i]);
            }
        }
        
        System.out.println(dp[n + 1]);
    }
}
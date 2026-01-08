package baekjoon.year2026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ3015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());
            int cnt = 1;
            while(!stack.isEmpty() && stack.peek()[0] <= height){
                int[] top = stack.pop();
                result += top[1];

                if (top[0] == height) { // 같으면 한 사람으로 취급
                    cnt += top[1];
                }
                // 작은 경우는 위에서 pop 했기에 별도 처리 불필요

            }
            if(!stack.isEmpty()) { // 남아있으면
                result++;
            }
            stack.push(new int[]{height, cnt}); // 그 후 내 값 넣음
        }

        System.out.println(result);
    }
}

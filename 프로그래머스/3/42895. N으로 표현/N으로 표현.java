import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // N과 number가 같으면 1번만 사용
        if (N == number) return 1;
        
        // dp = N을 i번 사용해서 만들 수 있는 모든 수의 집합
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        
        // N을 1번부터 8번까지 사용
        for (int i = 1; i <= 8; i++) {
            int continuousN = 0;
            for (int j = 0; j < i; j++) {
                continuousN = continuousN * 10 + N;
            }
            // 붙여서 만드는 숫자 추가
            dp.get(i).add(continuousN);
            
            for (int j = 1; j < i; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        // 기존 숫자로 만들 수 있는 숫자 추가
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) {
                            dp.get(i).add(a / b);
                        }
                    }
                }
            }
            if (dp.get(i).contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}
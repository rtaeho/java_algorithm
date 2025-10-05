import java.util.*;

class Solution {
    public int[] solution(int n) {
        Set<Integer> set = new TreeSet<>();
        
        int temp = n;
        for (int i = 2; i * i <= temp; i++) {
            while (temp % i == 0) {
                set.add(i);
                temp /= i;
            }
        }
        
        if (temp > 1) {
            set.add(temp);
        }
        
        int[] answer = new int[set.size()];
        int idx = 0;
        for (int val : set) {
            answer[idx++] = val;
        }

        return answer;
    }
}
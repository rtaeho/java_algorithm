import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int n = emergency.length;
        int[] sorted = emergency.clone();
        Arrays.sort(sorted);
        
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            int rank = n - Arrays.binarySearch(sorted, emergency[i]);
            answer[i] = rank;
        }
        
        return answer;
    }
}
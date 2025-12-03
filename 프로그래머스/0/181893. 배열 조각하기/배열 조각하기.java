import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        int start = 0;
        int end = arr.length - 1;
    
        for (int i = 0; i < query.length; i++) {
            int queryValue = query[i];
            
            if (i % 2 == 0) {
                end = start + queryValue;
            } else {
                start = start + queryValue;
            }
        }
        
        return Arrays.copyOfRange(arr, start, end + 1);
    }
}
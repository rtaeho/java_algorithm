import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < intervals.length; i++){
            for(int j = intervals[i][0]; j <= intervals[i][1]; j++){
                list.add(arr[j]);
            }
        }
        int n = list.size();
        int[] answer = new int[n];
        for(int i = 0 ; i < n; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
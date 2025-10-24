import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = {};
        int n = num_list.length;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            list.add(num_list[i]);
        }
        if(num_list[n - 1] > num_list[n - 2]){
            list.add(num_list[n - 1] - num_list[n - 2]);
        }
        else{
            list.add(num_list[n - 1] * 2);
        }
        answer = new int[n + 1];
        
        for(int i = 0; i < n + 1; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
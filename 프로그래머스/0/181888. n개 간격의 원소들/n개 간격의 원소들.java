import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < num_list.length; i += n){
            list.add(num_list[i]);
        }
        int m = list.size();
        answer = new int[m];
        for(int i = 0; i < m; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
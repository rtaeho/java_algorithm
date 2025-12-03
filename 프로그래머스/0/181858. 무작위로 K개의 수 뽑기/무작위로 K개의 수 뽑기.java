import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(!list.contains(arr[i])){
                list.add(arr[i]);
            }
        }
        int[] answer = new int[k];
        for(int i = 0; i < k; i++){
            if(i < list.size()){
                answer[i] = list.get(i);
            }
            else{
                answer[i] = -1;
            }
        }
        return answer;
    }
}
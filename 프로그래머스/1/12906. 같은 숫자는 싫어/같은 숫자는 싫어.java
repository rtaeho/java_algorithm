import java.util.*;

public class Solution {
    public int[] solution(int [] arr) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(arr[0]);
        int lastNum = arr[0];
        for(int num : arr){
            if(num == lastNum){
                continue;
            }
            list.add(num);
            lastNum = num;
        }
        int[] answer = list.stream().mapToInt(i->i).toArray();
        return answer;
    }
}
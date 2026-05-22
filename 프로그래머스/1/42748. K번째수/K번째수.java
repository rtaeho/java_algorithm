import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[commands.length];
        int index = 0;
        for(int[] command : commands){
            list.clear();
            int start = command[0] - 1;
            int end = command[1] - 1;
            int idx = command[2] - 1;
            for(int i = start; i <= end; i++){
                list.add(array[i]);
            }
            Collections.sort(list);
            answer[index++] = list.get(idx);
        }
        return answer;
    }
}
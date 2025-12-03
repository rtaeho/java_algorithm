import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> resultList = new ArrayList<>();
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(5);
        
        long limit = r; 
        
        while (!queue.isEmpty()) {
            int currentNum = queue.poll();
            
            if (currentNum > limit) {
                continue;
            }
            
            if (currentNum >= l) {
                resultList.add(currentNum);
            }
            
            long nextNumWith0 = (long)currentNum * 10;
            if (nextNumWith0 <= limit) {
                queue.offer((int)nextNumWith0);
            }
            
            long nextNumWith5 = (long)currentNum * 10 + 5;
            if (nextNumWith5 <= limit) {
                queue.offer((int)nextNumWith5);
            }
        }
        
        if (resultList.isEmpty()) {
            return new int[]{-1};
        } else {
            int[] answer = new int[resultList.size()];
            for (int i = 0; i < resultList.size(); i++) {
                answer[i] = resultList.get(i);
            }
            return answer;
        }
    }
}
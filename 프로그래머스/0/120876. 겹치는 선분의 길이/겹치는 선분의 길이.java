import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        Map<Integer, Integer> lineCount = new HashMap<>();
        
        for(int i = 0; i < 3; i++){
            int start = lines[i][0];
            int end = lines[i][lines.length - 2];
            
            for(int j = start; j < end; j++){
                lineCount.put(j, lineCount.getOrDefault(j, 0) + 1);
            }
        }
        
        int answer = 0;
        for(int count : lineCount.values()){
            if(count >= 2){
                answer++;
            }
        }
        
        return answer;
    }
}
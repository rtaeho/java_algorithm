import java.util.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer,Integer> maps = new HashMap<>();
        
        for(int num : array){
            maps.put(num, maps.getOrDefault(num, 0) + 1);
        }
        
        int maxFreq = Collections.max(maps.values());
        
        int mode = -1;
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : maps.entrySet()){
            if(entry.getValue() == maxFreq){
                mode = entry.getKey();
                count++;
            }
        }
        return count > 1 ? -1 : mode;
    }
}
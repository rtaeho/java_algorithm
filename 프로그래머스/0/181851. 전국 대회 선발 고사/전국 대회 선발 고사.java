import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        Map<Integer, Integer> newRank = new HashMap<>();
        
        for(int i = 0; i < rank.length; i++){
            if(attendance[i]){
                newRank.put(i, rank[i]);
            }
        }
        
        List<Integer> keys = new ArrayList<>(newRank.keySet());
        keys.sort((o1, o2) -> newRank.get(o1).compareTo(newRank.get(o2)));
        
        int a = keys.get(0);
        int b = keys.get(1);
        int c = keys.get(2);
        
        return 10000 * a + 100 * b + c;
    }
}
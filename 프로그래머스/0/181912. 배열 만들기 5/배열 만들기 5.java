import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> resultList = new ArrayList<>();
        
        for (String str : intStrs) {
            String subString = str.substring(s, s + l);
            
            int convertedInt = Integer.parseInt(subString);

            if (convertedInt > k) {
                resultList.add(convertedInt);
            }
        }
        
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}
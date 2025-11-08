import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] parts = myString.split("x");
        
        List<String> resultList = new ArrayList<>();
    
        for (String part : parts) {
            if (!part.isEmpty()) {
                resultList.add(part);
            }
        }
        
        Collections.sort(resultList);
        
        return resultList.toArray(new String[0]);
    }
}
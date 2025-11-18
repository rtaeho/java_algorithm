import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] parts = myStr.split("[abc]+");
        
        List<String> resultList = new ArrayList<>();
        
        for (String part : parts) {
            if (!part.isEmpty()) { 
                resultList.add(part);
            }
        }
        
        if (resultList.isEmpty()) {
            return new String[] {"EMPTY"};
        } else {
            return resultList.toArray(new String[0]);
        }
    }
}
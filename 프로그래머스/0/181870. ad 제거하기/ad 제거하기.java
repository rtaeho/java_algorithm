import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(String[] strArr) {
        List<String> resultList = new ArrayList<>();
        
        for (String str : strArr) {
            if (!str.contains("ad")) {
                resultList.add(str);
            }
        }

        return resultList.toArray(new String[0]);
    }
}
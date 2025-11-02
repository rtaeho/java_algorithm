import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        String[] strArr = my_string.split(" ");
        
        List<String> list = new ArrayList<>();
        for (String str : strArr) {
            if (str.length() > 0) { 
                list.add(str);
            }
        }
        
        String[] answer = new String[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
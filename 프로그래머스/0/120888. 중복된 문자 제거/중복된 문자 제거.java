import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for(char c : my_string.toCharArray()){
            if(set.add(c)){
                sb.append(c);
            }
        }
        answer = sb.toString();
        return answer;
    }
}
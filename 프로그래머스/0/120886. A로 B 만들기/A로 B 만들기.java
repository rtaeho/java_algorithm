import java.util.*;

class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        char[] st1 = before.toCharArray();
        char[] st2 = after.toCharArray();
        
        Arrays.sort(st1);
        Arrays.sort(st2);
        
        answer = Arrays.equals(st1, st2) ? 1 : 0;
        return answer;
    }
}
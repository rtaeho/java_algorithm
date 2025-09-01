import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        answer = my_string.chars()
                        .mapToObj(c -> String.valueOf((char)c).repeat(n))
                        .collect(Collectors.joining());
        return answer;
    }
}
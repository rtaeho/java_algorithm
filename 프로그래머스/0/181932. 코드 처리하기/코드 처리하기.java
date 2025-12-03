import java.lang.StringBuilder;

class Solution {
    public String solution(String code) {
        StringBuilder ret = new StringBuilder();
        
    
        int mode = 0;
        
        for (int idx = 0; idx < code.length(); idx++) {
            char current = code.charAt(idx);
            
            if (mode == 0) {
                if (current == '1') {
                    mode = 1;
                } else {
                    if (idx % 2 == 0) {
                        ret.append(current);
                    }
                }
            } else {
                if (current == '1') {
                    mode = 0;
                } else {
                    if (idx % 2 != 0) {
                        ret.append(current);
                    }
                }
            }
        }
        
        String answer = ret.toString();
        
        if (answer.isEmpty()) {
            return "EMPTY";
        } else {
            return answer;
        }
    }
}
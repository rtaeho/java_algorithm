class Solution {
    public String solution(int q, int r, String code) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < code.length(); i++) {
            int remainder = i % q; 
            
            if (remainder == r) {
                result.append(code.charAt(i));
            }
        }
        return result.toString();
    }
}
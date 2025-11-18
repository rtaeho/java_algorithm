class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        boolean term1 = x1 || x2;
        
        boolean term2 = x3 || x4;
        
        boolean answer = term1 && term2;
        
        return answer;
    }
}
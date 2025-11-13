class Solution {
    public String solution(String myString, String pat) {
        int idx = myString.lastIndexOf(pat);
        int lastIdx = idx + pat.length();
            
        String answer = myString.substring(0, lastIdx);
        return answer;
    }
}
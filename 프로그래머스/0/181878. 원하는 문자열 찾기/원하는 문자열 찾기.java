class Solution {
    public int solution(String myString, String pat) {
        myString = myString.toLowerCase();
        pat = pat.toLowerCase();
        int answer = myString.contains(pat) ? 1 : 0;
        return answer;
    }
}
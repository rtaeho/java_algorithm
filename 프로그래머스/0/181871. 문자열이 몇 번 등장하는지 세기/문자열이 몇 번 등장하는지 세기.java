class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int index = 0;
        
        while (true) {
            int foundIndex = myString.indexOf(pat, index);

            if (foundIndex == -1) {
                break;
            }
            answer++;
            index = foundIndex + 1; 
        }
        
        return answer;
    }
}
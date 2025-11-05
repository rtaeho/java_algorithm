class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        for(int i = 1; i < numLog.length; i++){
            int diff = numLog[i] - numLog[i - 1];
            String tmp;
            if(diff == 1){
                tmp = "w";
            }
            else if(diff == -1){
                tmp = "s";
            }
            else if(diff == 10){
                tmp = "d";
            }
            else{
                tmp = "a";
            }
            answer += tmp;
        }
        return answer;
    }
}
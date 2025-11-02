class Solution {
    public String[] solution(String[] strArr) {
        int n = strArr.length;
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                answer[i] = strArr[i].toLowerCase();
            }
            else{
                answer[i] = strArr[i].toUpperCase();
            }
        }
        return answer;
    }
}
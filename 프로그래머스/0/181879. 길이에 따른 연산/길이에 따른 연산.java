class Solution {
    public int solution(int[] num_list) {
        int answer;
        int n = num_list.length;
        if(n > 10){
            answer = 0;
            for(int i = 0; i < n; i++){
                answer += num_list[i];
            }
        }
        else{
            answer = 1;
            for(int i = 0; i < n; i++){
                answer *= num_list[i];
            }
        }
        return answer;
    }
}
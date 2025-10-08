class Solution {
    public int solution(int[] common) {
        int answer = 0;
        if((common[0] * common[2]) == (common[1] * common[1])){
            if(common[0] == 0) return 0;
            answer = common[common.length - 1] * (common[1] / common[0]);
        }
        else{
            answer = common[common.length - 1] + common[1] - common[0];
        }
        
        return answer;
    }
}
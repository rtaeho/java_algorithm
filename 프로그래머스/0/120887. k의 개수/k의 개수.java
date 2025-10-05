class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(;i<=j;i++){
            answer += hasNum(i,k);
        }
        return answer;
    }
    private int hasNum(int n, int k){
        int cnt = 0;
        while(n>0){
            if(n%10 == k){
                cnt++;
            }
            n/=10;
        }
        return cnt;
    }
}
class Solution {
    public int solution(int n) {
        int answer = 1;
        for(int i=10;i>0;i--){
            if(factorial(i)<=n){
                return i;
            }
        }
        return answer;
    }
    private int factorial(int n){
        if(n==1) return 1;
        return n*factorial(n-1);
    }
}
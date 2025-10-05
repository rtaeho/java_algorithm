class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 3; i <= n; i++){
            if(!isPrime(i)) {
                System.out.print(i);
                answer++;
            }
        }
        return answer;
    }
    private boolean isPrime(int n){
        for(int i=2; i<n; i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}
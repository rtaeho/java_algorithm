class Solution {
    public int solution(int n) {
        int answer = 0;
        
        n = n % 2 == 0 ? n : n - 1;
        
        while (n > 1) {
            answer += n;
            n -= 2;
        }
        return answer;
    }
}
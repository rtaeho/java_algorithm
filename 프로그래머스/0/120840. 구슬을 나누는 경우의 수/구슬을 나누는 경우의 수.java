class Solution {
    public int solution(int balls, int share) {
        int answer = 0;
        answer = combination(balls, share);
        return answer;
    }
    
        private int combination(int n, int r) {
        long result = 1;
        int k = Math.min(r, n - r);

        for (int i = 1; i <= k; i++) {
            result = result * (n - i + 1) / i;
        }

        return (int) result;
    }
}
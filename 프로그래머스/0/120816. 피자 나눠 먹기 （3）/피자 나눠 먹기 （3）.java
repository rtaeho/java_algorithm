class Solution {
    public int solution(int slice, int n) {
        int answer = 0;
        answer = (n + slice - 1) / slice;
        return answer;
    }
}
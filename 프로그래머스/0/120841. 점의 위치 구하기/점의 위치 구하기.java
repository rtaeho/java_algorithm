class Solution {
    public int solution(int[] dot) {
        int answer = 0;
        int x = dot[0], y = dot[1];
        answer = (x > 0 ? (y > 0 ? 1 : 4) : (y > 0 ? 2 : 3));
        return answer;
    }
}
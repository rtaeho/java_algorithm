class Solution {
    public int solution(int a, int b) {
        int answer = 0;

        boolean aIsOdd = (a % 2 != 0);
        boolean bIsOdd = (b % 2 != 0);

        if (aIsOdd && bIsOdd) {
            answer = a * a + b * b;
        } else if (aIsOdd || bIsOdd) {
            answer = 2 * (a + b);
        } else {
            answer = Math.abs(a - b);
        }

        return answer;
    }
}
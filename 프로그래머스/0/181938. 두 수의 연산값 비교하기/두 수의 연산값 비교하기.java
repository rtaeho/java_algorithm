class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        answer = calculate(a, b) >= 2 * a * b ? calculate(a, b) : 2 * a * b;
        return answer;
    }
    private int calculate(int a, int b){
        String str;
        str = "" + a + b;
        return Integer.valueOf(str);
    }
}
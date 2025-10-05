class Solution {
    public int solution(int[] sides) {
        int a = sides[0];
        int b = sides[1];
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        
        return (a + b - 1 - max) + min;
    }
}
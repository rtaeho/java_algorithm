class Solution {
    public int solution(int a, int b) {
        int answer = 1;
        
        b /= gcd(a,b);
        
        while (b % 2 == 0) {
            b /= 2;
        }
        while (b % 5 == 0) {
            b /= 5;
        }
        
        return b == 1 ? 1 : 2;
    }
    private int gcd(int x, int y) {
        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}
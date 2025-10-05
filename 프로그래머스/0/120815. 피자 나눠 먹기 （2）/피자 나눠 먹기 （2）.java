class Solution {
    public int solution(int n) {
        int answer = 0;
        answer = lcm(n, 6) / 6;
        return answer;
    }
    
    // 최소공배수 = a*b/최대공약수(a,b)
    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // 최대공약수
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
import java.lang.Math;
import java.util.Arrays;

class Solution {
    public int solution(int a, int b, int c, int d) {
        
        int[] dice = {a, b, c, d};
        Arrays.sort(dice);
        
        a = dice[0];
        b = dice[1];
        c = dice[2];
        d = dice[3];

        int result = 0;
        
        if (a == d) {
            result = 1111 * a;
        } 
        
        else if (a == c || b == d) {
            int p, q;
            if (a == c) {
                p = a; 
                q = d;
            } else {
                p = b; 
                q = a;
            }
            result = (int) Math.pow(10 * p + q, 2);
        }
        
        else if (a == b && c == d) {
            int p = a;
            int q = c;
            result = (p + q) * Math.abs(p - q);
        }
        
        else if (a == b || b == c || c == d) {
            int q, r;
            
            if (a == b) {
                q = c;
                r = d;
            } else if (b == c) {
                q = a;
                r = d;
            } else {
                q = a;
                r = b;
            }
            result = q * r;
        }
        
        else { 
            result = a;
        }
        
        return result;
    }
}
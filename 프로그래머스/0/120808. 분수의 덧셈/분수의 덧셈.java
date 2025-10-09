class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int bunmo = LCM(denom1, denom2);
        int bunza1 = numer1*(bunmo/denom1);
        int bunza2 = numer2*(bunmo/denom2);
        int bunza = bunza1 + bunza2;
        int yackbun = GCD(bunza, bunmo);
        bunza /= yackbun;
        bunmo /= yackbun;
        answer[0] = bunza;
        answer[1] = bunmo;
        return answer;
    }
    
    private int GCD(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    private int LCM(int a, int b){
        return a * b / GCD(a, b);
    }
}
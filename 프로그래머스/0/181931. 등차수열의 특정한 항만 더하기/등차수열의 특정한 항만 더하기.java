class Solution {
    public int solution(int a, int d, boolean[] included) {
        int sum = 0;
        
        for (int i = 0; i < included.length; i++) {
            int currentTerm = a + i * d;
            if (included[i]) {
                sum += currentTerm;
            }
        }
        
        return sum;
    }
}
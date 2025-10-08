class Solution {
    public int solution(int n) {
        int count = 0;
        int number = 0;
        
        while (count < n) {
            number++;
            if (String.valueOf(number).contains("3") || number % 3 == 0) {
                continue;
            }
            
            count++;
        }
        
        return number;
    }
}
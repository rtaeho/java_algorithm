class Solution {
    public int solution(int[] num_list) {
        int total_count = 0; 
        for (int n : num_list) {
            while (n != 1) {
                if (n % 2 == 0) {
                    n = n / 2;
                } else {
                    n = (n - 1) / 2;
                }
                total_count++;
            }
        }
        
        return total_count;
    }
}
class Solution {
    public int solution(String[] strArr) {
        int[] countByLength = new int[31];
        
        for (String str : strArr) {
            int length = str.length();
            countByLength[length]++;
        }
        
        int maxCount = 0;
        for (int i = 1; i < 31; i++) {
            if (countByLength[i] > maxCount) {
                maxCount = countByLength[i];
            }
        }
        
        return maxCount;
    }
}
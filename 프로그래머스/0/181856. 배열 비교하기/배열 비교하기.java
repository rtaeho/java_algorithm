class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        
        if (len1 != len2) {
            if (len1 > len2) {
                return 1;
            } else {
                return -1;
            }
        } 
        
        else {
            long sum1 = 0;
            for (int val : arr1) {
                sum1 += val;
            }
            
            long sum2 = 0;
            for (int val : arr2) {
                sum2 += val;
            }
            
            if (sum1 > sum2) {
                return 1;
            } else if (sum2 > sum1) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
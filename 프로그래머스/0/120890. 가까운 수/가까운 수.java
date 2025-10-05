class Solution {
    public int solution(int[] array, int n) {
        int minDiff = Integer.MAX_VALUE;
        int minNum = array[0];
        for(int i = 0; i < array.length; i++){
            int diff = Math.abs(array[i] - n);
            if(diff < minDiff){
                minDiff = diff;
                minNum = array[i];
            }
            else if(diff == minDiff){
                minNum = minNum < array[i] ? minNum : array[i];
            }
        }
        return minNum;
    }
    
}
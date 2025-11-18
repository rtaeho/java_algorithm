import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int startIndex = -1;
        int endIndex = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                startIndex = i;
                break;
            }
        }
        
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 2) {
                endIndex = i;
                break;
            }
        }
        
        if (startIndex == -1) {
            return new int[] {-1};
        }
        
        return Arrays.copyOfRange(arr, startIndex, endIndex + 1);
    }
}
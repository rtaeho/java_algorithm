import java.util.Arrays;

class Solution {

    private boolean isSameArray(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    
    private int transform(int value) {
        if (value >= 50 && value % 2 == 0) {
            return value / 2;
        } else if (value < 50 && value % 2 != 0) {
            return value * 2 + 1;
        } else {
            return value;
        }
    }

    public int solution(int[] arr) {
        int x = 0;
        int[] currentArr = Arrays.copyOf(arr, arr.length);
        
        while (true) {
            int[] prevArr = Arrays.copyOf(currentArr, currentArr.length);
            
            for (int i = 0; i < currentArr.length; i++) {
                currentArr[i] = transform(currentArr[i]);
            }
            if (isSameArray(currentArr, prevArr)) {
                return x;
            }
            x++;
        }
    }
}
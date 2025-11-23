import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> stk = new ArrayList<>();
        
        int i = 0;
    
        while (i < arr.length) {
            if (stk.isEmpty()) {
                stk.add(arr[i]);
                i++;
            } 
            else if (stk.get(stk.size() - 1) == arr[i]) {
                stk.remove(stk.size() - 1); 
                i++;
            } 
            else {
                stk.add(arr[i]);
                i++;
            }
        }
        
        if (stk.isEmpty()) {
            return new int[]{-1};
        } else {
            int[] result = new int[stk.size()];
            for (int k = 0; k < stk.size(); k++) {
                result[k] = stk.get(k);
            }
            return result;
        }
    }
}
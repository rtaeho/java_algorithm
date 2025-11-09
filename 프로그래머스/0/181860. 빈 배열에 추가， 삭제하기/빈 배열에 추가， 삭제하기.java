import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        List<Integer> X = new ArrayList<>();
    
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            boolean isTrue = flag[i];
            
            if (isTrue) {
                int count = a * 2;
                for (int j = 0; j < count; j++) {
                    X.add(a);
                }
            } else {
                int removeCount = a;
                for (int j = 0; j < removeCount; j++) {
                    X.remove(X.size() - 1);
                }
            }
        }
    
        return X.stream().mapToInt(Integer::intValue).toArray();
    }
}
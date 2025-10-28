import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        Set<Integer> deleteSet = new HashSet<>();
        for (int deleteNum : delete_list) {
            deleteSet.add(deleteNum);
        }
        
        ArrayList<Integer> resultList = new ArrayList<>();
        
        for (int num : arr) {
            if (!deleteSet.contains(num)) {
                resultList.add(num);
            }
        }
        return resultList.stream()
                         .mapToInt(i -> i)
                         .toArray();
    }
}
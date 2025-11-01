import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> X = new ArrayList<>();
        for (int a : arr) {
            for (int i = 0; i < a; i++) {
                X.add(a);
            }
        }
        int[] answer = new int[X.size()];
        for (int i = 0; i < X.size(); i++) {
            answer[i] = X.get(i);
        }
        
        return answer;
    }
}
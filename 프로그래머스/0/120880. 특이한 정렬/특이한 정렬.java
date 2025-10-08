import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        List<Integer> list = new ArrayList<>();
        for (int num : numlist) {
            list.add(num);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int distA = Math.abs(a - n);
                int distB = Math.abs(b - n);

                if (distA == distB) {
                    return b - a;
                }
                return distA - distB;
            }
        });
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = {};
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < num_list.length; i += n) {
            int[] part = new int[n];
            System.arraycopy(num_list, i, part, 0, n);
            list.add(part);
        }

        answer = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
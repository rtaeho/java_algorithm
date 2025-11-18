import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        
        int start = 0;
        int end = 0;
        int step = 1;
        
        switch (n) {
            case 1:
                start = 0;
                end = b;
                break;
            case 2:
                start = a;
                end = num_list.length - 1;
                break;
            case 3:
                start = a;
                end = b;
                break;
            case 4:
                start = a;
                end = b;
                step = c;
                break;
        }
        
        List<Integer> resultList = new ArrayList<>();
        
        for (int i = start; i <= end; i += step) {
            resultList.add(num_list[i]);
        }
        
        int[] answer = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }
        
        return answer;
    }
}
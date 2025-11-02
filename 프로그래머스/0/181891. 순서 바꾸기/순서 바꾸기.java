import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int length = num_list.length;
        
        int[] secondPart = Arrays.copyOfRange(num_list, n, length);
        int[] firstPart = Arrays.copyOfRange(num_list, 0, n);
        
        int[] answer = new int[length];
        
        System.arraycopy(secondPart, 0, answer, 0, secondPart.length);
        System.arraycopy(firstPart, 0, answer, secondPart.length, firstPart.length);
        
        
        return answer;
    }
}
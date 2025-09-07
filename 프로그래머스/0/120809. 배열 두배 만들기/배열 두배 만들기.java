import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        answer = Arrays.stream(numbers)
                     .map(x -> x * 2)
                     .toArray();
        return answer;
    }
}
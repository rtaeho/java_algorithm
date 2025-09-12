import java.util.stream.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        answer = IntStream.rangeClosed(1, n)
                        .filter(i -> i % 2 != 0)
                        .toArray();
        return answer;
    }
}
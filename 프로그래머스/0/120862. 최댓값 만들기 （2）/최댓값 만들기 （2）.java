import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        int n = numbers.length;
        int v1 = numbers[0] * numbers[1];
        int v2 = numbers[n-1] * numbers[n-2];
        answer = Math.max(v1, v2);
        return answer;
    }
}
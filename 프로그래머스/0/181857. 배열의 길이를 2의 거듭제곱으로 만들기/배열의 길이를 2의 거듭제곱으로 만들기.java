class Solution {
    public int[] solution(int[] arr) {
        int L = arr.length;
        int T = 1;

        while (T < L) {
            T *= 2; 
        }
        int[] answer = new int[T];

        for (int i = 0; i < L; i++) {
            answer[i] = arr[i];
        }

        return answer;
    }
}
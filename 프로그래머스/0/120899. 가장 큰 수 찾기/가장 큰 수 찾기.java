class Solution {
    public int[] solution(int[] array) {
        int[] answer = {};
        int max = array[0];
        int idx = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
                idx = i;
            }
        }
        answer = new int[]{max, idx};
        return answer;
    }
}
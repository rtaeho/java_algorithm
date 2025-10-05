class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = {};
        int n = numbers.length;
        
        if (direction.equals("right")){
            int last = numbers[n-1];
            for(int i = n - 1; i > 0; i--){
                numbers[i] = numbers[i-1];
            }
            numbers[0] = last;
        }
        else{
            int first = numbers[0];
            for(int i = 0; i < n - 1; i++){
                numbers[i] = numbers[i+1];
            }
            numbers[n-1] = first;
        }
        answer = numbers;
        return answer;
    }
}
class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int multiply = 1;
        int sum_square = 0;
        for(int i = 0; i < num_list.length; i++){
            multiply *= num_list[i];
            sum_square += num_list[i];
        }
        answer = multiply < Math.pow((double)sum_square, 2.0) ? 1 : 0;
        return answer;
    }
}
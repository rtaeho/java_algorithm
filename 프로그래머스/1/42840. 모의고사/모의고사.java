class Solution {
    public int[] solution(int[] answers) {
        int answer1 = 0;
        int answer2 = 0;
        int answer3 = 0;
        
        int[] pick1 = new int[]{1, 2, 3, 4, 5};
        int[] pick2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] pick3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for(int i = 0; i < answers.length; i++){
            if(pick1[i % pick1.length] == answers[i]){
                answer1++;
            }
            if(pick2[i % pick2.length] == answers[i]){
                answer2++;
            }
            if(pick3[i % pick3.length] == answers[i]){
                answer3++;
            }
        }
        
        if(answer1 > answer2 && answer1 > answer3){
            return new int[]{1};
        }
        else if(answer2 > answer1 && answer2 > answer3){
            return new int[]{2};
        }
        else if(answer3 > answer1 && answer3 > answer2){
            return new int[]{3};
        }
        else if(answer1 == answer2 && answer1 > answer3){
            return new int[]{1, 2};
        }
        else if(answer2 == answer3 && answer2 > answer1){
            return new int[]{2, 3};
        }
        else if(answer1 == answer3 && answer3 > answer2){
            return new int[]{1, 3};
        }
        else{
            return new int[]{1, 2, 3};
        }
    }
}
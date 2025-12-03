class Solution {
    public int[][] solution(int[][] arr) {
        int row = arr[0].length;
        int col = arr.length;
        int n = Math.max(row, col);
        int[][] answer = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i < col && j < row){
                    answer[i][j] = arr[i][j];
                }
                else{
                    answer[i][j] = 0;
                }
            }
        }
        return answer;
    }
}
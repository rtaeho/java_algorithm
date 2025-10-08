class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        boolean[][] danger = new boolean[n][n];
        // 상 우상 우 우하 하 좌하 좌 좌상
        int dr[] = new int[]{-1,-1,0,1,1,1,0,-1};
        int dc[] = new int[]{0,1,1,1,0,-1,-1,-1};
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 1){
                    danger[i][j] = true;

                    for(int k = 0; k < 8; k++){
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        
                        if(nr >= 0 && nr < n && nc >= 0 && nc < n){
                            danger[nr][nc] = true;
                        }
                    }
                    
                    
                }
            }
        }
        int count = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!danger[i][j]) count++;
            }
        }
        
        return count;
    }
}
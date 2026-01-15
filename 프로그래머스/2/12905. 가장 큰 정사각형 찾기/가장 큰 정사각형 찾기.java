class Solution
{
    public int solution(int [][]board)
    {
        int max = 0; //answer
        int row = board.length;
        int col = board[0].length;
        int[][] dp = new int[row][col];

        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(board[i][j] == 1){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }
                    else{
                        int next = Math.min(
                            dp[i-1][j-1], 
                            Math.min(dp[i-1][j], dp[i][j-1])
                        ) + 1;
                        dp[i][j] = next;
                    } 
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
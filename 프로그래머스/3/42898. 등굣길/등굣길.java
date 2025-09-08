class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];
        for(int[] puddle : puddles) {
            map[puddle[1] - 1][puddle[0] - 1] = 1; // 물이 잠김
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0) {
                    if ((j != 0 && dp[i][j-1] == 0) || map[i][j] == 1) dp[i][j] = 0;
                    else dp[i][j] = 1;
                } else if(j == 0) {
                    if ((i != 0 && dp[i-1][j] == 0) || map[i][j] == 1) dp[i][j] = 0;
                    else dp[i][j] = 1;
                } else if(map[i][j] != 1) {
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000007;
                }
            }
        }
        
        return dp[n-1][m-1];
    }
}
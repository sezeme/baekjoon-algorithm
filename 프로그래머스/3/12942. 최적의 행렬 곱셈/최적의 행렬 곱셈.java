import java.util.*;

class Solution {
    public int solution(int[][] matrix_sizes) {
        int length = matrix_sizes.length;
        int[][] dp = new int[length][length];
        
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length-i; j++){
                int a = j;
                int b = j+i;
                if(a == b) dp[a][b] = 0;
                else{
                    for(int k = a; k < b; k++){
                        dp[a][b] = min(dp[a][b], dp[a][k] + dp[k+1][b] + matrix_sizes[a][0] * matrix_sizes[k][1] * matrix_sizes[b][1]);
                    }
                }
            }
        }
        
        return dp[0][length-1];
    }
    
    public int min(int a, int b){
        return a < b ? a : b;
    }
}
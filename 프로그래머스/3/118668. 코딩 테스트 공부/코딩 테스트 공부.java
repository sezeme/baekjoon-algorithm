class Solution {
    public int solution(int alp, int cop, int[][] problems) {
           
        int goal_a = 0;
        int goal_c = 0;
        //목표치를 구하는 for문
        for(int i=0; i<problems.length; i++){
            goal_a = Math.max(problems[i][0], goal_a);
            goal_c = Math.max(problems[i][1], goal_c);
        }
        
        //초기값이 목표치보다 큰 경우
        if(goal_a <= alp && goal_c <= cop){
            return 0;
        }
        
        //하나만 큰 경우 목표치로 보정. dp[goal_a][goal_c]를 구해야하기 때문에
        if(alp >= goal_a){
            alp = goal_a;
        }
        if(cop >= goal_c){
            cop = goal_c;
        }
        
        int[][] dp = new int[goal_a+2][goal_c+2];
        
        //dp 초기화
        for(int i=alp; i<=goal_a; i++){
            for(int j=cop; j<=goal_c; j++){
                dp[i][j]=Integer.MAX_VALUE;
          }
        }
        
        dp[alp][cop]=0;
        
        for(int i=alp; i<=goal_a; i++){
            for(int j=cop; j<=goal_c; j++){  
                
                //1.알고리즘 공부로 알고력을 1 증가시키는 경우 
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                
                //2.코딩 공부로 코딩력을 1 증가시키는 경우
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                
                //3. 문제를 풀어서 알고력과 코딩력을 증가시키는 경우
                for(int[] p : problems){
                    int req_a = p[0];
                    int req_c = p[1];
                    int rwd_a = p[2];
                    int rwd_c = p[3];
                    int cost = p[4];
                    
                    if(req_a > i || req_c > j) continue;
                    
                    //목표치를 초과하는 경우 보정
                    //1) 둘 다 넘는 경우
                    if(i+rwd_a > goal_a && j+rwd_c > goal_c){
                        dp[goal_a][goal_c] = Math.min(dp[goal_a][goal_c], dp[i][j]+cost); 
                    }
                    else if(i+rwd_a > goal_a){
                        dp[goal_a][j+rwd_c] = Math.min(dp[goal_a][j+rwd_c], dp[i][j]+cost); 
                    }
                    else if(j+rwd_c > goal_c){
                        dp[i+rwd_a][goal_c] = Math.min(dp[i+rwd_a][goal_c], dp[i][j]+cost); 
                    }
                    else{
                        dp[i+rwd_a][j+rwd_c] = Math.min(dp[i+rwd_a][j+rwd_c], dp[i][j]+cost); 
                    }
     
                }
            }
        }
        return dp[goal_a][goal_c];
    }
    
 
}
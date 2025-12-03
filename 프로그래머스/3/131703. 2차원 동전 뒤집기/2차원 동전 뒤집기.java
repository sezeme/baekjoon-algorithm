class Solution {
    int n, m;
    int[][] board;
    int[][] t;
    int ans = Integer.MAX_VALUE;
    public int solution(int[][] beginning, int[][] target) {
        int answer = 0;
        //초기 상태에서 목표 상태로 만들기 위해 필요한 동전 뒤집기 횟수의 최솟값을 return 
        n = beginning.length;
        m = beginning[0].length;
        
        board = new int[n][m];
        for(int i=0; i<n; i++){
            board[i] = beginning[i].clone();
        }
        t = target;
        
        dfs(0, 0);
        
        if(ans==Integer.MAX_VALUE){
            answer = -1;
        } else answer = ans;
        
        return answer;
    }
    
    public void flip_row(int r){
        //0->1, 1->0
        for(int i=0; i<m; i++){
            board[r][i] = (board[r][i]+1)%2;
        }
    }
    
    public int compare_col(int c){
        int check = 0;
        for(int i=0; i<n; i++){
            if(t[i][c]==board[i][c]){
                check++; 
            } 
        }
        
        if(check==n) return 0; //전부 일치
        else if(check==0) return 1; //전부 불일치
        else return -1;
    }
    
    public void dfs(int r, int cnt){
        //모든 행의 경우의 수를 확인했다면
        if(r==n){
            boolean flag = true;
            for(int i=0; i<m; i++){
                int result = compare_col(i);
                if(result==-1){
                    flag = false;
                    break;
                }
                cnt += result; //전부 반대일 경우 +1
            }
            
            if(flag){
                ans = Math.min(ans, cnt);   
            }
            return;
        }
        
        flip_row(r); //행 뒤집기
        dfs(r+1, cnt+1); //행을 뒤집는 경우
        flip_row(r); //다시 원상태로
        
        dfs(r+1, cnt); //행을 뒤집지 않는 경우
    }
}
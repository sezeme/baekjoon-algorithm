class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] acc = new int[n + 1][m + 1];
        int answer = 0;
        
        for(int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];
            
            int val = type == 1 ? -degree : degree;
            
            acc[r1][c1] += val; // 직사각형 영역 전체에 영향
            acc[r1][c2+1] -= val; // 오른쪽 영향 x
            acc[r2+1][c1] -= val; // 왼쪽 영향 x
            acc[r2+1][c2+1] += val; // 오른쪽 아래 모서리에서 두 번 빠진걸 한 번복원 
        }
        
        for(int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                acc[i][j] += acc[i][j-1];
            }
        }
        
        for(int j = 0; j <= m; j++) {
            for(int i = 1; i <= n; i++) {
                acc[i][j] += acc[i-1][j];
            }
        }
        
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] += acc[i][j];
                if(board[i][j] > 0) answer++;
            }
        }        
        
        return answer;
    }
}
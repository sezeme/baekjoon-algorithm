import java.io.*;
import java.util.*;

class Solution {
    static ArrayDeque<int[]> q;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int[] sum;
    static boolean[][] visited;
    public int solution(int[][] land) {
        int result = 0;
        
        N = land.length;
        M = land[0].length;
        sum = new int[M];
        
        // 0이면 빈 땅, 1이면 석유
        visited = new boolean[N][M];
        
        for(int i = 0; i < M; i++) {
           BFS(i, visited, land);
        }
        
        Arrays.sort(sum);
        
        return sum[sum.length-1];
        
    }
    
    static void BFS(int col, boolean[][] visited, int[][] land) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        
        for(int i = 0; i < N; i++) {
            int maxCol = col;
            int cnt = 0;
            
            if(land[i][col] == 0) continue;
            if(visited[i][col]) continue;
            
            
            if(land[i][col] == 1 && !visited[i][col]) {
                q.offer(new int[]{i, col});
                visited[i][col] = true;
                
                while(!q.isEmpty()) {
                    
                    int[] p = q.poll();
                    cnt++;
                    
                    for(int d = 0; d < 4; d++) {
                        int nx = p[0] + dx[d];
                        int ny = p[1] + dy[d];
                        
                        if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                        
                        if(visited[nx][ny] || land[nx][ny] == 0) continue;
                        
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                        
                        if(maxCol < ny) maxCol = ny;
                    }
                }
            }
            
            if(cnt != 0) {
                for(int j = col; j <= maxCol; j++) {
                    sum[j] += cnt;
                }    
            }            
        }
    }
}
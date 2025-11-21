import java.util.*;
import java.io.*;

class Solution {
    static int[][] st, et;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean result = false;
    static int[][] mazes;
    static int res, N, M;
    public int solution(int[][] maze) {
        
        N = maze.length;
        M = maze[0].length;
        res = 20;
        mazes = new int[N][M];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                mazes[i][j] = maze[i][j];
            }
        }
        
        st = new int[2][2];
        et = new int[2][2];
        
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                
                if(maze[i][j] == 1) {
                    st[0][0] = i;
                    st[0][1] = j;
                } else if(maze[i][j] == 2) {
                    st[1][0] = i;
                    st[1][1] = j;
                } else if(maze[i][j] == 3) {
                    et[0][0] = i;
                    et[0][1] = j;
                } else if(maze[i][j] == 4) {
                    et[1][0] = i;
                    et[1][1] = j;
                }
            }
        }
        boolean[][][] visited = new boolean[N][M][2];
        
        visited[st[0][0]][st[0][1]][0] = true;
        visited[st[1][0]][st[1][1]][1] = true;
        
        DFS(st[0][0], st[0][1], st[1][0], st[1][1], 0, visited, false, false);
        
        if(res == 20 || !result) res = 0;
        
        return res;
        
        
        
        

    }
    
    static void DFS(int rx, int ry, int bx, int by, int cnt, boolean[][][] visited, boolean flag, boolean flag2) {
        
        if(cnt > res) return;
        
        // 빨간 수레 도착
        if(!flag && rx == et[0][0] && ry == et[0][1]) {
            flag = true;
        }
        // 파란 수레 도착
        if(!flag2 && bx == et[1][0] && by == et[1][1]) {
            flag2 = true;
        }

        if(flag && flag2) {
            // 모든 수레 탈출
            if(res > cnt) res = cnt;
            result = true;
            return;
        }

        for(int d = 0; d < 4; d++) {
            
            int nx = rx + dx[d];
            int ny = ry + dy[d];
            
            if(!flag) {
                if(!isValid(nx, ny)) continue;
                if(mazes[nx][ny] == 5 || visited[nx][ny][0]) continue;
            } else {
                nx = rx;
                ny = ry;
            }
            
            if(flag2) {
                if(nx == bx && ny == by) continue;
            }

            // TODO: 이미 도착한 경우, 움직이지 않으므로 조건 추가
            for(int d2 = 0; d2 < 4; d2++) {
            
                int nx2 = bx + dx[d2];
                int ny2 = by + dy[d2];
                
                if(!flag2) {
                    if(!isValid(nx2, ny2)) continue;
                    if(mazes[nx2][ny2] == 5 || visited[nx2][ny2][1]) continue;
                } else {
                    nx2 = bx;
                    ny2 = by;
                }
                
                if(nx == nx2 && ny == ny2) continue;
                if(nx2 == rx && ny2 == ry && nx == bx && ny == by) continue;

                
                visited[nx][ny][0] = true;
                visited[nx2][ny2][1] = true;
                DFS(nx, ny, nx2, ny2, cnt + 1, visited, flag, flag2);
                visited[nx][ny][0] = false;
                visited[nx2][ny2][1] = false;

            }
        }
    }
    
    static boolean isValid(int x, int y) {   
        if(x < 0 || x >= N || y < 0 || y >= M) return false;
        
        return true;
    }
    
}
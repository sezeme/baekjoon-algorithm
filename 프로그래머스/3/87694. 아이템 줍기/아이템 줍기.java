import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map = new int[102][102];
    static boolean[][] visited = new boolean[102][102];
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 좌표 2배 확장, 테두리 표시
        for(int[] r : rectangle) {
            int x1 = r[0] *2;
            int y1 = r[1] *2;
            int x2 = r[2] *2;
            int y2 = r[3] *2;
            
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    map[i][j] = 1;
                }
            }
        }
        
        // 내부 비워서 테두리만 남기기
        for(int[] r : rectangle) {
            int x1 = r[0] *2;
            int y1 = r[1] *2;
            int x2 = r[2] *2;
            int y2 = r[3] *2;
            
            for (int i = x1 + 1; i < x2; i++) {
                for (int j = y1 + 1; j < y2; j++) {
                    map[i][j] = 0;
                }
            }
        }
        
        // bfs 탐색 준비
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterX * 2, characterY * 2, 0});
        visited[characterX * 2][characterY * 2] = true;
        
        // bfs 탐색
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int dist = now[2];
            
            // 도착점 도달 시 반환
            if (x == itemX * 2 && y == itemY * 2) {
                return dist / 2; // 2배 스케일 보정
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0|| ny < 0 || nx >= 102 || ny >= 102) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] != 1) continue;
                
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, dist + 1});
            }
        }
        
        return 0;
    }
}
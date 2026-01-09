import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Integer> answer = new ArrayList<>();
    
    public List<Integer> solution(String[][] places) {
        for (String[] place : places) {
            String[] p = place;
            boolean isfalse = false;
            outer:for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (p[i].charAt(j) == 'P') {
                        if(!bfs(i, j, p)) {
                            System.out.println(i + " " + j);
                            isfalse = true;
                            break outer;
                        } 
                    }
                }
            }
            if (isfalse) {
                answer.add(0);
            } else {
                answer.add(1);
            }
        }
        return answer;
    }
    
    static boolean bfs(int i, int j, String[] p) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        boolean[][] visited = new boolean[5][5];
        visited[i][j] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int n = 0; n < 4; n++) {
                int nx = cur[0] + dx[n];
                int ny = cur[1] + dy[n];
                
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                
                if (!visited[nx][ny]) {
                    int d = Math.abs(nx - i) + Math.abs(ny - j);
                    
                    if (d <= 2 && p[nx].charAt(ny) == 'P') {
                        return false;
                    } else if(p[nx].charAt(ny) == 'O' && d <= 2) {
                        System.out.println(nx + " " + ny);
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        System.out.println(" ");
        return true;
    }
}
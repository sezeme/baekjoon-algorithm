import java.util.*;

class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    boolean[][] visited;
    // 조건 1. 벽
    // 조건 2. 최단거리 bfs - while, queue
    class Node {
        int depth, i, j;
        Node(int d, int i, int j) {
            this.depth = d;
            this.i = i;
            this.j = j;
        }
    }
    public int solution(int[][] maps) {
        int answer = 10001;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<Node> q = new ArrayDeque<>();
        visited = new boolean[maps.length][maps[0].length];
        q.add(new Node(1,0,0));
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            if(node.i == (maps.length -1) && node.j == (maps[0].length - 1)) {
                return node.depth;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = node.i + dx[i];
                int ny = node.j + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length
                   || visited[nx][ny] || maps[nx][ny] == 0) continue;
                
                visited[nx][ny] = true;
                q.add(new Node(node.depth + 1, nx, ny));
            }
        }

        return -1;
    }
}
import java.util.*;
class Solution {
    int n,m;
    int[] dr = {-1,1,0,0}, dc={0,0,-1,1};
    boolean[][] vis;
    List<Integer> ans = new ArrayList<>();
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        vis = new boolean[n][m];
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(vis[i][j] || maps[i].charAt(j) == 'X') continue;
                bfs(i,j,maps);
            }
        }
        
        if(ans.isEmpty()) return new int[]{-1};
        return ans.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
    void bfs(int r,int c, String[] maps){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        vis[r][c] = true;
        
        int sum = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            sum += maps[cur[0]].charAt(cur[1])-'0';
            for(int i = 0 ; i <4 ; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                
                if(OOB(nr,nc) || maps[nr].charAt(nc) == 'X' || vis[nr][nc]) continue;
                q.offer(new int[]{nr,nc});
                vis[nr][nc] = true;
            }
        }
        
        ans.add(sum);
    }
    boolean OOB(int r,int c){
        return r < 0 || r >= n || c < 0 || c >= m;
    }
}
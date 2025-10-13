import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static int maxSheep = 0;
    static int[] info;
    
    public int solution(int[] info, int[][] edges) {
        Solution.info = info;
        int n = info.length;
        
        graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }
        
        dfs(0,0,0, new ArrayList<>(List.of(0)));
        
        return maxSheep;
    }
    
    static void dfs(int node, int sheep, int wolf, List<Integer> possible) {
        // 현재 노드가 양인지 늑대인지
        if (info[node] == 0) sheep++;
        else wolf++;
        
        // 늑대가 양 이상이면 종료
        if(wolf >= sheep) return;
        
        // 최대 양 업데이트
        maxSheep = Math.max(maxSheep, sheep);
        
        // 방문 가능한 노드 목록 복사
        List<Integer> nextPossible = new ArrayList<>(possible);
        nextPossible.remove(Integer.valueOf(node)); // todo Integer.valueOf 함수는 왜 쓰는건지?
        
        // 현재 노드의 자식들을 추가
        for (int child : graph[node]) {
            nextPossible.add(child);
        }
        
        // 가능한 모든 다음 노드로 이동
        for (int next : nextPossible) {
            dfs(next, sheep, wolf, nextPossible);
        }
    }
}
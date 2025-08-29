import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 인접리스트 구현
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edge) {
            int a = e[0];
            int b = e[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1); // -1: 방문 안함
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        distance[1] = 0;
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int neighbor : graph.get(current)) {
                if(distance[neighbor] == -1) {
                    distance[neighbor] = distance[current] + 1;
                    queue.offer(neighbor);
                }
            }
        }
        
        int maxDistance = 0;
        for(int d : distance) {
            if(d > maxDistance) maxDistance = d;
        }
        
        int count = 0;
        for(int d : distance) {
            if(d == maxDistance) count++;
        }
        
        return count;
    }
}
import java.util.*;

class Solution {
    int[] connected = new int[101];
    public int solution(int n, int[][] costs) {
        int totalCost = 0;
        
        Arrays.sort(costs, (c1, c2) -> c1[2] - c2[2]);
        
        for(int i = 0; i < 101; i++) {
            connected[i] = i;
        }
        
        for(int[] edge : costs) {
            int a = edge[0], b = edge[1], cost = edge[2];
            if(find(a) == find(b)) continue;
            
            union(a, b);
            totalCost += cost;
            
            System.out.println(a + ", " + b + ", " + totalCost);
        }
        return totalCost;
    }
    
    int find(int i) {
        if (connected[i] == i) return i;
        return connected[i] = find(connected[i]);
    }
    
    void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if(rootI != rootJ) {
            connected[rootJ] = rootI; // j의 루트를 i 루트에 붙임
            System.out.println(i + "," + j + " 연결됨 → root: " + rootI);
        }
    }
}
import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 그래프 - 선물 주고받은 개수
        // 배열 - 선물 지수
        int n = friends.length;
        HashMap<String, Integer> index = new HashMap<>();
        for(int i = 0; i < friends.length; i++) {
            index.put(friends[i], i);
        }
        int[][] graph = new int[n][n];
        int[] giftFactor = new int[n];
        
        for(int i = 0; i < gifts.length; i++) {
            String[] gift = gifts[i].split(" ");
            int giver = index.get(gift[0]);
            int receiver = index.get(gift[1]);
            
            graph[giver][receiver]++;
            giftFactor[giver]++;
            giftFactor[receiver]--;
        }
        
        HashMap<Integer, Integer> receiving = new HashMap<>();
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(graph[i][j] > graph[j][i]) {
                    receiving.put(i, receiving.getOrDefault(i, 0) + 1);
                } else if(graph[i][j] < graph[j][i]) {
                    receiving.put(j, receiving.getOrDefault(j, 0) + 1);
                } else {
                    if(giftFactor[i] > giftFactor[j]) {
                        receiving.put(i, receiving.getOrDefault(i, 0) + 1);
                    } else if(giftFactor[i] < giftFactor[j]) {
                        receiving.put(j, receiving.getOrDefault(j, 0) + 1);
                    }
                }
            }
        }
        
        int max = 0;
        for(Map.Entry<Integer, Integer> entry : receiving.entrySet()) {
            if(max < entry.getValue()) max = entry.getValue();
        }
        
        return max;
    }
}
import java.util.*;

class Solution {
    boolean[] isA, best;
    int n, maxWin = 0, winCount;
    int[][] dice;
    
    public int[] solution(int[][] dice) {
        // A가 이길 확률
        // 6*5*4*3*2*1 x 6*5*4*3*2*1
        n = dice.length;
        isA = new boolean[n];
        this.dice = dice;
        
        dfs(0, 0);
        
        int[] answer = new int[n/2];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            if(best[i]) {
                answer[idx++] = i+1;
            }
        }
        
        return answer;
    }
    
    void dfs(int depth, int index) {
        if(depth < n/2 && index == n) return;
        if(depth == n/2) {
            List<int[]> aDices = new ArrayList<>();
            List<int[]> bDices = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                if (isA[i]) aDices.add(dice[i]);
                else bDices.add(dice[i]);
            }
            
            List<Integer> aSums = getSums(aDices);
            List<Integer> bSums = getSums(bDices);
            
            Collections.sort(bSums);
            int win = 0;
            
            for (int a : aSums) {
                int idx2 = lowerBound(bSums, a);
                win += idx2;
            }
            
            if(maxWin < win) {
                maxWin = win;
                best = isA.clone();
            }
            return;
        }
        
        isA[index] = true;
        dfs(depth + 1, index + 1);
        isA[index] = false;
        dfs(depth, index + 1);
    }
    
    List<Integer> getSums(List<int[]> dices) {
        List<Integer> sums = new ArrayList<>();
        sums.add(0);
        for (int[] die : dices) {
            List<Integer> next = new ArrayList<>();
            for (int s : sums) {
                for (int v : die) {
                    next.add(s + v);
                }
            }
            sums = next;
        }
        return sums;
    }
    
    int lowerBound(List<Integer> arr, int target) {
        int l = 0, r = arr.size();
        while(l < r) {
            int m = (l + r) / 2;
            if (arr.get(m) < target) l = m + 1;
            else r = m;
        }
        return l;
    }
}
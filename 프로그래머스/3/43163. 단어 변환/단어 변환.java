import java.util.*;

class Solution {
    
    class Node{
        String word;
        int depth;
        Node(String w, int d) {
            this.word = w;
            this.depth = d;
        }
    }
    boolean[] visited;
    int count = Integer.MAX_VALUE;
    String targetValue;
    String[] wordList;
    public int solution(String begin, String target, String[] words) {
        // visited 체크, 이전 단어랑 하나만 다르다면 bfs 들어감, target과 같다면 출력
        // 최소 횟수이니까 bfs 로 하려고 했지만 visited 배열을 어떻게 처리할지 애매해서 그냥 모든 dfs 를 다 돌아보고 최소 횟수 구하는걸로 일단 풀이
        visited = new boolean[words.length];
        targetValue = target;
        wordList = words;
        
        dfs(begin, 0);       
        
        return count == Integer.MAX_VALUE ? 0 : count;
    }
    
    void dfs(String word, int depth) {
        if(word.equals(targetValue)) {
            count = Math.min(count, depth);
            return;
        }
        
        for(int i = 0; i < wordList.length; i++) {
            if(visited[i]) continue;
            String compare = wordList[i];
            int cnt = 0;
            for(int j = 0; j < compare.length(); j++) {
                if(compare.charAt(j) != word.charAt(j)) cnt++;
            }
            
            if(cnt == 1) {
                visited[i] = true;
                dfs(compare, depth+1);
                visited[i] = false;
            }
        }
    }
}
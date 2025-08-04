import java.util.*;

class Solution {
    String str;
    static int[] eratostenes;
    static Set<Integer> set;
    static boolean[] visited;
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        // 에라토스테네스의 체: 1 - 소수, -1 - 소수가 아님, 0 - 검사안함
        eratostenes = new int[9999999];
        for(int i = 2; i <9999999; i++){
            if(eratostenes[i] == 0) {
                eratostenes[i] = 1;
                for(int j = i*2; j < 9999999; j += i) {
                    eratostenes[j] = -1;
                }
            }
        }
        
        str = numbers;
        
        // 완전탐색
        set = new HashSet<>();
        dfs("");
        
        return set.size();
    }
    
    void dfs(String number) {
        if(number.length() >= 8) return;
        if(!number.equals("") && eratostenes[Integer.parseInt(number)] == 1) {
            set.add(Integer.parseInt(number));
        }
        
        for(int i = 0; i < str.length(); i++){
            // 중복 x
            if(visited[i]) continue;
            visited[i] = true;
            dfs(number + str.charAt(i));
            visited[i] = false;
        }
    }
}
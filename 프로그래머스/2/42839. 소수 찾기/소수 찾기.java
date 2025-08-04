import java.util.*;

class Solution {
    String str;
    static boolean[] eratostenes, visited;
    static Set<Integer> set;
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        // 에라토스테네스의 체: false - 소수, true - 소수가 아님
        eratostenes = new boolean[10000000];
        eratostenes[0] = eratostenes[1] = true;
        for(int i = 2; i*i <10000000; i++){
            for(int j= i*i; j<10000000; j+=i)
              eratostenes[j] = true;
        }

        str = numbers;
        set = new HashSet<>();
        dfs("");

        return set.size();
    }

    void dfs(String number) {
        if(number.length() >= 8) return;
        if(!number.equals("") && !eratostenes[Integer.parseInt(number)]) {
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
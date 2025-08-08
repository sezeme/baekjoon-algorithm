import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // N을 i번 사용해서 나온 수 => dp[i] 에 저장
        List<Set<Integer>> dp = new ArrayList<>();
        
        for(int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        
        for(int i = 1; i <= 8; i++) {
            // 5, 55, 555 ....
            int repeatN = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(repeatN);
            
            // 사칙연산으로 찾기
            for (int j = 1; j < i; j++) {
                for (int a: dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        // +
                        dp.get(i).add(a + b);
                        // -
                        dp.get(i).add(a - b);
                        dp.get(i).add(b - a);
                        // *
                        dp.get(i).add(a * b);
                        // /
                        if (b != 0) dp.get(i).add(a / b);
                        if (a != 0) dp.get(i).add(b / a);
                    }
                }
            }
            
            if (dp.get(i).contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}
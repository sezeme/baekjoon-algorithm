import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> ary = new ArrayList<>();
        
        long total = 1;
        for(int i=1;i<=n;i++)
        {
            ary.add(i);
            total *= i;
        }
        k--;
        
        int idx = 0;
        while(idx < n)
        {
            total /= n - idx;
            answer[idx++] = ary.remove((int) (k/total));
            k %= total;
            
        }
        return answer;
    }
}
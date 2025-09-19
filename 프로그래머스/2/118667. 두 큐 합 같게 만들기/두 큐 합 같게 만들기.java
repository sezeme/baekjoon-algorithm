import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        long sum1 = 0, sum2 = 0; 
        
        for (int x : queue1) {
            q1.add(x);
            sum1 += x;
        }
        for (int x : queue2) {
            q2.add(x);
            sum2 += x;
        }
        
        long total = sum1 + sum2;
        if(total % 2 != 0) return -1;
        long target = total / 2;
        
        int maxOps = (queue1.length + queue2.length) * 2;

        for(int i = 0; i <= maxOps ; i++) {
            if(sum1 == target) return i;
            
            if(sum1 > target) {
                if (q1.isEmpty()) break;
                int num = q1.poll();
                q2.add(num);
                sum1 -= num; sum2 += num;
            } else {
                if (q2.isEmpty()) break;
                int num = q2.poll();
                q1.add(num);
                sum2 -= num; sum1 += num;
            }
        }
        
        return -1;
    }
}
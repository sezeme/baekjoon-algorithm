import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
            q.offer(scoville[i]);
        }
        
        int count = 0;
        while(true) {
            int num1 = q.poll();
            if(num1 >= K) {
                return count;
            }
            if(q.isEmpty()) {
                return -1;
            }
            int num2 = q.poll();
            q.offer(num1 + num2 * 2);
            count++;
        }
    }
}
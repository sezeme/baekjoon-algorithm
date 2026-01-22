import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < works.length; i++) {
            q.offer(works[i]);
        }
        
        while(n > 0) {
            int work = q.poll();
            if(work == 0) break;
            work -= 1; 
            q.offer(work);
            n -= 1; 
        }
        
        long answer = 0;
        for(int work : q) {
            answer += work * work;
        }
        return answer;
    }
}

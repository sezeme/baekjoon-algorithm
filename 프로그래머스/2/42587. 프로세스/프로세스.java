import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // location = index
        // {우선순위, location}
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            q.add(new int[]{priorities[i], i});
        }
        
        int count = 0;
        while(true) {
            int[] process = q.poll();
            if(process[0] != pq.peek()) {
                q.add(process);
            } else {
                count++;
                pq.poll();
                if(process[1] == location) {
                    return count;
                }
            }
        }
    }
}
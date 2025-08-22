import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        // [요청시간, 실행시간, 원본 인덱스]
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int time = 0;
        int sum = 0;
        int idx = 0;
        int n = jobs.length;
        
        while(idx < n || !pq.isEmpty()) {
            while(idx < n && jobs[idx][0] <= time) {
                pq.offer(jobs[idx]);
                idx++;
            }
            
            if(pq.isEmpty()) {
                time = jobs[idx][0];
            } else {
                int[] job = pq.poll();
                time += job[1];
                sum += time - job[0];
            }
        }

        return sum / jobs.length;
    }
}
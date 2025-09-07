import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        Arrays.sort(times);
        
        long high = (long) times[times.length - 1] * n;
        long low = 1;
        long mid;
        long answer = 0;
        while(low <= high) {
            mid = (high + low) / 2;
            
            if(canProcessAll(mid, times, n)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return answer;
    }
    
    boolean canProcessAll(long mid, int[] times, int n) {
        long sum = 0;
        for(int time : times) {
            sum += mid / time;
            if (sum >= n) return true;
        }
        return sum >= n;
    }
}
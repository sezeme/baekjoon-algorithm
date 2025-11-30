import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long double_d = (long)Math.pow(d,2);
        for(int i = 0; i <= d; i += k) {
            long double_i = (long)Math.pow(i,2);
            long sqrt = (long)Math.sqrt(double_d - double_i);
            answer += sqrt/k +1;
        }

        return answer;
    }
}

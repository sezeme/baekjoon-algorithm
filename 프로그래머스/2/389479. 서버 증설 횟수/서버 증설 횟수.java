class Solution {
    public int solution(int[] players, int m, int k) {
        int[] server=new int[24];
        int cnt=0;
        for(int i=0;i<players.length;i++) {
            if(i>0) server[i]+=server[i-1];
            // need more?
            int need=players[i]/m-server[i];
            if(need>0) {
                cnt+=need;
                server[i]+=need;
                // connect done
                if(server.length>i+k) server[i+k]-=need;
            }
        }
        return cnt;
    }
}
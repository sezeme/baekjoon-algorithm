import java.util.*;

class Solution {
    public int solution(int n, int[][] data) {
        int answer = 0;
        
        Arrays.sort(data, (o1, o2) -> {
             if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        
        for(int i=0; i<n; i++){
            int r = data[i][0];
            int c = data[i][1];
            
            for(int j=i+1; j<n; j++){
                int rr = data[j][0];
                int cc = data[j][1];
                
                //넓이가 0이면 패스
                if(r==rr || c==cc) continue;
                
                //내부에 다른 쐐기가 있는지
                boolean flag = true;
                for(int k=i+1; k<j; k++){
                    int kr = data[k][0];
                    int kc = data[k][1];
                    
                    if((r < kr && kr < rr) && (Math.min(c, cc) < kc && kc < Math.max(c, cc))){
                        flag = false;
                        break;
                    }
    
                }
                
                if(flag) answer++;
            }
        }
    
        return answer;
        
    }
    
}
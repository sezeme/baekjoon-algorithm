import java.util.*;
class Solution {
    public int solution(int n, int[] cores) {
       int answer = 0;
 
        
        int min = 0; 
        int max = 10000*n; 
 
        int time = 0;
        int m = 0;
 
        while (true) {  
            int mid = (min+max)/2;
 
            int count = calculate(mid, cores);
 
            if(min>max){
 
                break;
            }
            
            if (count >= n) { 
                max = mid-1;   
                time = mid;     
                m = count; 
            }else{
                min = mid+1;
            }
        }
 
        m-=n;
        for(int i = cores.length-1; i>=0; i--){
            if (time % cores[i] == 0) { 
                if (m == 0) {
                    answer = i+1;
                    break;
                }
                m--;
            }
        }
 
        return answer;
    }
    
      static int calculate(int time, int[] cores){
 
        if (time == 0) {
            return cores.length;
        }
 
        int count = cores.length; 
 
        for(int i = 0; i<cores.length; i++){ 
            count += (time/cores[i]);
        }
 
        return count;
    }
}

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Integer> s = new Stack<>();
        
        s.push(numbers[numbers.length-1]);
        answer[numbers.length-1] = -1;
        
        for(int i=numbers.length-2;i>=0;i--){
            
            int target = numbers[i];
            
            if(numbers[i+1]>target){
                answer[i] = numbers[i+1];
            }else{
                
                while( !s.isEmpty()&& s.peek() <= target ){
                    s.pop();
                }
                
                answer[i] = s.isEmpty() ? -1 : s.peek();
            }
            s.push(target);
            
        }
        return answer;
    }
}
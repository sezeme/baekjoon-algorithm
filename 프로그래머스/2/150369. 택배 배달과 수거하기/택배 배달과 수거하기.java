import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        
        Stack<int[]> stack1 = new Stack<>(); // deliveries
        Stack<int[]> stack2 = new Stack<>(); // pickups
        
        // 거리가 가장 먼 순서대로 처리하기 위해서 해당 순서로 스택에 넣기 
        // 0: 거리 1: 재고 
        for(int i = 0; i < n; i++){
            if(deliveries[i] != 0) stack1.add(new int[]{i+1, deliveries[i]});
            if(pickups[i] != 0) stack2.add(new int[]{i+1, pickups[i]});
        }
        int cap1 = 0;
        int cap2 = 0;
        
        long answer = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty()){ // 배달 or 수거 재고 모두 사라질 때까지 반복 
            cap1 = cap;
            cap2 = cap;
            
            if(!stack1.isEmpty() && !stack2.isEmpty()){ // 배달, 수거 재고 둘 다 남아있는 상태
                answer += (stack1.peek()[0] >= stack2.peek()[0] ? stack1.peek()[0] : stack2.peek()[0]) * 2;
            }
            else if(!stack1.isEmpty()){ // 배달 재고만 남아있는 상태 
                answer += (stack1.peek()[0]) * 2; 
                cap2 = 0;
            }
            else{ // 수거 재고만 남아있는 상태 
                answer += (stack2.peek()[0]) * 2; 
                cap1 = 0;
            }
            
            while(cap1!=0 && !stack1.isEmpty()){
                int [] temp = stack1.pop();
                if(cap1 >= temp[1]){
                    cap1 -= temp[1];
                }
                else{
                    temp[1] -= cap1;
                    cap1 = 0; // break;
                    stack1.push(temp);
                }
            }
            
            while(cap2!=0 && !stack2.isEmpty()){
                int [] temp = stack2.pop();
                if(cap2 >= temp[1]){
                    cap2 -= temp[1];
                }
                else{
                    temp[1] -= cap2;
                    cap2 = 0; // break;
                    stack2.push(temp);
                }
            }
        }
        return answer;
    }
}

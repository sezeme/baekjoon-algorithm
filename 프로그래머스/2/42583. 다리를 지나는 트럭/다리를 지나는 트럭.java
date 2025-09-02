import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int index = 0;
        int totalWeight = 0;
        Queue<int[]> bridge = new ArrayDeque<>(); // {weight, input time}
        int time = 0;
        
        while(index < truck_weights.length || !bridge.isEmpty()) {
            time++;
            
            if(!bridge.isEmpty()){
                int[] truck = bridge.peek();
                if(time >= truck[1] + bridge_length){
                    bridge.poll();
                    totalWeight -= truck[0];
                }
            }
            
            if(bridge.size() < bridge_length && index < truck_weights.length && totalWeight+truck_weights[index] <= weight) {
                bridge.add(new int[]{truck_weights[index], time});
                totalWeight += truck_weights[index];
                index++;
            }
        }
        
        return time;
        
    }
}
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stk = new Stack<>();
        // stack 이 input하는 순간, output하는 순간을 이용하자!
        for(int i = 0; i < prices.length; i++ ) {
            // 지금 이 시점이 stack의 top의 가격이 떨어지는 순간이라면
            while(!stk.isEmpty() && prices[stk.peek()] > prices[i]) {
                int num = stk.pop();
                answer[num] = i - num;
            }
            stk.push(i);
        }
        
        while(!stk.isEmpty()) {
            int num = stk.pop();
            answer[num] = prices.length - 1 - num;
        }
        return answer;
    }
}
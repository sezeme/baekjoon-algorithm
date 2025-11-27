import java.util.*;

class Solution {

    public int solution(int[] order) {
        int cnt = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        // 메인 벨트에서 상자 도착
        for (int box = 1; box <= order.length; box++) {
            stack.push(box);

            // 트럭에 실을 수 있을 때까지 보조 벨트에서 pop
            while (!stack.isEmpty() && stack.peek() == order[cnt]) {
                stack.pop();
                cnt++;
            }
        }

        return cnt;
    }
}
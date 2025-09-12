import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
		int k = 0;
		for(int i = 0; i < moves.length; i++) { // 0 ~ 7번
			for(int j = 0; j < board.length; j++) {
				int item = board[j][moves[i]-1];
				if(item == 0) continue;
				board[j][moves[i]-1] = 0;
				if(!stack.empty() && stack.peek() == item) {
					stack.pop();
					k += 2;
				}else stack.add(item);
                    break;
			}
		}
        return k;
    }
}
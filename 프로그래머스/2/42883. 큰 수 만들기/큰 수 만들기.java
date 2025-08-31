/*
왼쪽에서부터 숫자를 하나씩 스택에 넣음

새로운 숫자가 스택의 top보다 크면, k가 남아 있는 동안 pop

마지막에 k가 남으면 뒤에서 k개 제거

스택을 이어서 문자열로 반환
*/
import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();

        for (char ch : number.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() < ch && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }

        // k가 남아있으면 뒤에서 제거
        while (k-- > 0) stack.pop();

        // 정답 생성
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) sb.append(ch);

        return sb.toString();
    }
}
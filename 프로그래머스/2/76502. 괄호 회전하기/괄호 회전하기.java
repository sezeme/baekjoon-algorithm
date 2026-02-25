import java.util.Stack;

class Solution {
    public int solution(String s) {
        // 올바른 괄호 문자열의 개수를 저장할 변수
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            // 주어진 문자열이 올바른 괄호 문자열인지 검사
            if (verification(s)) {
                answer++;
            }

            // 문자열을 한 칸씩 회전
            s = shift(s);
        }

        return answer;
    }

    // 올바른 괄호인지 검사하는 함수
    private boolean verification(String s) {
        // 괄호를 저장할 스택
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            // 여는 괄호면 스택에 push
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                // 스택이 비어있는 경우
                if (stack.isEmpty()) {
                    return false;
                }

                // 짝이 맞는 괄호면 스택에서 pop
                if (stack.peek() == '(' && s.charAt(i) == ')')  {
                    stack.pop();
                } else if (stack.peek() == '{' && s.charAt(i) == '}') {
                    stack.pop();
                } else if (stack.peek() == '[' && s.charAt(i) == ']') {
                    stack.pop();
                // 짝이 맞지 않는 경우 false
                } else return false;
            }
        }

        return stack.isEmpty();
    }

    // 문자열 회전(부분문자열 활용)
    private String shift(String s) {
        return s.substring(1) + s.charAt(0);
    }
}

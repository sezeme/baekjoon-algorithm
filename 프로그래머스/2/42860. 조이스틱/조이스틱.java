import java.util.*;

class Solution {
    public int solution(String name) {
        int len = name.length();
        int changeCost = 0;
        
        // 1. 문자 변경 비용
        for(int i = 0; i < name.length(); i++ ) {
            char ch = name.charAt(i);
            changeCost += Math.min(ch - 'A', 26 - ch + 'A');
        }
        
        // 2. 이동 비용 최소값
        int moveCost = len - 1;
        for(int i = 0; i < len; i++) {
            int next = i + 1;
            
            // 연속된 A 건너뛰기
            while(next < len && name.charAt(next) == 'A') {
                next++;
            }
            
            // 오른쪽 갔다가 왼쪽
            moveCost = Math.min(moveCost, i + i + (len - next));
            // 왼쪽 갔다가 오른쪽
            moveCost = Math.min(moveCost, i + (len - next) * 2);
        }
        
        return changeCost + moveCost;
    }
}
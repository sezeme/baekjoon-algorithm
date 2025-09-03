import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> a[0] - b[0]); // 진입지점 작은것 먼저
        
        // 겹치는 범위를 계속 기록하기 : 겹치면 그대로 범위 기록, 겹치지 않으면 새 카메라 설치(범위 변경)
        int[] overlap = routes[0].clone();
        int count = 1;
        for(int i = 1; i < routes.length; i++) {
            int[] route = routes[i];
            
            if(overlap[1] < route[0]) { // 겹치지 않음
                count++;
                overlap = route.clone();
            } else {
                overlap = new int[]{route[0], Math.min(overlap[1], route[1])};
            }
        }
        
        
        return count;
    }
    
}
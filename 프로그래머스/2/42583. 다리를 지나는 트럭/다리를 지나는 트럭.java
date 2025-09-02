import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int n = truck_weights.length;
        int time = 0;               // 현재 시각
        int i = 0;                  // 다음에 올릴 트럭 인덱스
        int onBridgeWeight = 0;     // 다리 위 총 무게

        // 다리 위 상태: {트럭무게, 내려오는 시각}
        ArrayDeque<int[]> bridge = new ArrayDeque<>();

        while (i < n || !bridge.isEmpty()) {
            // Step A: 현재 시각에 내려와야 하는 트럭들 정리
            while (!bridge.isEmpty() && bridge.peekFirst()[1] <= time) {
                onBridgeWeight -= bridge.pollFirst()[0];
            }

            // Step B: 다음 트럭을 올릴 수 있으면 올리고, 다음 초로 이동
            if (i < n 
                && bridge.size() < bridge_length 
                && onBridgeWeight + truck_weights[i] <= weight) {

                bridge.addLast(new int[]{truck_weights[i], time + bridge_length});
                onBridgeWeight += truck_weights[i];
                i++;
                time++; // 다음 트럭은 1초 뒤에만 또 올라올 수 있음
            } else {
                // Step C: 못 올리면 다음 이벤트(가장 가까운 exitTime)로 시간 점프
                if (!bridge.isEmpty()) {
                    time = Math.max(time, bridge.peekFirst()[1]);
                }
            }
        }

        // 보정: 문제 시간 정의(첫 진입을 1초로 세는 관례) 맞추기
        return time + 1;
    }
}

import java.util.*;

class Solution {

    int[] dx = {0, -1, 1, 0, 0};
    int[] dy = {0, 0, 0, -1, 1};

    public int solution(int[][] clockHands) {
        int min = 200;
        int n = clockHands.length;
        int[][] spinMap = new int[n][n];  // 각 칸의 누적 회전 상태 기록

        // 첫 줄 회전 조합을 비트마스크로 완전탐색 (2비트 * n칸 = 4^n)
        Outter : for (int spins = 0; spins < (1 << (2 * n)); spins++) {
            Arrays.stream(spinMap).forEach(row -> Arrays.fill(row, 0));
            int sum = 0;

            // 첫 줄은 회전 조합으로, 나머지 줄은 위쪽 시계를 12시로 맞추기 위한 회전 유도
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    int spin = row == 0
                        ? (spins >> (col * 2)) & 3
                        : (4 - ((clockHands[row - 1][col] + spinMap[row - 1][col]) & 3)) & 3;

                    // 회전 시 자신과 인접 시계에 영향 적용
                    for (int i = 0; i < 5; i++) {
                        int nx = row + dx[i];
                        int ny = col + dy[i];
                        if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                            spinMap[nx][ny] = (spinMap[nx][ny] + spin) & 3;
                        }
                    }

                    sum += spin;
                    if (sum >= min) continue Outter;  // pruning
                }
            }

            // 마지막 줄이 모두 12시 방향인지 확인
            for (int col = 0; col < n; col++) {
                if (((clockHands[n - 1][col] + spinMap[n - 1][col]) & 3) != 0) continue Outter;
            }

            min = Math.min(min, sum);
        }

        return min;
    }
}
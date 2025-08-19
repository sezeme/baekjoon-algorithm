import java.util.*;

class Solution {

    public int solution(int[][] triangle) {
        int n = triangle.length;

        int[][] dp = new int[n][n];

        // 초기값 세팅
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle[i][j];
            }
        }

        // DP 점화식 적용
        for (int i = 1; i < n; i++) {
            dp[i][0] += dp[i - 1][0]; // 왼쪽 모서리
            for (int j = 1; j <= i; j++) {
                // 왼쪽 위 또는 오른쪽 위 중 더 큰 값 선택
                dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }

        // 마지막 줄에서 최댓값 반환
        return Arrays.stream(dp[n - 1]).max().getAsInt();
    }
}
class Solution {

    int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        long[][][] dp = new long[m][n][2]; // 0: 위→아래, 1: 왼→오른쪽

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 시작점에서 바로 오른쪽/아래 초기화
                if (i == 0 && j == 0) {
                    if (m > 1) dp[1][0][0] = 1;
                    if (n > 1) dp[0][1][1] = 1;
                }

                int road = cityMap[i][j];
                if (road == 1) continue; // 진입 불가

                // 아래 방향으로 전달
                if (i + 1 < m) {
                    dp[i + 1][j][0] += dp[i][j][0] + ((road == 0) ? dp[i][j][1] : 0);
                    dp[i + 1][j][0] %= MOD;
                }

                // 오른쪽 방향으로 전달
                if (j + 1 < n) {
                    dp[i][j + 1][1] += dp[i][j][1] + ((road == 0) ? dp[i][j][0] : 0);
                    dp[i][j + 1][1] %= MOD;
                }
            }
        }

        return (int) ((dp[m - 1][n - 1][0] + dp[m - 1][n - 1][1]) % MOD);
    }
}
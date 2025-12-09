public class Solution {

    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = (long) (10e9 * 2 * 10e5 * 2);

        int cityLength = g.length;
        long start = 0;
        long end = (long) (10e9 * 2 * 10e5 * 2);

        while (start <= end) {
            long mid = (start + end) / 2;
            int gold = 0;
            int silver = 0;
            int add = 0;

            for (int i = 0; i < cityLength; i++) {
                int nowGold = g[i];
                int nowSilver = s[i];
                int nowWeight = w[i];
                long nowTime = t[i];

                long moveCount = mid / (nowTime * 2);
                if (mid % (nowTime * 2) >= t[i]) {
                    moveCount++;
                }

                gold += Math.min(nowGold, moveCount * nowWeight);
                silver += Math.min(nowSilver, moveCount * nowWeight);
                add += Math.min(nowGold + nowSilver, moveCount * nowWeight);
            }

            if (a <= gold && b <= silver && a + b <= add) {
                end = mid - 1;
                answer = Math.min(mid, answer);
                continue;
            }

            start = mid + 1;
        }

        return answer;
    }
}
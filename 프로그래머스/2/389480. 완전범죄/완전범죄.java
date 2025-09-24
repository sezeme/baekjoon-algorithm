import java.util.Arrays;

class Solution {
    public static final int MAX_TRACE = 120;

    public int solution(int[][] info, int n, int m) {
        int[] bTraces = new int[n];

        Arrays.fill(bTraces, MAX_TRACE + 1);
        bTraces[0] = 0;

        for (int[] traces : info) {
            for (int aTrace = n - 1; aTrace >= 0; aTrace--) {
                bTraces[aTrace] += traces[1];

                if (aTrace - traces[0] >= 0) {
                    bTraces[aTrace] = Math.min(bTraces[aTrace], bTraces[aTrace - traces[0]]);
                }
            }
        }

        for (int aTrace = 0; aTrace < n; aTrace++) {
            if (bTraces[aTrace] < m) {
                return aTrace;
            }
        }

        return -1;
    }
}
class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        for (int y = 1; y <= r2; y++) { // (1)
            int x2 = (int) Math.sqrt(Math.pow(r2, 2) - Math.pow(y, 2)); // (2)
            int x1 = (int) Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(y, 2))); // (3)
            answer += x2 - x1 + 1; // (4)
        }
        return answer * 4;
    }
}
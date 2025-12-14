class Solution {
    public long solution(int w, int h) {
        long W = w, H = h;

        long gcd = getGCD(W, H);
        return (W * H) - (W + H - gcd); // (전체 칸 수) - (전체 지우기 칸 수)
    }

    private long getGCD(long numA, long numB) {
        long a = numA, b = numB;
        long mod = Long.MAX_VALUE;
        while (mod != 0) {
            mod = a % b;
            a = b;
            b = mod;
        }
        return a;
    }
}
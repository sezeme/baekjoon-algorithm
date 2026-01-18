class Solution {
    public int solution(String s) {
        int n = s.length();
        int max = 1;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, expand(s, i, i));
            max = Math.max(max, expand(s, i, i + 1));
        }

        return max;
    }

    private int expand(String s, int left, int right) {
        int n = s.length();
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
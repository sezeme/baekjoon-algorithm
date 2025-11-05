import java.util.*;

class Solution {
    public int solution(int[] elements) {
        // 길이, 부분수열 시작 지점
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= elements.length; i++) { // 길이
            int sum = 0;
            for(int j = 0; j < i; j++) sum += elements[j];
            set.add(sum);
            if(i == elements.length) break;
            for(int j = i; j < elements.length + i; j++) {
                sum -= elements[(j-i+elements.length)%elements.length];
                sum += elements[j%elements.length];
                set.add(sum);
            }
        }
        return set.size();
    }
}
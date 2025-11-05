import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> need = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            need.put(want[i], number[i]);
        }
        
        Map<String, Integer> window = new HashMap<>();
        int answer = 0;
        
        for(int i = 0; i < discount.length; i++) {
            window.put(discount[i], window.getOrDefault(discount[i], 0) + 1);

            if (i >= 10) {
                String removeItem = discount[i - 10];
                window.put(removeItem, window.get(removeItem) - 1);
            }
            
            if (i >= 9) {
                boolean ok = true;
                for (String w : need.keySet()) {
                    if (window.getOrDefault(w, 0) != need.get(w)) {
                        ok = false;
                        break;
                    }
                }
                if (ok) answer++;
            }
        }
        return answer;
    }
}
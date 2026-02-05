import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public int solution(String[][] clothes) {

        int answer = 1;
        Map<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            hm.put(key, hm.getOrDefault(key, 0) + 1);
        }

        Iterator<Integer> iter = hm.values().iterator();

        while (iter.hasNext()) {
            answer *= iter.next().intValue() + 1;
        }

        return answer - 1;
    }
}
import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        // choice가 1,2,3이면 [0], 5,6,7이면 [1]의 값을 각각 1~3점씩 증가
        HashMap<Character, Integer> count = new HashMap<>();
        for(int i = 0; i < survey.length; i++) {
            char[] flag = survey[i].toCharArray();
            int choice = choices[i];
            if(choice <= 3) {
                count.put(flag[0], count.getOrDefault(flag[0], 0) + 4 - choice);
            } else if(choice >= 5) {
                count.put(flag[1], count.getOrDefault(flag[1], 0) + choice - 4);
            }
        }
        
        // stringBuilder에 결과 리턴
        StringBuilder sb = new StringBuilder();
        if(count.getOrDefault('R', 0) >= count.getOrDefault('T', 0)) {
            sb.append("R");
        } else {
            sb.append("T");
        }
        
        if(count.getOrDefault('C', 0) >= count.getOrDefault('F', 0)) {
            sb.append("C");
        } else {
            sb.append("F");
        }
        
        if(count.getOrDefault('J', 0) >= count.getOrDefault('M', 0)) {
            sb.append("J");
        } else {
            sb.append("M");
        }
        
        if(count.getOrDefault('A', 0) >= count.getOrDefault('N', 0)) {
            sb.append("A");
        } else {
            sb.append("N");
        }
        return sb.toString();
    }
}
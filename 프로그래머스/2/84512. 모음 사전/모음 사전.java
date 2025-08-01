import java.util.*;

class Solution {
    static String s;
    static ArrayList<String> list = new ArrayList<>();
    
    public int solution(String word) {
        // 모든 중복 순열 구하기 (5개 중 1개 뽑기, 2개 뽑기… 5개 뽑기)
        // 정렬
        // 원하는 값의 index 출력
        s = "AEIOU";
        for(int i = 1; i <=5; i++) {
            duplePermutation(i, 0, new char[5]);
        }
        Collections.sort(list);
            return list.indexOf(word) + 1;
    }
    
    public void duplePermutation(int r, int depth, char[] answer) {
        if(depth == r) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < r; i++) {
                sb.append(answer[i]);
            }
            list.add(sb.toString());
            return;
        }
        
        for(int i=0; i < s.length(); i++) {
            answer[depth] = s.charAt(i);
            duplePermutation(r, depth + 1, answer);
        }
    }
}
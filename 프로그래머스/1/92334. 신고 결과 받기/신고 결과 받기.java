import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // REPORT 중복 제거
        HashSet<String> reportSet = new HashSet<>();
        for(String r : report) {
            reportSet.add(r);
        }
        
        // <신고 당한 사람, 신고한 사람 목록>
        HashMap<String, List<String>> reportMap = new HashMap<>();
        StringTokenizer st;
        for(String r : reportSet) {
            st = new StringTokenizer(r);
            String reporter = st.nextToken();  // 신고한 사람
            String reported = st.nextToken();  // 신고 당한 사람

            reportMap.putIfAbsent(reported, new ArrayList<>());
            reportMap.get(reported).add(reporter);
        }
        
        // reportMap에서 신고한 사람 수가 k보다 많다면 => 사람 순회돌면서 개수 증가
        // 회원이 처리 결과 메일을 몇 번 받는지 세기
        HashMap<String, Integer> reportCount = new HashMap<>();
        for(Map.Entry<String, List<String>> entry : reportMap.entrySet()) {
            if(entry.getValue().size() >= k) {
                for(String reporter : entry.getValue()) {
                    reportCount.put(reporter, reportCount.getOrDefault(reporter, 0) + 1);
                }
            }
        }
        
        // list와 비교대조 하기
        int[] answer = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            answer[i] = reportCount.getOrDefault(id, 0);
        }
        
        return answer;
    }
}
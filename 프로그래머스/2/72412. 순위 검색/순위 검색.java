import java.util.*;

class Solution {

    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> typeMap = new HashMap<>();

        // info를 기반으로 가능한 모든 조건 조합을 Map에 저장
        for (String s : info) {
            String[] type = s.split(" ");
            for (int i = 0; i < (1 << 4); i++) {  // 0 ~ 15 (16가지 조합)
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 4; j++) {
                    sb.append((i & (1 << j)) != 0 ? type[j] : "-").append(" ");
                }
                String key = sb.toString().trim();
                typeMap.computeIfAbsent(key, k -> new ArrayList<>())
                       .add(Integer.parseInt(type[4]));
            }
        }

        // 각 조건 조합의 점수 리스트를 오름차순 정렬
        for (List<Integer> list : typeMap.values()) {
            list.sort(Comparator.naturalOrder());
        }

        int[] answer = new int[query.length];

        // 각 query를 처리
        for (int i = 0; i < query.length; i++) {
            // "and"를 제거하고 공백 기준 split
            String[] parts = query[i].replace(" and ", " ").split(" ");
            String key = String.join(" ", Arrays.copyOfRange(parts, 0, 4));  // 조건 key
            int score = Integer.parseInt(parts[4]);  // 점수 기준

            // 해당 조건 조합의 점수 리스트를 가져옴 (없으면 빈 리스트)
            List<Integer> list = typeMap.getOrDefault(key, new ArrayList<>());

            // score 이상인 첫 인덱스를 찾는 lower bound 이분 탐색
            answer[i] = list.size() - binarySearch(score, list);
        }

        return answer;
    }

    // score 이상인 첫 번째 인덱스를 반환하는 lower bound 이진 탐색
    public int binarySearch(int score, List<Integer> scoreList) {
        if (scoreList.isEmpty() || score > scoreList.get(scoreList.size() - 1)) return scoreList.size();

        int left = 0, right = scoreList.size() - 1;
        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midScore = scoreList.get(mid);

            if (midScore < score) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }
}
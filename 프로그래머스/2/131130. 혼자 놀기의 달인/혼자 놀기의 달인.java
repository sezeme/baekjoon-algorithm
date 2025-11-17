import java.util.*;

class Solution {

    public int solution(int[] cards) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Set<Integer> visited = new HashSet<>();

        for (int card : cards) {
            int cur = card;
            int len = 0;

            // 방문한 상자는 다시 방문하지 않도록 Set에 기록
            while (visited.add(cur)) {
                cur = cards[cur - 1];
                len++;
            }

            pq.add(len);
        }

        return pq.poll() * pq.peek();  // 가장 큰 두 그룹 길이 곱
    }
}
import java.util.stream.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        // left부터 right까지 각 인덱스를 순회
        return LongStream.rangeClosed(left, right)
                // 각 인덱스 i에 대해 (i / n, i % n)에 해당하는 max(row, col) + 1 계산
                .mapToInt(i -> (int) Math.max(i / n, i % n) + 1)
                // 최종 배열로 반환
                .toArray();
    }
}
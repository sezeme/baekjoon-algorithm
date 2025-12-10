class Solution {

    private final int INF = 100 * 100 + 1;

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] table = new int[rows][columns];

        // 초기 행렬 값 채우기: 1부터 시작해 가로 방향으로 채움
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                table[i][j] = i * columns + j + 1;
            }
        }

        // 각 회전에 대해 테두리 회전 실행 및 최솟값 기록
        for (int i = 0; i < queries.length; i++) {
            answer[i] = getRotatedMin(queries[i], table);
        }

        return answer;
    }

    public int getRotatedMin(int[] query, int[][] table) {
        int x1 = query[0] - 1, y1 = query[1] - 1, x2 = query[2] - 1, y2 = query[3] - 1;
        int min = INF;

        // 회전 전 테두리 값을 순서대로 이동하며 prev-cur 방식으로 회전 처리
        int prev = table[x1][y1], cur;

        // 상단 테두리 오른쪽으로 이동
        for (int y = y1 + 1; y <= y2; y++) {
            min = Math.min(min, (cur = table[x1][y]));
            table[x1][y] = prev;
            prev = cur;
        }

        // 우측 테두리 아래로 이동
        for (int x = x1 + 1; x <= x2; x++) {
            min = Math.min(min, (cur = table[x][y2]));
            table[x][y2] = prev;
            prev = cur;
        }

        // 하단 테두리 왼쪽으로 이동
        for (int y = y2 - 1; y >= y1; y--) {
            min = Math.min(min, (cur = table[x2][y]));
            table[x2][y] = prev;
            prev = cur;
        }

        // 좌측 테두리 위로 이동
        for (int x = x2 - 1; x >= x1; x--) {
            min = Math.min(min, (cur = table[x][y1]));
            table[x][y1] = prev;
            prev = cur;
        }

        return min;
    }
}
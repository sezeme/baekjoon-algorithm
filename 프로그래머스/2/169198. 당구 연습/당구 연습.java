import java.util.*;
class Solution {
   public static int[] solution(int m, int n, int startX, int startY, int [][] balls) {

        // 답 배열
        int [] answer = new int[balls.length];

        // 당구대 범위
        Point board = new Point(m,n);

        // 시작 볼 위치
        Point start  = new Point(startX,startY);

        // 도착 볼 위치
        for(int i = 0; i < balls.length; i++){
            int [] ball = balls[i];
            
            // (1) 대칭 정보 반환
            List<Point> transBall = symmetricTransposition(board, start, new Point(ball[0], ball[1]));

            int minDistance = Integer.MAX_VALUE;
            for(Point point : transBall){
                // (2)대칭 볼들과 시작 볼의 거리 계산
                int distance = calculationDistance(start, point);
                
                // (2)가장 적은 거리를 담는다.
                minDistance = Math.min(minDistance, distance);
            }
            answer[i] = minDistance;
        }
        return answer;

    }

    // (3)
    private static List<Point> symmetricTransposition(Point board, Point start, Point ball){
        List<Point> syms = new ArrayList<>();

        // 4개의 방향으로 대칭이동
        // 선 대칭일 때, 벽보다 공에 먼저 맞는 경우 제외
        if(!(start.x == ball.x && start.y > ball.y)) syms.add(new Point(ball.x, ball.y * -1));
        if(!(start.x == ball.x && start.y < ball.y)) syms.add(new Point(ball.x, board.y + (board.y - ball.y)));
        if(!(start.x < ball.x && start.y == ball.y)) syms.add(new Point(board.x + (board.x - ball.x) , ball.y));
        if(!(start.x > ball.x && start.y == ball.y)) syms.add(new Point(ball.x * -1, ball.y));

        return syms;
    }
    
    // (4) 두 볼 사이간의 거리 제곱 계산
    private static int calculationDistance(Point start, Point ball){
        int deltaX = start.x - ball.x; // x 계산
        int deltaY = start.y - ball.y; // y 계산

        return deltaX * deltaX + deltaY * deltaY;
    }
    private static class Point {
        int x,y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
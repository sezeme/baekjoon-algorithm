// 12시 부터 시계방향
// 0 - 12시, 2 - 3시, 6 - 9시
// linkedList, 탐색 + push,remove
import java.io.*;
import java.util.*;


class Main {
    static List<LinkedList<Integer>> gears;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] input = new char[4][8];
        for(int i =0 ; i < 4; i++){
            input[i] = br.readLine().toCharArray();
        }

        gears = new LinkedList<>();
        for(int i = 0; i < 4; i++) {
            LinkedList<Integer> gear = new LinkedList<>();
            for (int j = 0; j < 8; j++) {
                gear.add(input[i][j] - '0');
            }
            gears.add(gear);
        }

        K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int gearNumber = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());

            rotate(gearNumber, direction, new boolean[4]);
        }

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer += gears.get(i).getFirst() << i;
        }
        System.out.println(answer);
    }

    static void rotate(int gearNumber, int direction, boolean[] visited) {
        visited[gearNumber] = true;
        if(gearNumber <= 2 && !visited[gearNumber + 1] && gears.get(gearNumber).get(2) + gears.get(gearNumber+1).get(6) == 1) {
            rotate(gearNumber+1, -direction, visited);
        }
        if(gearNumber >= 1 && !visited[gearNumber - 1] && gears.get(gearNumber).get(6) + gears.get(gearNumber-1).get(2) == 1) {
            rotate(gearNumber-1, -direction, visited);
        }

        // 회전
        LinkedList<Integer> gear = gears.get(gearNumber);
        if(direction == 1) {
            gear.addFirst(gear.removeLast());
        } else {
            gear.addLast(gear.removeFirst());
        }
    }
}
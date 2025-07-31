import java.io.*;
import java.util.*;

class Main {
    static int n, w, L;
    static int[] trucks;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 트럭 수
        w = Integer.parseInt(st.nextToken()); // 다리 길이
        L = Integer.parseInt(st.nextToken()); // 최대 하중
        
        trucks = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }
        
        
        Queue<Integer> bridge = new ArrayDeque<>();
        int time = 0;
        int currentWeight = 0;
        int index = 0;
        
        for(int i =0; i<w ; i++) {
			bridge.add(0);
		}
        while (index < n || currentWeight > 0) {
            time++;
            currentWeight -= bridge.poll();
            
            // 다음 트럭을 올릴 수 있으면 올리기
            if(index < n && currentWeight + trucks[index] <= L) {
                bridge.offer(trucks[index]);
                currentWeight += trucks[index];
                index++;
            } else {
                // 못올리면 0을 넣음
                bridge.offer(0);
            }
        }
        
        System.out.println(time);
       
    }
}
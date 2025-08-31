import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N;
        int[] arr;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(; T > 0; T--) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            long max = Integer.MIN_VALUE;
            long sum = 0;
            for(int i = N-1; i >= 0; i--) {
                if(max < arr[i]) {
                    max = arr[i];
                } else {
                    sum += (max-arr[i]);
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
        
    }
}
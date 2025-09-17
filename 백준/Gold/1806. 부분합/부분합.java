import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        for(int start = 0; start < N; start++) {
            while(end < N && sum < S) sum += arr[end++]; // 여기서 ++ 해주고 있음
            
            if(sum >= S) {
                min = Math.min(min, end - start);
            }
            sum -= arr[start];
        }
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}
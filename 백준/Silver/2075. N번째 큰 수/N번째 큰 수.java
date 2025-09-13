import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 최대 수 : 2250000 * 1500
        // 1. 우선순위 큐 : n log n
        // 2. 정렬 : n log n
        // 둘 다 안풀림
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N*N];
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[(i * N) + j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr);
        System.out.println(arr[N*N - N]);
    }
}
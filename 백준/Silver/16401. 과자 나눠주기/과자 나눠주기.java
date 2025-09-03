import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] snacks = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(snacks);
        
        int low = 1;
        int high = snacks[snacks.length - 1];
        int mid;
        int answer = 0;
        
        while(low <= high) {
            mid = (low + high)/2;
            if(canDivide(snacks, M, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(answer);
    }
    
    public static boolean canDivide(int[] snacks, int m, int L) {
        long count = 0;
        for (int snack : snacks) {
            count += snack / L;
        }
        return count >= m;
    }
}

/*
조건 : 만들 수 있는 과자 길이 L 중에서 최대
모든 과자를 L로 나눴을 때 얻는 총 개수
*/
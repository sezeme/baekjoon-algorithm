import java.io.*;
import java.util.*;

class Main {
    public static int gcd(int a, int b) {
        int tmp;
        
        if(a > b) {
            tmp = a;
            a = b;
            b = tmp;
        }
        
        while(a != 0) {
            tmp = a;
            a = b % a;
            b = tmp;
        }
        
        return b;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            long sum = 0;
            for(int i = 0; i < n-1; i++) {
                for(int j = i+1; j < n; j++) {
                    sum += gcd(arr[i], arr[j]);
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
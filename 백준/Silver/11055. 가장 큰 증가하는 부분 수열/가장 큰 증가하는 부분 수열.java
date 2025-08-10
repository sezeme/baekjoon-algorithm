import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[N];
        int arr[] = new int[N];
        int result = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        
        for(int i =0;i<N;i++){
            dp[i] = arr[i];
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i]){
                    dp[i] =Math.max(dp[i], dp[j]+arr[i]);
                }
            }
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}
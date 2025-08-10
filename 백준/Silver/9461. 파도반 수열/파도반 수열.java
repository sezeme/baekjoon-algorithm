import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long dp[] = new long[101];
        dp[1]=1;
        dp[2]=1;
        dp[3]=1;
        dp[4]=2;
        dp[5]=2;
        dp[6]=3;
        dp[7]=4;
        dp[8]=5;
        dp[9]=7;
        dp[10]=9;
        
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            for(int i=11; i<=N; i++){
                dp[i] = dp[i-1]+dp[i-5];
            }
            System.out.println(dp[N]);
            
        }
        
    }
}
// hashSet으로 풀이
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M;
        HashSet<String> set = new HashSet<>();
        
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            set.add(st.nextToken());
        }
        
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++ ) {
            if(set.contains(st.nextToken())) sb.append(1);
            else sb.append(0);
            sb.append(" ");
        }
        
        System.out.println(sb);
    }
}
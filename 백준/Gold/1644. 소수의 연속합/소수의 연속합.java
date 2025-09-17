import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 연속된 소수의 합으로 나타낼 수 있는 경우의 수
        // 에라토스테네스의 체
        int MAX_VALUE = 4000001;
        boolean[] isNotPrime = new boolean[MAX_VALUE];
        //false == 소수!
        for(int i = 2; i*i < MAX_VALUE; i++) {
            if(!isNotPrime[i]) {
                for(int j = i+i; j < MAX_VALUE; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
        
        int N = Integer.parseInt(br.readLine());
        
        List<Integer> primes = new ArrayList<>();
        for(int i = 2; i <= N; i++) {
            if(!isNotPrime[i]) primes.add(i);
        }
        
        int end = 0;
        int sum = 0;
        int count = 0;
        for(int start = 0; start < primes.size(); start++) {
            while(end < primes.size() && sum < N) sum += primes.get(end++);
            if(sum == N) count++;
            sum -= primes.get(start);
        }
        
        System.out.println(count);

    }
}
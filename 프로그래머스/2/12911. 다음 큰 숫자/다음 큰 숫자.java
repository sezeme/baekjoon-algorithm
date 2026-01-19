class Solution {
    public int solution(int n) {
        int targetCount = countOnes(n);
        while(targetCount != countOnes(n+1)){
           n++; 
        }
        return n+1;
    }
    
    private int countOnes(int x) {
        int count = 0;
        while (x > 0) {
            count += (x & 1);
            x >>= 1;
        }
        return count;
    }
}

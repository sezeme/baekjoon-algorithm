class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int digit = storey % 10;
            
            if (digit > 5) {
                answer += (10 - digit);
                storey += 10;
            } else if (digit < 5) {
                answer += digit;
            } else { // digit == 5
                // 다음 자리수가 5 이상이면 올리는게 유리
                int next = (storey / 10) % 10;
                if (next >= 5) {
                    answer += 5;
                    storey += 10;
                } else {
                    answer += 5;
                }
            }
            
            storey /= 10;
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int[] solution(int[][] users, int[] emoticons) {
        // 이모티콘별 할인율 배열
        int[] saleRate = new int[emoticons.length];
        // 이모티콘 할인율 경우의수
        int saleRateCase = (int) Math.pow(4, emoticons.length);
        int join = 0;  // 가입자수
        int sum = 0;  // 매출액
        for(int i=0; i<saleRateCase; i++) {
            // 이모티콘별 할인율 계산
            for(int j=0; j<saleRate.length; j++) {
                saleRate[j] = 10 * (1 + (i / (int) Math.pow(4, j)) % 4);
            }
            int userJoin = 0;
            int userSums = 0;
            
            for(int j=0; j<users.length; j++) {
                int userSum = 0;  // 유져금액 합계
                int userRate = users[j][0];
                for(int l=0; l<saleRate.length; l++) {
                    if(saleRate[l] >= userRate) {
                        userSum += (emoticons[l] * (100-saleRate[l])) / 100;
                    }
                }
                if(userSum >= users[j][1]) {
                    userJoin ++;
                } else {
                    userSums += userSum;
                }
            }
            if(userJoin == join) {
                join = userJoin;
                sum = Math.max(sum, userSums);
            } else if(userJoin > join) {
                join = userJoin;
                sum = userSums;
            }
        }
        int[] answer = {join, sum};
        return answer;
    }
}
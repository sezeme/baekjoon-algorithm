class Solution {  
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long x1 = x, y1 = y;
        long x2 = x, y2 = y;
        
        for(int i = queries.length-1; i >= 0; i--){
            int dir = queries[i][0];
            int size = queries[i][1];
            
            /*
            * 역추적하기 위해서 밑에 주석을 역추적하는 방향으로 적었음
            * 예를 들어 0번은 원래 왼쪽으로 움직이는 건데, 오른쪽이라고 적었음
            */
            switch(dir){
                // 오른쪽
                case 0:
                    if(y1 != 0) y1 += size;
                    y2 = Math.min(y2+size,m-1);
                    if(y1 > m-1) return 0; // 범위 밖으로 나가는지 체크
                    break;
                // 왼쪽
                case 1:
                    if(y2 != m-1) y2 -= size;
                    y1 = Math.max(y1-size,0);
                    if(y2 < 0) return 0;
                    break;
                // 아래
                case 2:
                    if(x1 != 0) x1 += size;
                    x2 = Math.min(x2+size,n-1);
                    if(x1 > n-1) return 0;
                    break;
                // 위
                case 3:
                    if(x2 != n-1) x2 -= size;
                    x1 = Math.max(x1-size,0);
                    if(x2 < 0) return 0;
                    break;
            }
        }
        return (x2-x1+1)*(y2-y1+1); // 최종 계산
    }
}
import java.util.*;

class Solution {
    List<int[]> arr = new ArrayList<>();
    public int solution(int n, int m, int[][] timetable) {
        int[] start = new int[m];
        int[] end = new int[m];
        for(int i=0;i<m;i++){
            start[i] = timetable[i][0];
            end[i] = timetable[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int maxTime = 0;
        int nowTime = 0;
        int sTime = 0;
        int eTime = 0;
        while(sTime<m){
            if(start[sTime]<=end[eTime]){
                sTime +=1;
                nowTime +=1;
                maxTime = Math.max(nowTime,maxTime);
            } else {
                nowTime -=1;
                eTime+=1;
            }
        }

        if(maxTime==1){
            return 0;
        }
        if(maxTime==2){
            return 2*(n-1);
        }
        if(maxTime > (n*n+1)/2){
            return 1;
        }
        int ans = 2;
        int low = 3;
        int high = 2 * (n - 1);
        while(low<=high){
            int i = (low+high)/2;
            arr.clear();
            arr.add(new int[]{0,0});
            if (checkHuman(maxTime, 1, 1, i, n)) {
                ans = i;
                low = i+1;
            } else {
                high = i-1;
            }
        }
        return ans;
    }

    private boolean checkHuman(int maxHuman,int humanCount,int start,int dist,int n){
        if(maxHuman==humanCount){
            return true;
        } else {
            for(int k = start; k < n * n; k++){
                if(n*n-k<(maxHuman-humanCount-1)*(dist)){
                    break;
                }
                int i = k / n;
                int j = k % n;
                if(checkPosition(arr, i, j, dist)){
                    arr.add(new int[]{i, j});
                    if(checkHuman(maxHuman, humanCount + 1,k + 1, dist, n)){
                        return true;
                    }
                    arr.remove(arr.size() - 1);
                }
            }
            return false;
        }
    }

    private boolean checkPosition(List<int[]> arr,int x,int y, int dist){
        int nowDist;
        for(int i=arr.size()-1;i>=0;i--){
            nowDist = Math.abs(arr.get(i)[0]-x)+Math.abs(arr.get(i)[1]-y);
            if(nowDist < dist){
                return false;
            }
        }
        return true;
    }
}
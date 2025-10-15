import java.util.*;

class Solution {
    int[] ryan;
    int[] apeach;
    int n, maxDiff;

    /*
    dfs로 끝에 도달하면 -> 이기는지 지는지 판단. 전부 지는경우밖에 없는 것을 대비해서 canWin boolean을 이길 경우 true로 변경 점수 차이가 기존 max 점수차이보다 더 나는지 판단
    만약 더 난다면, 배열을 비교 -> 두 배열 중 한 배열 선택
    */
    public int[] solution(int n, int[] info) {
        this.apeach = info;
        this.n = n;
        dfs(new int[11], 0, 0);
        return maxDiff > 0 ? ryan : new int[]{-1};
    }
    
    void dfs(int[] arr, int depth, int idx) {
        if(idx == 11) {
            if(depth != n) arr[10] += n - depth;
            int diff = compare(arr);
            if(diff > 0) {
                if(maxDiff == diff && isBetter(arr)) {
                    ryan = arr.clone();
                } else if(maxDiff < diff) {
                    ryan = arr.clone();
                    maxDiff = diff;
                }
            }
            if(depth != n) arr[10] -= n - depth;
            return;
        }
        
        // 점수를 먹거나, 먹지 않거나
        int need = apeach[idx] + 1;
        if (need <= n - depth) {
            arr[idx] = need;
            dfs(arr, depth + need, idx + 1);
            arr[idx] = 0;
        }
        
        dfs(arr, depth, idx + 1);
    }
        
    boolean isBetter(int[] arr) {
        for(int i = 10 ; i >= 0; i--) {
            if(arr[i] > ryan[i]) return true;
            if(arr[i] < ryan[i]) return false;
        }
        return false;
    }
    
    int compare(int[] arr) {
        int ryanScore = 0;
        int apeachScore = 0;
        
        for(int i = 0; i <= 10; i++) {
            if(arr[i] == 0 && apeach[i] == 0) continue;
            
            if(arr[i] > apeach[i]) {
                ryanScore += 10 - i;
            } else {
                apeachScore += 10 - i;
            }
        }
        
        return ryanScore - apeachScore;
    }
}
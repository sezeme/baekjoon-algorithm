import java.util.*;

class Solution {
    int[] ryan = new int[11];
    int[] apeach = new int[11];
    int maxDiff = 0;
    ArrayList<int[]> candidRyans = new ArrayList<>();

    void onEnd(int scoreDiff) {
        if (scoreDiff == 0) {
            return;
        }
        if(scoreDiff > maxDiff) {
            maxDiff = scoreDiff;
            candidRyans = new ArrayList<>();
            candidRyans.add(ryan.clone());
        } else if (scoreDiff == maxDiff) {
            candidRyans.add(ryan.clone());
        }
    }

    int calcDiff(int idx, int diff) {
        if(ryan[idx] > apeach[idx]) {
            if (apeach[idx] == 0) {
                return diff + 10 - idx;
            } else if (apeach[idx] > 0) {
                return diff + (10 - idx) * 2;
            }
        } else {
            return diff;
        }
        return diff;
    }

    void dfs(int idx, int rem, int scoreDiff) {
        if (rem<0) {return;}
        if (rem == 0) {onEnd(scoreDiff);}
        if (idx != 11) { 
            for(int cnt = apeach[idx] + 1; cnt >=0; cnt--) {
                ryan[idx] += cnt;
                dfs(idx+1, rem - cnt, calcDiff(idx, scoreDiff));
                ryan[idx] -= cnt;
            }
        } 
    }

    int apeachScore() {
        int ret = 0;
        for(int i = 0; i < 11; i++) {
            if (apeach[i] > 0) {ret += 10-i;}
        }
        return ret;
    }

    int[] oneTrueRyan() { 
        for (int i = 10; i>=0; i--) {
            if(candidRyans.size()==1) {break;}
            ArrayList<int[]> nextRyans = new ArrayList<>();
            int maxI = 0;
            for (int[] ryan : candidRyans) {
                maxI = Math.max(ryan[i], maxI);
            }
            for(int[]ryan: candidRyans) {
                if (ryan[i] == maxI) {
                    nextRyans.add(ryan);
                }
            }
            candidRyans = nextRyans;
        }
        return candidRyans.get(0);
    }

    public int[] solution(int n, int[] info) {
        this.apeach = info;
        dfs(0, n, -apeachScore());
        if (maxDiff == 0) {
            return new int[] {-1};
        }
        return oneTrueRyan();
    }
}
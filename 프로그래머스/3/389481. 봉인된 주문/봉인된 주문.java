import java.util.*;

class Solution {
    static long[] banned;
    
    public String solution(long n, String[] bans) {
        banned = new long[bans.length];
        for(int i = 0; i < bans.length; i++) {
            banned[i] = getIndex(bans[i]);
        }
        Arrays.sort(banned);
        
        long lo = 1, hi = (long) 4e15;
        
        while(lo < hi) {
            long mid = (lo + hi) / 2;
            long remain = mid - countBanned(mid);
            if(remain >= n) hi = mid;
            else lo = mid + 1;
        }
        
        return getString(lo);
    }
    
    static long getIndex(String s) {
        long index = 0;
        for(int i = 1; i < s.length(); i++) {
            index += Math.pow(26, i);
        }
        long pos = 0;
        for (char c : s.toCharArray()) {
            pos = pos * 26 + (c - 'a');
        }
        return index + pos + 1;
    }
    
    static long countBanned(long x) {
        int idx = Arrays.binarySearch(banned, x);
        if (idx < 0) idx = -idx - 1;
        else {
            while (idx + 1  < banned.length && banned[idx + 1] == x) idx++;
            idx++;
        }
        return idx++;
    }
    
    static String getString(long k) {
        int len = 1;
        long cnt = 26;
        while(k > cnt) {
            k -= cnt;
            cnt *= 26;
            len++;
        }
        k--;
        char[] s = new char[len];
        for(int i = len - 1; i >= 0; i--) {
            s[i] = (char) ('a' + (k % 26));
            k /= 26;
        }
        return new String(s);
    }
}
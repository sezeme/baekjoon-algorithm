import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int len = lock.length + key.length*2 - 2;
        int[][] nl = new int[len][len];
        for(int i=key.length-1; i<key.length+lock.length-1; i++){
            for(int j=key.length-1; j<key.length+lock.length-1; j++){
                nl[i][j] = lock[i-key.length+1][j-key.length+1];
            }
        }
        
        for(int i=0; i<4; i++){
            if(match(key, nl, lock.length)){
                answer = true;
                break;
            }
            else{
                rotate(key);
            }
        }
        
        return answer;
    }
    
    public boolean match(int[][] key, int[][] lock, int len){
        for(int i=0; i<key.length+len-1; i++){
            for(int j=0; j<key.length+len-1; j++){ 
                for(int x=0; x<key.length; x++){
                    for(int y=0; y<key.length; y++){
                        lock[i+x][j+y] += key[x][y];
                    }
                }
                
                boolean check = true;
                for(int x=key.length-1; x<key.length+len-1; x++){
                    for(int y=key.length-1; y<key.length+len-1; y++){
                        if(lock[x][y]!=1){
                            check = false;
                            break;
                        }
                    }
                }
                
                if(check){
                    return true;
                }
                
                for(int x=0; x<key.length; x++){
                    for(int y=0; y<key.length; y++){
                        lock[i+x][j+y] -= key[x][y];
                    }
                }
                
            }
        }
        return false;
    }
    
    public void rotate(int[][] key){
        int[][] temp = new int[key.length][key.length];
        for(int i=0; i<key.length; i++){
            for(int j=0; j<key.length; j++){
                temp[i][j] = key[j][key.length-i-1];
            }
        }
        
        for(int i=0; i<key.length; i++){
            for(int j=0; j<key.length; j++){
                key[i][j] = temp[i][j];
            }
        }
    }
}
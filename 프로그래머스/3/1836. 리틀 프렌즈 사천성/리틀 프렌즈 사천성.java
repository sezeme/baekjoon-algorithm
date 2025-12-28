import java.util.*;

class Solution {
    char[][] board;
    int m, n;
    LinkedList<Character> list = new LinkedList<Character>();
    HashMap<Character, int[][]> map = new HashMap<>();
    public String solution(int m, int n, String[] board) {
        String answer = "";
        this.board = new char[m][n];
        this.m = m;
        this.n = n;
        
        //*:42, .:46
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                char c = board[i].charAt(j);
                this.board[i][j] = c;
                if(c != '.' && c != '*'){
                    if(!list.contains(c)){
                        list.add(c);
                        map.put(c, new int[2][2]);
                        map.get(c)[0][0] = i;
                        map.get(c)[0][1] = j;
                    }
                    else{
                        map.get(c)[1][0] = i;
                        map.get(c)[1][1] = j;
                    }
                }
            }
        }
        
        Collections.sort(list);
        
        int idx = 0;
        while(list.size() != 0){
            if(canDelete(list.get(idx))){
                char popped = list.remove(idx);
                answer += popped;
                deleteChar(popped);
                idx = 0;
            } 
            else{
                idx++;
                if(idx == list.size()){
                    return "IMPOSSIBLE";
                }       
            }
        }
        
        return answer;
    }
    
    void deleteChar(char a){
        board[map.get(a)[0][0]][map.get(a)[0][1]] = '.';
        board[map.get(a)[1][0]][map.get(a)[1][1]] = '.';
    }
    
    boolean canDelete(char a){
        int r1 = map.get(a)[0][0];
        int c1 = map.get(a)[0][1];
        int r2 = map.get(a)[1][0];
        int c2 = map.get(a)[1][1];
        
        if(c1 < c2){
            if(linearColumnCheck(c1, c2, r1, a) && linearRowCheck(r1, r2, c2, a)){
                return true;
            }
            if(linearRowCheck(r1, r2, c1, a) && linearColumnCheck(c1, c2, r2, a)){
                return true;
                }
        }else{
            if(linearRowCheck(r1, r2, c2, a) && linearColumnCheck(c2, c1, r1, a)){
                return true;
            }
            if(linearColumnCheck(c2, c1, r2, a) && linearRowCheck(r1, r2, c1, a)){
                return true;
            }
        }
        
        return false;
    }
    
    boolean linearRowCheck(int r1, int r2, int c, char a){
        for(int i = r1; i < r2+1; i++){
            if(board[i][c] != '.' && board[i][c] != a)
                return false;
        }
        return true;
    }
    
    boolean linearColumnCheck(int c1, int c2, int r, char a){
        for(int i = c1; i < c2+1; i++){
            if(board[r][i] != '.' && board[r][i] != a)
                return false;
        }
        return true;
    }
}
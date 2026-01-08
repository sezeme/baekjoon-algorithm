import java.util.*;

class Solution {
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        List<int[][]> list = find(table,POINT);
        boolean[] used = new boolean[list.size()];
        List<int[][]> emptys = find(game_board,EMPTY);
        for(int[][] empty : emptys){
            for(int i = 0 ; i < list.size() ; i++){
                if(used[i]){
                    continue;
                }
                boolean flag = false;
                int[][] temp = list.get(i);
                for(int j = 0 ; j < 4 ; j++){
                    if(matchArray(empty,temp)){
                        used[i] = true;
                        answer += getSize(temp);
                        flag = true;
                        break;
                    }
                    temp = rotate(temp);
                }
                if(flag){
                    break;
                }
            }
        }
        return answer;
    }
    private static int getSize(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(arr[i][j] == POINT){
                    result++;
                }
            }
        }
        return result;
    }
    private static boolean matchArray(int[][] empty , int[][] arr){
        if(empty.length != arr.length){
            return false;
        }
        if(empty[0].length != arr[0].length){
            return false;
        }
        int n = empty.length;
        int m = empty[0].length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(empty[i][j] + arr[i][j] != 1){
                    return false;
                }
            }
        }
        return true;
    }
    
    private static final int EMPTY = 0;
    private static final int POINT = 1;
    
    private static List<int[][]> find(int[][] table,int num){
        List<int[][]> list = new LinkedList<>();
        int n = table.length;
        int m = table[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(table[i][j] == num && !visited[i][j]){
                    int[][] puzzle = findPuzzle(i,j,num,visited,table,n,m);
                    list.add(puzzle);
                }
            }
        }
        return list;
    }
    private static int[][] rotate(int[][] puzzle){
        int n = puzzle.length;
        int m = puzzle[0].length;
        int[][] result= new int[m][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                result[j][n-i-1] = puzzle[i][j];
            }
        }
        return result;
    }
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    
    private static int[][] findPuzzle(int y,int x,int num,boolean[][] visited,int[][] table,int n, int m){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {y,x});
        visited[y][x] = true;
        int miny = y;
        int maxy = y;
        int minx = x;
        int maxx = x;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0 ; i < 4 ; i++){
                int ny = now[0] + DY[i];
                int nx = now[1] + DX[i];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[ny][nx] && table[ny][nx] == num){
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny,nx});
                    miny = Math.min(ny,miny);
                    maxy = Math.max(ny,maxy);
                    minx = Math.min(nx,minx);
                    maxx = Math.max(nx,maxx);
                }
            }
        }
        int[][] result = new int[maxy - miny+1][maxx - minx+1];
        for(int i = 0 ; i <= maxy - miny; i++){
            for(int j = 0 ; j <= maxx - minx; j++){
                result[i][j] = table[miny + i][minx + j];
            }
        }
        return result;
    }
}
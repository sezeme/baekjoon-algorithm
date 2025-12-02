// 좌표 2차원배열 최솟값 구하기 ! [".#...", "..#..", "...#."] --> 배열의 Index는 x좌표고 y좌표는 #의 위치..
// x 0 ~ 3 이고, y좌표는 1~4 까지 있으니  0,1 ~ 3,4 --> (x2 - x1)+(y2 - y1)
class Solution {
    public int[] solution(String[] wallpaper) {

        int minX = wallpaper.length; //x좌표 최소
        int maxX = 0;// x좌표 최대
        int minY = wallpaper[0].length(); //y좌표 최소
        int maxY = 0; // y좌표 최대

        for(int i=0; i < wallpaper.length; i++){
            if(wallpaper[i].contains("#")){
               if(minX > i) minX = i;
               if(maxX < i) maxX = i;
            }
            for(int j=0; j < wallpaper[i].length(); j++ ){
             if(wallpaper[i].charAt(j)=='#'){
               if(minY > j) minY =j;
               if(maxY < j) maxY = j;
            } 
            }
        }

        int[] answer = {minX,minY,maxX+1,maxY+1};

        return answer;
    }
}
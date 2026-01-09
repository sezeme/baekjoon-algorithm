class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zero = 0;
        int count = 0;
        int l = 0;
        while(!s.equals("1")){
            zero++;
            l=0;
            for(int i=0; i<s.length();i++){
                if(s.charAt(i) == '0'){
                  count++;  
                } else{
                  l++;
                }
            }         
            
            s= Integer.toBinaryString(l);
            
        }
        answer[0] = zero;
        answer[1] = count;
        return answer;
    }
}
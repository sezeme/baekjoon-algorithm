import java.util.*;

class Solution {
    class Task{
        int progress, speed;
        Task(int p, int s) {
            this.progress = p;
            this.speed = s;
        }
    }
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new LinkedList<>();
        Queue<Task> q = new ArrayDeque<>();
        for(int i = 0; i < progresses.length; i++) {
            q.add(new Task(progresses[i], speeds[i]));
        }
        
        int time = 0;
        while(!q.isEmpty()) {
            time++;
            int count = 0;
            Task task = q.peek();
            while(100 <= (task.progress + task.speed * time)) {
                q.poll();
                count++;
                
                if(q.isEmpty()) break;
                
                task = q.peek();
            }
            if(count != 0) {
                answer.add(count);
            }
        }
        return answer;
    }
}
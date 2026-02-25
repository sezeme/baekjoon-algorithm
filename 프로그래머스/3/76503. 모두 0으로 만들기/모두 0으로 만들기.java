import java.util.*;

class Solution {
    public long solution(int[] a, int[][] edges) {

        // 모든 간선의 가중치 값의 합이 0이 아닌 경우
        if(Arrays.stream(a).sum() !=0) return -1;

        long answer = 0;
        int[] indegree = new int[a.length]; // 진입차수 배열
        boolean[] visited = new boolean[a.length]; // 방문 여부
        long[] temp = new long[a.length]; // a를 long으로 변환하기 위한 배열
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // a를 long 배열로 변환
        for(int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }

        // a 의 길이만큼 graph에 추가
        for(int i = 0; i < a.length; i++) {
            graph.add(new ArrayList<>());
        }

        // graph에 간선 셋팅 && 진입차수 셋팅
        for(int i = 0; i < edges.length; i++) {
            int nodeA = edges[i][0];
            int nodeB = edges[i][1];

            graph.get(nodeA).add(nodeB);
            graph.get(nodeB).add(nodeA);

            indegree[nodeA]++;
            indegree[nodeB]++;
        }

        // 진입 차수가 1인 경우
        // 진입차수가 1인 경우 연결된 노드가 1개로
        // 노드는 반드시 연결된 단하나의 노드에 모든 가중치를 넘겨줘야함
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 1) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int now = q.poll();
            visited[now] = true;

            ArrayList<Integer> nodes = graph.get(now);
            for(int i = 0 ; i < nodes.size(); i++) {
                int curr = nodes.get(i);
                if(visited[curr]) continue;
                indegree[curr]--;
                temp[curr] += temp[now];
                answer += Math.abs(temp[now]);
                temp[now] = 0;

                if(indegree[curr] == 1) {
                    q.offer(curr);
                }
            }
        }

        // temp는 간선들의 가중치 값 배열로 전부 0이 아니라면 불가능
        for(int i = 0; i < temp.length; i++) {
            if(temp[i] != 0) {
                answer = -1;
                break;

            }
        }
        return answer;
    }
}
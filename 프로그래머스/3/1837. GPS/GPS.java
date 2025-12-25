import java.util.*;

class Solution {

    Map<Integer, List<Integer>> adjLis = new HashMap<>();
    boolean[][][] visit = new boolean[200][300][200];

    int n, m, k;
    int[] gpsLog;

    class Node implements Comparable<Node>{

        public int v;
        public int errorCnt;
        public int t;
        public int preNode;

        public Node(int v, int errorCnt, int t) {
            this.v = v;
            this.errorCnt = errorCnt;
            this.t = t;
        }

        public Node(int v, int errorCnt, int t, int preNode) {
            this(v, errorCnt, t);
            this.preNode = preNode;
        }

        @Override
        public int compareTo(Node node) {

            if(this.errorCnt == node.errorCnt) {
                return Integer.compare(this.t, node.t);
            }

            return Integer.compare(this.errorCnt, node.errorCnt);
        }
    }

    void init(int[][] edge_list) {
        for(int[] edge : edge_list) {
            for(int v : edge) {
                if(!adjLis.containsKey(v)) {
                    adjLis.put(v, new ArrayList<>());
                }
            }   
            int u = edge[0];
            int v = edge[1];

            adjLis.get(u).add(v);
            adjLis.get(v).add(u);
        }

        // 인접 리스트의 다음 리스트에 자기 자신을 넣음 
        for(var entry : adjLis.entrySet()) {
            entry.getValue().add(entry.getKey());
        }
    }

    int bfs() {

        Queue<Node> que = new PriorityQueue<>();

        int startV = gpsLog[0];
        Node startNode = new Node(startV, 0, 0);
        visit[0][startV][0] = true;

        que.offer(startNode);

        int goalTime = this.k - 1; // code에서 time은 0부터 시작해서 -1 함 
        int endV = gpsLog[gpsLog.length - 1];

        while(!que.isEmpty()) {

            Node currNode = que.poll();

            int nextTime = currNode.t + 1;

            int nextGpsV = gpsLog[nextTime];

            for(int nextV : adjLis.get(currNode.v)) {

                int nextErrorCnt = nextV == nextGpsV ? currNode.errorCnt : currNode.errorCnt + 1;

                if(nextTime == goalTime && nextV == endV) {
                    return currNode.errorCnt;
                }

                if(visit[nextErrorCnt][nextV][nextTime] || nextTime >= goalTime) {
                    continue;
                }
                visit[nextErrorCnt][nextV][nextTime] = true;

                Node nextNode = new Node(nextV, nextErrorCnt, nextTime);

                que.offer(nextNode);
            }            
        }


        return -1;
    }

    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int answer = 0;

        this.n = n;
        this.m = m;
        this.k = k;
        this.gpsLog = gps_log;

        init(edge_list);

        answer = bfs();

        return answer;
    }
}
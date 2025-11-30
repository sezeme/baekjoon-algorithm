import java.util.*;
class Solution {
    static ArrayList<Integer>[] graph; // 그래프를 인접 리스트로 저장
    static int [] answer; // 최종 결과를 저장할 배열
    static int [] min; // 목적지로부터 각 정점까지의 최단 거리를 저장할 배열

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 그래프 초기화
        graph = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        answer = new int [sources.length];
        
        // 양방향 그래프 생성
        for(int i = 0; i < roads.length; i++){
            graph[roads[i][0]].add(roads[i][1]);
            graph[roads[i][1]].add(roads[i][0]);
        }

        // 최단 거리 배열 초기화
        min = new int [n+1];
        Arrays.fill(min, Integer.MAX_VALUE); // 모든 거리를 무한대로 설정
        dijkstra(destination); // 목적지에서 다익스트라 알고리즘 실행

        // 결과 계산
        for(int i = 0; i < sources.length; i++){
            if(min[sources[i]] == Integer.MAX_VALUE){
                answer[i] = -1; // 도달할 수 없는 경우
            } else {
                answer[i] = min[sources[i]]; // 최단 거리 값 반환
            }
        }

        return answer;
    }

    public static void dijkstra(int start){ // 목적지에서 출발하는 다익스트라
        PriorityQueue<int []> q = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]); // 거리 기준 우선순위 큐
        min[start] = 0; // 목적지까지의 거리는 0
        q.add(new int [] {start, 0});

        while(!q.isEmpty()){
            int[] cur = q.poll(); // 현재 정점과 거리
            if(min[cur[0]] != cur[1]) continue; // 이미 더 짧은 경로가 있으면 패스
            for(int i = 0; i < graph[cur[0]].size(); i++){
                int next = graph[cur[0]].get(i);
                if(min[next] > cur[1] + 1){ // 더 짧은 경로를 발견한 경우
                    min[next] = cur[1] + 1;
                    q.add(new int [] {next, cur[1] + 1}); // 다음 정점으로 이동
                }
            }
        }
    }
}

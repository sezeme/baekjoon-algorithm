import java.util.*;

class Solution {
    Map<Integer,List<Integer>> nodeToEdges;

    public int[] solution(int[] nodes, int[][] edges) {
        int[] answer = new int[2];

        nodeToEdges = new HashMap<>();
        for(int node : nodes){
            nodeToEdges.put(node,new ArrayList<>());
        }

        for(int[] edge : edges){
            nodeToEdges.get(edge[0]).add(edge[1]);
            nodeToEdges.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visitedNode = new HashSet<>();
        for(int node : nodes){
            if(visitedNode.contains(node)) continue;

            int sameCount = 0;
            int diffCount = 0;

            Queue<Integer> q = new ArrayDeque<>();
            q.offer(node);
            visitedNode.add(node);

            while(!q.isEmpty()){
                Integer current = q.poll();

                if(current%2==nodeToEdges.get(current).size()%2) sameCount++;
                else diffCount++;

                for(Integer next : nodeToEdges.get(current)){
                    if(visitedNode.contains(next)) continue;

                    q.offer(next);
                    visitedNode.add(next);
                }
            }

            if(sameCount==1) answer[0]++;
            if(diffCount==1) answer[1]++;
        }

        return answer;
    }
}
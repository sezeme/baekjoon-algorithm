import java.util.*;

// https://tech.kakao.com/2022/07/13/2022-coding-test-summer-internship/
public class Solution {
    private static List<List<Node>> graph;

    private static class Node {
        int e, w; // 노드, 가중치

        Node(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }

    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            int s = path[0];
            int e = path[1];
            int w = path[2];

            // 출입구일 경우 다른 곳으로만 갈 수 있는 단방향
            // 산봉우리일 경우 특정 한 곳에서 산봉우리로 가는 단방향
            if (isGate(s, gates) || isSummit(e, summits)) {
                graph.get(s).add(new Node(e, w));
            } else if (isGate(e, gates) || isSummit(s, summits)) {
                graph.get(e).add(new Node(s, w));
            } else {
                // 일반 등산로일 경우 양방향
                graph.get(s).add(new Node(e, w));
                graph.get(e).add(new Node(s, w));
            }
        }

        // 정상까지 갔을 때 최소이면 돌아올 때도 같은 경로를 선택하면 되므로
        // 정상까지 가는 경우만 고려
        return dijkstra(n, gates, summits);
    }

    private static int[] dijkstra(int n, int[] gates, int[] summits) {
        Queue<Node> qu = new LinkedList<>();
        int[] intensity = new int[n + 1];

        Arrays.fill(intensity, Integer.MAX_VALUE);

        // 출입구 전부를 큐에 넣음
        for (int gate : gates) {
            qu.add(new Node(gate, 0));
            intensity[gate] = 0; // 시작 지점은 0
        }

        while (!qu.isEmpty()) {
            Node cn = qu.poll();

            // 현재의 가중치가 저장된 가중치보다 커서 최소 갱신이 되지 않을 때 스킵
            if(cn.w > intensity[cn.e]) continue;

            for (int i = 0; i < graph.get(cn.e).size(); i++) {
                Node nn = graph.get(cn.e).get(i);

                // 최소 갱신
                int dis = Math.max(intensity[cn.e], nn.w);
                if (intensity[nn.e] > dis) {
                    intensity[nn.e] = dis;
                    qu.add(new Node(nn.e, dis));
                }
            }
        }

        int mn = Integer.MAX_VALUE; // 산봉우리 번호
        int mw = Integer.MAX_VALUE; // 최솟값

        // 정렬하지 않으면 12, 14, 15, 16, 17, 25번 문제 실패
        Arrays.sort(summits);

        for (int summit : summits) {
            if (intensity[summit] < mw) {
                mn = summit;
                mw = intensity[summit];
            }
        }

        return new int[]{mn, mw};
    }

    // num이 입구인지 확인
    private static boolean isGate(int num, int[] gates) {
        for (int gate : gates) {
            if (num == gate) return true;
        }
        return false;
    }

    // num이 산봉우리인지 확인
    private static boolean isSummit(int num, int[] submits) {
        for (int submit : submits) {
            if (num == submit) return true;
        }
        return false;
    }
}
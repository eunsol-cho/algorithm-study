package week19;

import java.util.*;

public class 합승택시요금 {
    public static void main(String[] args) {
        Solution_합승택시요금 solution_합승택시요금 = new Solution_합승택시요금();
        int e = solution_합승택시요금.solution(6, 4, 6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}});
        System.out.println(e);
    }
}

class Solution_합승택시요금 {
    static Map<Integer, List<Node>> adj;
    static List<Node> l;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        // 인접행렬 생성
        adj = new HashMap<>();
        for (int[] f : fares) {
            l = adj.getOrDefault(f[0], new ArrayList<Node>());
            l.add(new Node(f[1], f[2]));
            adj.put(f[0], l);
            // 역방향
            l = adj.getOrDefault(f[1], new ArrayList<Node>());
            l.add(new Node(f[0], f[2]));
            adj.put(f[1], l);
        }

        // dijkstra - 각자 or 같이
        int[] aCost = dijkstra(a, n);
        int[] bCost = dijkstra(b, n);
        int[] cost = dijkstra(s, n);

        for(int i = 1; i <= n ; i ++) answer = Math.min(answer, aCost[i] + bCost[i] + cost[i]);
        return answer;
    }

    private int[] dijkstra(int snode, int n) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(snode, 0));
        int[] cost = new int[n+1];
        Arrays.fill(cost, 20000001);
        cost[snode] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if(cur.fare > cost[cur.node]) continue;

            for(Node e : adj.getOrDefault(cur.node, new ArrayList<Node>())) {
                int c = cost[cur.node] + e.fare;
                if (cost[e.node] > c) {
                    cost[e.node] = c;
                    q.add(new Node(e.node, c));
                }
            }
        }

        return cost;
    }
}

class Node implements Comparable<Node> {
    int node;
    int fare;

    public Node(int node, int fare) {
        this.node = node;
        this.fare = fare;
    }

    @Override
    public int compareTo(Node o) {
        return fare - o.fare;
    }

}

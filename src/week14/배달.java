package week14;

import java.util.*;

public class 배달 {
    public static void main(String[] args) {
        Solution_배달 solution_배달 = new Solution_배달();
        int e = solution_배달.solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3);
        System.out.println(e);
    }
}


class Solution_배달 {

    static Map<Integer, List<Node>> adj;

    public int solution(int N, int[][] road, int K) {
        // 인접리스트 생성
        adj = new HashMap<>();
        for (int i = 0; i < road.length; i++) {
            int nodeA = road[i][0];
            int nodeB = road[i][1];
            int time = road[i][2];

            // 양방향
            setAdj(nodeA, nodeB, time);
            setAdj(nodeB, nodeA, time);
        }

        // 도달여부 파악
        int answer = 0;
        int[] distance = getDistance(N, K);
        for (int i = 1; i <= N; i++) {
            if (distance[i] <= K) {
                answer++;
            }
        }
        return answer;
    }

    private void setAdj(int nodeA, int nodeB, int time) {
        List<Node> nodes = adj.getOrDefault(nodeA, new ArrayList<>());
        nodes.add(new Node(nodeB, time));
        adj.put(nodeA, nodes);
    }

    private int[] getDistance(int N, int k) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        int[] visit = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            visit[i] = 500001;
        }
        q.add(new Node(1, 0));
        visit[1] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.time >= k) continue;

            for (Node node : adj.getOrDefault(cur.num, new ArrayList<>())) {
                int time = cur.time + node.time;
                if (time < visit[node.num]) {
                    visit[node.num] = time;
                    q.add(new Node(node.num, time));
                }
            }

        }

        return visit;
    }
}

class Node implements Comparable<Node> {
    int num;
    int time;

    public Node(int num, int time) {
        this.num = num;
        this.time = time;
    }

    @Override
    public int compareTo(Node o) {
        return time - o.time;
    }
}
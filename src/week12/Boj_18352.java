package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_18352 {

    static int N, M, K, X;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = line[0];
        M = line[1];
        K = line[2];
        X = line[3];

        Map<Integer, ArrayList<Integer>> edge = new HashMap<>();
        ArrayList<Integer> l;
        for (int i = 0; i < M; i++) {
            int[] e = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            l = edge.getOrDefault(e[0], new ArrayList<>());
            l.add(e[1]);
            edge.put(e[0], l);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        // dijkstra
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] visit = new boolean[N+1];
        q.add(new Node(X, 0));
        visit[X] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.dis >= K) {
                if (cur.dis == K) answer.add(cur.num);
                continue;
            }

            for (int e : edge.getOrDefault(cur.num, new ArrayList<>())) {
                if (!visit[e]) {
                    visit[e] = true;
                    q.add(new Node(e, cur.dis + 1));
                }
            }
        }

        // print
        if (answer.size() == 0) System.out.println(-1);
        else answer.stream().sorted().forEach(System.out::println);
    }
}

class Node implements Comparable<Node> {
    int num;
    int dis;

    public Node(int num, int dis) {
        this.num = num;
        this.dis = dis;
    }

    @Override
    public int compareTo(Node o) {
        return dis - o.dis;
    }
}



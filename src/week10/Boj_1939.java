package week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1939 {
    static Map<Integer, ArrayList<Destination>> map = new HashMap<>();
    static int N, M, start, end, max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            int s = Integer.parseInt(line[0]);
            int e = Integer.parseInt(line[1]);
            int d = Integer.parseInt(line[2]);

            ArrayList<Destination> l = map.getOrDefault(s, new ArrayList<>());
            l.add(new Destination(e, d));
            max = Math.max(max, d);
        }

        line = br.readLine().split(" ");
        start = Integer.parseInt(line[0]);
        end = Integer.parseInt(line[1]);

        int left = 0;
        int right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (bfs(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);

    }

    static boolean bfs(int mid) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        boolean[] visit = new boolean[N + 1];
        visit[start] = true;

        while (!q.isEmpty()) {
            Integer cur = q.poll();

            if (cur == end) {
                return true;
            }

            for (Destination e : map.getOrDefault(cur, new ArrayList<>())) {
                if (!visit[e.island] && e.distance >= mid) {
                    visit[e.island] = true;
                    q.add(e.island);
                }
            }
        }

        return false;
    }

}

class Destination {
    int island;
    int distance;

    public Destination(int island, int distance) {
        this.island = island;
        this.distance = distance;
    }
}
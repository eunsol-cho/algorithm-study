package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_11403 {
    static int N;
    static int[][] ans;
    static Map<Integer, ArrayList<Integer>> edge = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ans = new int[N][N];

        ArrayList<Integer> t;
        for (int i = 0; i < N; i++) {
            ans[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N; j++) {
                if (ans[i][j] == 1) {
                    t = edge.getOrDefault(i, new ArrayList<>());
                    t.add(j);
                    edge.put(i, t);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (ans[i][j] == 1) {
                    sb.append(ans[i][j] + " ");
                    continue;
                }
                // bfs
                ans[i][j] = isPossible(i, j);
                sb.append(ans[i][j] + " ");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

    static int isPossible(int from, int to) {

        Queue<Integer> q = new ArrayDeque<>();
        q.add(from);
        boolean[] visit = new boolean[N];

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int e : edge.getOrDefault(cur, new ArrayList<>())) {
                if (e == to) {
                    return 1;
                }
                if (!visit[e]) {
                    visit[e] = true;
                    q.add(e);
                }
            }
        }

        return 0;
    }
}

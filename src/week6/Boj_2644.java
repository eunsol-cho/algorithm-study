package week6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Boj_2644 {
    static int N, M, answer;
    static int[] target;
    static boolean[] visit;
    static Map<Integer, ArrayList<Integer>> map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = Integer.parseInt(br.readLine());

        // 부모 자식
        map = new HashMap();
        for (int i=0; i<M; i++) {
            int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ArrayList<Integer> children = map.getOrDefault(xy[0], new ArrayList<>());
            children.add(xy[1]);
            map.put(xy[0],children);

            ArrayList<Integer> parents = map.getOrDefault(xy[1], new ArrayList<>());
            parents.add(xy[0]);
            map.put(xy[1],parents);
        }

        answer = -1;
        visit = new boolean[N];
        dfs(target[0], 0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int idx, int cnt) {
        visit[idx-1] = true;

        for (int e : map.get(idx)) {
            if (!visit[e-1]) {
                if (e == target[1]) {
                    answer = cnt + 1;
                    return;
                }
                dfs(e, cnt+1);
            }
        }
    }
}
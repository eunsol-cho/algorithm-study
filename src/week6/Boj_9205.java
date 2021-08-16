package week6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Boj_9205 {
    static int T, N, beer;
    static String answer;
    static int[] home, festival;
    static boolean[] visit;
    static ArrayList<int[]> store = new ArrayList<>();
    static Queue<int[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            // 초기화
            N = Integer.parseInt(br.readLine());
            answer = "sad";
            beer = 20;
            store.clear();
            visit = new boolean[N+1];

            // 입력
            home = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N+1; j++) {
                store.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
            }
            festival = store.get(N);

            // bfs
            q.add(home);
            visit[0] = true;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                // 도착
                if (cur[0] == festival[0] && cur[1] == festival[1]) {
                    answer = "happy";
                    break;
                }

                for (int j=0; j<N+1; j++) {
                    if (!visit[j] && getDistance(cur, store.get(j)) <= 1000) {
                        q.add(store.get(j));
                        visit[j] = true;
                    }
                }
            }

            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
    }

    static int getDistance(int[] from, int[] to){
        return Math.abs(from[0]-to[0]) + Math.abs(from[1]-to[1]);
    }
}
package week8;

import java.io.*;
import java.util.*;

public class Boj_14442 {

    static int N, M, K;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cmd = br.readLine().split(" ");
        N = Integer.parseInt(cmd[0]);
        M = Integer.parseInt(cmd[1]);
        K = Integer.parseInt(cmd[2]);

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = line[j] - '0';
            }
        }

        int answer = -1;
        boolean[][][] visit = new boolean[N][M][K+1];
        Queue<Dot> q = new ArrayDeque<>();
        q.add(new Dot(0, 0, 1, 0));
        visit[0][0][0] = true;

        while (!q.isEmpty()) {
            Dot cur = q.poll();

            // 도착
            if (cur.x == N-1 && cur.y == M-1) {
                answer = cur.d;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int tx = cur.x + dx[i];
                int ty = cur.y + dy[i];
                if (isRange(tx, ty)) {
                    // 벽아님
                    if (map[tx][ty] == 0 && !visit[tx][ty][cur.cnt]) {
                        visit[tx][ty][cur.cnt] = true;
                        q.add(new Dot(tx, ty, cur.d + 1, cur.cnt));

                    // 벽을 부순다.
                    } else if (map[tx][ty] == 1 && cur.cnt + 1 <= K && !visit[tx][ty][cur.cnt + 1]) {
                        visit[tx][ty][cur.cnt + 1] = true;
                        q.add(new Dot(tx, ty, cur.d + 1, cur.cnt + 1));
                    }
                }
            }
        }

        System.out.println(answer);

    }

    static boolean isRange(int x, int y) {
        return (x<0 || y<0 || x>=N || y>=M) ? false : true;
    }
}

class Dot {
    int x;
    int y;
    int d;
    int cnt;

    public Dot(int x, int y, int d, int cnt) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.cnt = cnt;
    }
}

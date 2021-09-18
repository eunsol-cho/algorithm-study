package week8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2206 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cmd = br.readLine().split(" ");
        N = Integer.parseInt(cmd[0]);
        M = Integer.parseInt(cmd[1]);

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = line[j] - '0';
            }
        }

        boolean[][][] visit = new boolean[N][M][2];
        Queue<XY> q = new ArrayDeque<>();
        q.add(new XY(0, 0, 1, 0));
        visit[0][0][0] = true;

        int answer = -1;
        while (!q.isEmpty()) {
            XY cur = q.poll();

            // 도착
            if (cur.x == N-1 && cur.y == M-1) {
                answer = cur.d;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int tx = cur.x + dx[i];
                int ty = cur.y + dy[i];
                if(isRange(tx, ty)) {
                    // 벽
                    if (map[tx][ty] == 1 && cur.cnt == 0) {
                        if (!visit[tx][ty][1]) {
                            visit[tx][ty][1] = true;
                            q.add(new XY(tx, ty, cur.d+1, cur.cnt+1));
                        }

                    }
                    // 벽 아님. 이동
                    else if (map[tx][ty] == 0) {
                        if (!visit[tx][ty][cur.cnt]) {
                            visit[tx][ty][cur.cnt] = true;
                            q.add(new XY(tx, ty, cur.d+1, cur.cnt));
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static boolean isRange(int x, int y){
        return (x < 0 || y < 0 || x >= N || y >= M) ? false : true;
    }
}

/*class XY {
    int x;
    int y;
    int d;
    int cnt;

    public XY(int x, int y, int d, int cnt) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.cnt = cnt;
    }
}*/
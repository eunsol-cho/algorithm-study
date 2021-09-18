package week8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Boj_16933 {
    static int N, M, K;
    static int[][] map;
    static boolean[][][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] cmd = br.readLine().split(" ");
        N = Integer.parseInt(cmd[0]);
        M = Integer.parseInt(cmd[1]);
        K = Integer.parseInt(cmd[2]);

        map = new int[N][M];
        visit = new boolean[N][M][K + 1];
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = line[j] - '0';
            }
        }

        int answer = -1;
        Queue<XY> q = new ArrayDeque();
        q.add(new XY(0, 0, 1, 0));
        visit[0][0][0] = true;

        while (!q.isEmpty()) {
            XY cur = q.poll();

            if (cur.x == N-1 && cur.y == M-1) {
                answer = cur.d;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int tx = cur.x + dx[i];
                int ty = cur.y + dy[i];

                if (isRange(tx, ty)) {
                    if (map[tx][ty] == 0 && !visit[tx][ty][cur.cnt]) {
                        visit[tx][ty][cur.cnt] = true;
                        q.add(new XY(tx, ty, cur.d + 1, cur.cnt));
                    } else if (map[tx][ty] == 1) {
                        // 낮
                        if (cur.d % 2 > 0) {
                            if (cur.cnt < K && !visit[tx][ty][cur.cnt + 1]) {
                                visit[tx][ty][cur.cnt + 1] = true;
                                q.add(new XY(tx, ty, cur.d + 1, cur.cnt + 1));
                            }
                        } else {
                            q.add(new XY(cur.x, cur.y, cur.d + 1, cur.cnt));
                        }

                    }
                }

            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    static boolean isRange(int x, int y) {
        return (x<0 || y<0 || x>=N || y>=M) ? false : true;
    }
}

class XY {
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
}
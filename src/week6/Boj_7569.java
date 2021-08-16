package week6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7569 {
    static int M, N, H;
    static int[][][] box;
    static boolean[][][] visit;
    static Queue<XYZ> q = new ArrayDeque<>();
    static int[] dx = {0, -1, 0, 1, 0, 0};
    static int[] dy = {-1, 0, 1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int cnt = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        visit = new boolean[H][N][M];
        for (int i=0; i<H; i++) {
            for (int j = 0; j < N; j++) {
                String[] line = br.readLine().split(" ");
                for (int k = 0; k < M; k++) {
                    int e = Integer.parseInt(line[k]);
                    box[i][j][k] = e;
                    if (e == 1) {
                        q.add(new XYZ(k, j, i, 0));
                        visit[i][j][k] = true;
                    }
                    else if (e == 0) {
                        cnt++;
                    }
                }
            }
        }

        int answer = 0;
        while (!q.isEmpty()) {
            XYZ cur = q.poll();
            visit[cur.z][cur.y][cur.x] = true;

            for (int i = 0; i < 6; i++) {
                int tx = cur.x + dx[i];
                int ty = cur.y + dy[i];
                int tz = cur.z + dz[i];

                if (tx >= 0 && ty >= 0 && tz >= 0 && tx < M && ty < N && tz < H) {
                    if(!visit[tz][ty][tx] && box[tz][ty][tx] == 0) {
                        visit[tz][ty][tx] = true;
                        q.add(new XYZ(tx, ty, tz, cur.d + 1));
                        answer = Math.max(answer, cur.d + 1);
                        cnt--;
                    }
                }
            }
        }

        // 모두다 익지 못한경우
        if (cnt != 0) {
            answer = -1;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

}

class XYZ {
    int x;
    int y;
    int z;
    int d;

    public XYZ(int x, int y, int z, int d) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.d = d;
    }
}
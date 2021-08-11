package week5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_2589 {

    static int r, c;
    static int[][] map;
    static boolean[][] v;
    static int[] dx = {0, 0, -1, +1};
    static int[] dy = {-1, +1, 0, 0};
    static Queue<Dot> q = new LinkedList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split(" ");
        r = Integer.parseInt(arr[0]);
        c = Integer.parseInt(arr[1]);

        map = new int[r][c];
        v = new boolean[r][c];
        Queue<Dot> l = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 1; j <= c; j++) {
                String e = line.substring(j-1, j);
                if ("L".equals(e)) {
                    map[i][j-1] = 1;
                    l.add(new Dot(i, j-1, 0));
                } else {
                    map[i][j-1] = 0;
                }
            }
        }

        int answer = 0;
        while (!l.isEmpty()) {
            answer = Math.max(answer, bfs(l.poll()));
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }

    private static int bfs(Dot sDot){

        int result = 0;
        q.add(sDot);

        while (!q.isEmpty()) {
            Dot dot = q.poll();
            v[dot.x][dot.y] = true;
            for (int i = 0; i < 4; i++) {
                int tx = dot.x + dx[i];
                int ty = dot.y + dy[i];
                if (valid(tx, ty) && map[tx][ty] == 1 && !v[tx][ty]) {
                    int td = dot.d + 1;
                    result = Math.max(td, result);
                    q.add(new Dot(tx, ty, td));
                    v[tx][ty] = true; // 메모리 초과 원인 - 큐에 중복으로 저장되는것을 막음
                }
            }
        }

        // 방문행렬 초기화
        for (boolean[] e : v) {
            Arrays.fill(e, false);
        }

        return result;
    }

    private static boolean valid(int tx, int ty) {
        return tx >= 0 && tx < r && ty >= 0 && ty < c;
    }
}

class Dot {
    int x;
    int y;
    int d;

    public Dot(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

package week8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_14502 {
    static int N, M , answer;
    static int[][] map;
    static ArrayList<Cell> virus = new ArrayList<>();
    static LinkedList<Cell> candi = new LinkedList<>();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cmd = br.readLine().split(" ");
        N = Integer.parseInt(cmd[0]);
        M = Integer.parseInt(cmd[1]);
        answer = 0;

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                if (map[i][j] == 2) {
                    virus.add(new Cell(i, j));
                } else if (map[i][j] == 0) {
                    candi.add(new Cell(i, j));
                }
            }
        }

        // 벽3개 뽑기
        dfs(0, new LinkedList<Integer>());

        System.out.println(answer);
    }

    static void dfs(int idx, LinkedList<Integer> l) {
        if (l.size() == 3) {
            answer = Math.max(answer, bfs(l));
            return;
        }

        for (int i = idx; i < candi.size(); i++) {
            if (l.contains(i)) continue;
            l.add(i);
            dfs(i, l);
            l.removeLast();
        }
    }

    static int bfs(LinkedList<Integer> l) {
        int result = candi.size();

        Queue<Cell> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][M];
        for (Cell e : virus) {
            q.add(e);
            visit[e.x][e.y] = true;
        }
        for (int e : l) {
            Cell cell = candi.get(e);
            visit[cell.x][cell.y] = true;
            result--;
        }

        while (!q.isEmpty()) {
            Cell cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int tx = cur.x + dx[i];
                int ty = cur.y + dy[i];

                if (isRange(tx, ty)) {
                    if (map[tx][ty] == 0 && !visit[tx][ty]) {
                        result--;
                        q.add(new Cell(tx, ty));
                        visit[tx][ty] = true;
                    }
                }
            }
        }

        return result;
    }

    static boolean isRange(int x, int y) {
        return (x<0 || y<0 || x>=N || y>=M) ? false : true;
    }
}

class Cell {
    int x;
    int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
package week8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_16946 {
    static int N, M;
    static int[][] map;
    static int[][] answer;
    static int[][] visit;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static ArrayList<XY_> walls = new ArrayList<>();
    static Map<Integer, Integer> cnt = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cmd = br.readLine().split(" ");
        N = Integer.parseInt(cmd[0]);
        M = Integer.parseInt(cmd[1]);

        map = new int[N][M];
        answer = new int[N][M];
        // 입력
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = line[j] - '0';
                if (map[i][j] == 1) {
                    // 벽
                    walls.add(new XY_(i, j));
                }
            }
        }


        int idx = 1;
        visit = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 인접한 0의 개수 카운트
                if (map[i][j] == 0 && visit[i][j] == 0) {
                    int zero = bfs(i, j, idx);
                    cnt.put(idx, zero);
                    idx++;
                }
            }
        }

        // 벽에 인접한 0 집계의 합
        for (XY_ xy : walls) {
            Set<Integer> idxes = new HashSet<>();
            for (int i = 0; i < 4; i++) {
                int tx = xy.x + dx[i];
                int ty = xy.y + dy[i];
                if (isRange(tx, ty)) {
                    idxes.add(visit[tx][ty]);
                }
            }

            int sum = 1;
            for (int e : idxes) {
                sum += cnt.getOrDefault(e, 0);
            }
            answer[xy.x][xy.y] = sum;
            idxes.clear();
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(answer[i][j]%10);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static int bfs(int x, int y, int idx) {
        int zero = 1;
        Queue<XY_> q = new ArrayDeque<>();
        visit[x][y] = idx;
        q.add(new XY_(x, y));

        while (!q.isEmpty()) {
            XY_ cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int tx = cur.x + dx[i];
                int ty = cur.y + dy[i];
                if (isRange(tx, ty)) {
                    // 방문하지 않은 벽
                    if (map[tx][ty] == 0 && visit[tx][ty] == 0) {
                        visit[tx][ty] = idx;
                        q.add(new XY_(tx, ty));
                        zero++;
                    }
                }
            }
        }

        return zero;
    }
    
    static boolean isRange(int x, int y) {
        return (x<0 || y<0 || x>=N || y>=M) ? false : true;
    }
}

class XY_ {
    int x;
    int y;

    public XY_(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
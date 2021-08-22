package week7;

import java.io.*;
import java.util.*;

public class Boj_17244 {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] map;
    static int n, m, answer, size, sx, sy, ex, ey;
    static ArrayList<XY> findList = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cmd = br.readLine().split(" ");
        n = Integer.parseInt(cmd[0]);
        m = Integer.parseInt(cmd[1]);

        map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'S') {
                    sx = i; sy = j;
                }
                else if (map[i][j] == 'E') {
                    ex = i; ey = j;
                }
                else if (map[i][j] == 'X') {
                    findList.add(new XY(i, j, 0));
                }
            }
        }

        size = findList.size();
        answer = Integer.MAX_VALUE;
        if (size == 0) {
            answer = bfs(new XY(sx, sy, 0), new XY(ex, ey, 0));
        } else {
            dfs(new LinkedList<>());
        }

        System.out.println(answer);
    }

    static int bfs(XY s, XY e){
        int result = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<XY> q = new ArrayDeque<>();
        s.setD(0);
        q.add(s);
        visited[s.x][s.y] = true;

        Loop1: while (!q.isEmpty()) {
            XY cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int tx = cur.x + dx[i];
                int ty = cur.y + dy[i];

                if(isValid(tx, ty) && !visited[tx][ty] && map[tx][ty] != '#') {
                    visited[tx][ty] = true;
                    if(tx == e.x && ty == e.y) {
                        result = cur.d + 1;
                        break Loop1;
                    }
                    q.add(new XY(tx, ty, cur.d + 1));
                }
            }
        }

        return result;
    }

    static void dfs(LinkedList<Integer> l) {
        if(l.size() == size){
            int sum = 0;

            for(int i=0; i<size; i++){
                if(i==0) sum += bfs(new XY(sx, sy, 0), findList.get(l.get(i)));
                else sum += bfs(findList.get(l.get(i-1)), findList.get(l.get(i)));
            }
            sum += bfs(findList.get(l.get(size-1)), new XY(ex, ey, 0));

            answer = Math.min(answer, sum);
            return;
        }

        for(int i=0; i<size; i++){
            if(l.contains(i)) continue;
            l.add(i);
            dfs(l);
            l.removeLast();
        }
    }

    static boolean isValid(int x, int y){
        return (x<0 || y<0 || x>=m || y>=n) ? false : true;
    }
}

class XY{
    int x;
    int y;
    int d;
    public XY(int x, int y, int d)
    {
        this.x = x;
        this.y = y;
        this.d = d;
    }

    public void setD(int d) {
        this.d = d;
    }
}
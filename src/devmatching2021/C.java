package devmatching2021;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class C {
    public static void main(String[] args) {
        for (int j=6; j>1; j--){
            System.out.println(j);
        }
    }
}


class Solution_C {
    static int[][] gameBoard;
    static List<XY> macarons;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public String[] solution(int[][] macaron) {
        String[] answer = {};

        gameBoard = new int[7][7]; // 1~6
        macarons = new ArrayList<>();

        for (int i = 0; i < macaron.length; i++) {
            int pos = macaron[i][0];
            int color = macaron[i][1];

            for (int j=6; j>0; j--){
                if (gameBoard[j][pos] == 0) {
                    gameBoard[j][pos] = color;
                    macarons.add(new XY(j, pos, 0));
                }
            }

            gameBoard = bfs();
        }


        return answer;
    }

    private int[][] bfs() {
        Queue<XY> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[7][7];
        for (XY e : macarons) {
            q.add(e);
            visited[e.x][e.y] = true;
        }

        while (q.isEmpty()) {
            XY cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int tx = cur.x + dx[i];
                int ty = cur.y + dy[i];
                if (isRange(tx, ty) && visited[tx][ty]) {
                    int cnt = (gameBoard[tx][ty] == gameBoard[cur.x][cur.y]) ? cur.cnt+1 : cur.cnt;
                    q.add(new XY(tx, ty, cnt));
                }
            }

        }

        return null;
    }

    private boolean isRange(int tx, int ty) {
        return tx > 0 && tx < 7 && ty > 0 && ty < 7;
    }
}

class XY {
    int x;
    int y;
    int cnt;

    public XY(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
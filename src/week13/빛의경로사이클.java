package week13;

import java.util.*;

public class 빛의경로사이클 {
    public static void main(String[] args) {
        Solution_빛 solution_빛 = new Solution_빛();
        int[] ints = solution_빛.solution(new String[]{"SL","LR"});
        //int[] ints = solution_빛.solution(new String[]{"R","R"});
        for (int e : ints) {
            System.out.println(e);
        }
    }
}

class Solution_빛 {

    // 하 상 오 왼
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int N, M;
    public static String[][] map;
    public static int IN = 0;
    public static int OUT = 1;
    //public static ArrayList<ArrayList<Dot>> traces;
    public static Set<ArrayList<Dot>> traces;
    public static boolean visit[][][][];
    public int[] solution(String[] grid) {

        N = grid.length;
        M = grid[0].length();
        map = new String[N][M];
        for (int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = String.valueOf(grid[i].charAt(j));
            }
        }

        //traces = new ArrayList<>();
        traces = new HashSet<>();
        visit = new boolean[N][M][2][4]; // 0 = in, 1 = out
        ArrayList<Integer> cnt = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 4; k++) {
                    ArrayList<Dot> trace = move(new Dot(i, j, k));
                    if (trace.size() > 0) {// && !isContains(trace)) {
                        traces.add(trace);
                        cnt.add(trace.size());
                        //print(trace);
                    }
                }
            }
        }

        Collections.sort(cnt);
        int[] answer = new int[cnt.size()];

        for (int i = 0; i < cnt.size(); i++) {
            answer[i] = cnt.get(i);
        }

        return answer;
    }

    private boolean isContains(ArrayList<Dot> trace) {
        for (ArrayList<Dot> e : traces) {
            if (isSame(e, trace)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSame(ArrayList<Dot> e, ArrayList<Dot> trace) {
        return trace.containsAll(e);
    }

    private void print(ArrayList<Dot> trace) {
        System.out.println(trace.size());
        for (Dot dot : trace) {
            System.out.print(dot.toString() + " => ");
        }
        System.out.println();
    }

    private ArrayList<Dot> move(Dot start) {
        ArrayList<Dot> trace = new ArrayList<>();

        Queue<Dot> q = new ArrayDeque<>();
        q.add(start);

        while (!q.isEmpty()) {
            Dot cur = q.poll();
            visit[cur.x][cur.y][OUT][cur.dir] = true;
            int tx = cur.x + dx[cur.dir];
            int ty = cur.y + dy[cur.dir];

            Dot movedDot = moveTo(new Dot(tx, ty, cur.dir));
            if (!visit[movedDot.x][movedDot.y][IN][movedDot.dir]) {
                visit[movedDot.x][movedDot.y][IN][movedDot.dir] = true;
                trace.add(movedDot);
                // 나가는 방향
                int dir = movedDot.moveDir(map[movedDot.x][movedDot.y]);
                Dot outDot = new Dot(movedDot.x, movedDot.y, dir);
                if (outDot.equals(start)) {
                    break;
                }
                q.add(outDot);
            }

        }
        return trace;
    }

    public Dot moveTo(Dot dot) {
        int x = dot.x;
        int y = dot.y;

        if (dot.x < 0) {
            x = N-1;
        } else if (dot.x >=N) {
            x = 0;
        } else if (dot.y < 0) {
            y = M-1;
        } else if (dot.y >=M) {
            y = 0;
        }
        return new Dot(x, y, dot.dir);
    }

}


class Dot {
    int x;
    int y;
    int dir;

    public Dot(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    // 하 상 오 왼
    public int moveDir(String node){
        if ("S".equals(node)) {
            return this.dir;
        } else if ("L".equals(node)) {
            return turnLeft();
        } //else if ("R".equals(node)) {
        return turnRight();
        //}
    }

    private int turnLeft() {
        if (dir == 0) {
            return 2;
        } else if (dir == 1) {
            return 3;
        } else if (dir == 2) {
            return 1;
        } else {
            return 0;
        }
    }

    private int turnRight() {
        if (dir == 0) {
            return 3;
        } else if (dir == 1) {
            return 2;
        } else if (dir == 2) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dot dot = (Dot) o;
        return x == dot.x && y == dot.y && dir == dot.dir;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, dir);
    }

    @Override
    public String toString() {
        return "Dot{" +
                "x=" + x +
                ", y=" + y +
                ", dir=" + dir +
                '}';
    }
}
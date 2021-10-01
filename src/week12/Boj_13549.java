package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj_13549 {
    static int S, D, N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        S = Integer.parseInt(line[0]);
        D = Integer.parseInt(line[1]);
        N = 100000;

        PriorityQueue<Pos> q = new PriorityQueue<>();
        q.add(new Pos(S, 0));
        boolean[] visit = new boolean[N+1];

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            visit[cur.x] = true;

            if (cur.x == D) {
                System.out.println(cur.sec);
                break;
            }
            int back = cur.x - 1;
            int front = cur.x + 1;
            int tel = cur.x * 2;

            if (back >=0 && back <= N && !visit[back]) {
                q.add(new Pos(back, cur.sec+1));
            }
            if (front >=0 && front <= N && !visit[front]) {
                q.add(new Pos(front, cur.sec+1));
            }
            if (tel >=0 && tel <= N && !visit[tel]) {
                q.add(new Pos(tel, cur.sec));
            }
        }
    }
}

class Pos implements Comparable<Pos>{
    int x;
    int sec;
    public Pos(int x, int sec) {
        this.x = x;
        this.sec = sec;
    }

    @Override
    public int compareTo(Pos o) {
        return sec - o.sec;
    }
}

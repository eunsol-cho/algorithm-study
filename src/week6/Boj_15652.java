package week6;

import java.io.*;
import java.util.LinkedList;

public class Boj_15652 {
    static int N, M;
    static BufferedReader br;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception{

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out)); // systemout -> 시간초과!

        String[] cmd = br.readLine().split(" ");
        N = Integer.parseInt(cmd[0]);
        M = Integer.parseInt(cmd[1]);

        // 중복O, 순서O, 비내림차순 -> 1 2 3 (O) / 1 3 2 (X)
        doing(1, new LinkedList<Integer>());

        bw.flush();
        bw.close();
    }

    static void doing(int idx, LinkedList<Integer> l) throws IOException {
        if (l.size() == M) {
            print(l);
            return;
        }
        for (int i = idx; i <= N; i++) {
            l.add(i);
            doing(i, l);
            l.removeLast();
        }
    }

    private static void print(LinkedList<Integer> l) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int e : l) {
            sb.append(e + " ");
        }
        String str = sb.toString();
        bw.write(str.substring(0, str.length() - 1) + "\n");
    }
}

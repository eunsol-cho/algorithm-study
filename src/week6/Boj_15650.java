package week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Boj_15650 {
    static int N, M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cmd = br.readLine().split(" ");
        N = Integer.parseInt(cmd[0]);
        M = Integer.parseInt(cmd[1]);

        // 중복X, 순서X
        doing(1, new LinkedList<Integer>());
    }

    static void doing(int idx, LinkedList<Integer> l){
        if (l.size() == M) {
            print(l);
            return;
        }
        for (int i = idx; i <= N; i++) {
            if (l.contains(i)) continue;
            l.add(i);
            doing(i, l);
            l.removeLast();
        }
    }

    private static void print(LinkedList<Integer> l) {
        StringBuilder sb = new StringBuilder();
        for (int e : l) {
            sb.append(e + " ");
        }
        String str = sb.toString();
        System.out.println(str.substring(0, str.length() - 1));
    }
}


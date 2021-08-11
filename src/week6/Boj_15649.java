package week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Boj_15649 {

    static int N, M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cmd = br.readLine().split(" ");
        N = Integer.parseInt(cmd[0]);
        M = Integer.parseInt(cmd[1]);

        // 중복X, 순서O
        doing(new LinkedList<Integer>());
    }

    static void doing(LinkedList<Integer> l){
        if (l.size() == M) {
            print(l);
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (l.contains(i)) continue;
            l.add(i);
            doing(l);
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

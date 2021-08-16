package week6;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Boj_15655 {
    static int N, M;
    static String[] cmd;
    static int[] arr;
    static BufferedReader br;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        cmd = br.readLine().split(" ");
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = Integer.parseInt(cmd[0]);
        M = Integer.parseInt(cmd[1]);

        Arrays.sort(arr);
        doing(0, new LinkedList<Integer>());

        bw.flush();
        bw.close();
    }

    static void doing(int idx, LinkedList<Integer> l) throws IOException {
        if (l.size() == M) {
            print(l);
            return;
        }

        for (int i=idx; i<N; i++) {
            if (l.contains(i)) continue;
            l.add(i);
            doing(i, l);
            l.removeLast();
        }
    }

    static void print(LinkedList<Integer> l) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i : l) {
            sb.append(arr[i] + " ");
        }
        String str = sb.toString();
        bw.write(str.substring(0, str.length() - 1) + "\n");
    }
}

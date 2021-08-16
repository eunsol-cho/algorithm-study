package week6;

import java.io.*;
import java.util.*;

public class Boj_15663 {
    static int N, M;
    static String[] cmd;
    static int[] arr;
    static BufferedReader br;
    static BufferedWriter bw;
    static LinkedHashSet<String> set = new LinkedHashSet<>();
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        cmd = br.readLine().split(" ");
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = Integer.parseInt(cmd[0]);
        M = Integer.parseInt(cmd[1]);

        Arrays.sort(arr);
        doing(new LinkedList<Integer>());

        for (String str : set) {
            bw.write(str.substring(0, str.length() - 1) + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void doing(LinkedList<Integer> l) throws IOException {
        if (l.size() == M) {
            print(l);
            return;
        }
        for (int i=0; i<N; i++) {
            if (l.contains(i)) continue;
            l.add(i);
            doing(l);
            l.removeLast();
        }
    }

    static void print(LinkedList<Integer> l) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i : l) {
            sb.append(arr[i] + " ");
        }
        String str = sb.toString();
        set.add(str);
    }
}

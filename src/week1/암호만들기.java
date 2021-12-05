package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

// https://www.acmicpc.net/problem/1759
public class 암호만들기 {

    static int L, C;
    static String[] str;
    static StringBuilder sb;
    static Set<String> vowels = new HashSet<>(Arrays.asList("a", "e", "i", "o", "u"));
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lc = br.readLine().split(" ");
        str = br.readLine().split(" ");

        L = Integer.parseInt(lc[0]);
        C = Integer.parseInt(lc[1]);

        Arrays.sort(str);

        sb = new StringBuilder();
        dfs(0, new LinkedList<Integer>());
        System.out.println(sb.toString());
    }

    private static void dfs(int idx, LinkedList<Integer> l) {
        if (l.size() == L) {
            int v = 0;
            int c = 0;
            for (int i : l) {
                if (vowels.contains(str[i])) {
                    v++;
                } else {
                    c++;
                }
                sb.append(str[i]);
            }
            if (v>0 && c>1) {
                sb.append("\n");
            } else {
                sb.delete(sb.length() - L, sb.length());
                //sb.append(" <<< v:"+v+",c:"+c+" \n");
            }
            return;
        }

        for (int i = idx; i < C; i++) {
            if (l.contains(i)) continue;
            l.add(i);
            dfs(i, l);
            l.removeLast();
        }
    }


}

package dataSturucture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 요세푸스 문제 0 #silver IV
// 2021.07.05 22:10
public class Boj_11866 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cmd = br.readLine().split(" ");
        int N = Integer.parseInt(cmd[0]);
        int K = Integer.parseInt(cmd[1]);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int idx = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            idx++;
            if (idx != K) {
                queue.add(cur);
            } else {
                sb.append(cur + ", ");
                idx = 0;
            }
        }

        String result = sb.toString();
        System.out.println("<" + result.substring(0, result.length()-2) + ">");
    }
}

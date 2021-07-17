package dataSturucture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Boj_15903 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cmd = br.readLine().split(" ");
        int N = Integer.parseInt(cmd[0]);
        int M = Integer.parseInt(cmd[1]);

        PriorityQueue<Long> q = new PriorityQueue<>();
        Arrays.stream(br.readLine().split(" ")).map(Long::parseLong).forEach(e -> q.add(e));
        while (M > 0) {
            M--;
            long sum = q.poll() + q.poll();
            q.add(sum);
            q.add(sum);
        }

        long ans = 0;
        while (!q.isEmpty()) {
            ans += q.poll();
        }

        System.out.println(ans);
    }
}

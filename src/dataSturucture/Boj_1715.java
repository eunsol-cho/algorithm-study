package dataSturucture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 카드 정렬하기 / G4
// 2021.07.14 23:41
// https://hidelookit.tistory.com/158
public class Boj_1715 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PriorityQueue<Long> q = new PriorityQueue<Long>();

        for (int i = 0; i < T; i++) {
            q.add(Long.parseLong(br.readLine()));
        }

        long ans = 0;
        while (q.size() > 1) {
            long sum = q.poll() + q.poll();
            q.add(sum);
            ans += sum;
        }

        System.out.println(ans);

    }

}

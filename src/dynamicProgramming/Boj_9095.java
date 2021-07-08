package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1, 2, 3 더하기 #silver III
// 2021.07.08 21:18
public class Boj_9095 {

    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int goal = Integer.parseInt(br.readLine());
            cnt = 0;
            dfs(0, goal);
            System.out.println(cnt);
        }
    }

    public static void dfs(int sum, int goal) {
        if (sum > goal) return;
        else if (sum == goal) {
            cnt++;
        } else {
            for (int i = 1; i < 4; i++) {
                dfs(sum + i, goal);
            }
        }
    }
}

package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://m.blog.naver.com/occidere/220786307316
public class Boj_9465 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] dx = {-1, 0, +1, 0};
        int[] dy = {0, -1, 0, +1};

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr  = new int[2][N];
            int[][] dp = new int[2][N+1];
            for (int j = 0; j < 2; j++) {
                arr[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            dp[0][0] = dp[1][0] = 0;
            dp[0][1] = arr[0][0];
            dp[1][1] = arr[1][0];
            for (int k = 2; k <= N; k++) {
                // 두줄 -> 시작을 첫번째 or 두번째 줄
                // 대각선 한칸 or 대각선 두칸 (대각선 세칸부터는 한칸이나 두칸보다 무조건 작은합이 나옴)
                dp[0][k] = Math.max(dp[1][k - 1], dp[1][k - 2]) + arr[0][k-1];
                dp[1][k] = Math.max(dp[0][k - 1], dp[0][k - 2]) + arr[1][k-1];
            }
            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
    }
}

package week7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Boj_1149 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] a = new int[1001][3];
        int[][] dp = new int[1001][3];
        for (int i = 1; i <= N; i++) {
            a[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 1; i <= N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + a[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + a[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + a[i][2];
        }

        int answer = Math.min(dp[N][0], dp[N][1]);
        answer = Math.min(answer, dp[N][2]);
        System.out.println(answer);
    }
}

package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 누적합2 / G5
// 2021.07.14 22:09
public class Boj_13398 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        // TODO 스트림 사용법 외우기
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] dp = new int[T][2];
        int max = arr[0];
        dp[0][0] = dp[0][1] = arr[0];

        for (int i = 1; i < T; i++) {
            // 이전까지 연속합 or 현재수
            dp[i][0] = Math.max(dp[i-1][0] + arr[i], arr[i]);
            // 현재수를 제거 하거나 or 다른수를 제거
            dp[i][1] = Math.max(dp[i-1][1] + arr[i], dp[i-1][0]);

            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        System.out.println(max);

    }

}

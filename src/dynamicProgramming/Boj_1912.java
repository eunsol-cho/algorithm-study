package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 연속합#silver II
// 2021.07.08 21:29
public class Boj_1912 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        int sum = Integer.parseInt(arr[0]);;
        int max = sum;
        for (int i = 1; i < T; i++) {
            int cur = Integer.parseInt(arr[i]);
            int tmp = sum+cur;
            if (sum < 0 || tmp < 0) { // sum < 0 : 첫번째 숫자가 음수인 경우 처리
                sum = cur;
            } else {
                sum = tmp;
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}

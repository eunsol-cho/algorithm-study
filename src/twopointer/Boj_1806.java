package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int N = Integer.parseInt(line1[0]);
        int S = Integer.parseInt(line1[1]);
        int[] arr = new int[N+1];

        String[] line2 = br.readLine().split(" ");
        for (int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(line2[i-1]);
        }
        // 누적합
        int[] sum = new int[N+1];
        for (int i=1; i<N+1; i++){
            sum[i] = sum[i-1] + arr[i];
        }
        // S이상 되는거 구간중 짧은구간
        int left = 1;
        int right = 2;
        int diff = 1000000;
        while (right < N+1){
            int tmp = sum[right] - sum[left-1];
            if(S <= tmp){
                diff = Math.min(diff, right-left+1);
                left++;
            } else {
                right++;
            }
        }

        System.out.println(diff==1000000 ? "0" : diff);

    }
}

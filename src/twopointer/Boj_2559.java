package twopointer;

import java.util.Scanner;

public class Boj_2559 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N+1];
        for(int i=1; i<N+1; i++){
            arr[i] = sc.nextInt();
        }
        // 누적합
        int[] sum = new int[N+1];
        for(int i=1; i<K+1; i++){
            sum[i] = sum[i-1] + arr[i];
        }
        // K일의 부분합
        int max = sum[K];
        for(int i=K+1; i<N+1; i++){
            sum[i] = sum[i-1] + arr[i];
            max = Math.max(max, sum[i] - sum[i-K]);
        }
        System.out.println(max);
    }
}

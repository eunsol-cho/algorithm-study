package twopointer;

import java.util.Scanner;

public class Boj_11659_rty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N+1];
        for(int i=1; i<N+1; i++){
            arr[i] = sc.nextInt();
        }
        // 누적합 배열
        int[] sum = new int[N+1];
        for(int i=1; i<N+1; i++){
            sum[i] = sum[i-1] + arr[i];
        }
        // 구간합 구하기
        for(int i=0; i<M; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            System.out.println(sum[e] - sum[s-1]);
        }
    }
}

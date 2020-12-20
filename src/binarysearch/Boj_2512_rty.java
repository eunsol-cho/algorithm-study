package binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2512_rty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] city = new int[N];
        for(int i=0; i<N; i++){
            city[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        Arrays.sort(city);
        int left = 0;
        int right = city[N-1];
        int mid;
        while (left <= right){
            mid = (left + right)/2;
            long sum = 0;
            for(int e : city){
                sum += (mid > e) ? e : mid;
            }
            if(sum > M){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left-1);
        //System.out.println(right);
        // 최댓값은 left / 최솟값은 right
    }
}

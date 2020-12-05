package binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2805 {
    public static void main(String[] args) {
        // M미터의 나무가 필요
        // 절단기의 높이 H -> 최대값
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] trees = new int[N];
        for(int i=0; i<N; i++){
            trees[i] = sc.nextInt();
        }
        Arrays.sort(trees);
        int left = 1; //trees[0];
        int right = trees[N-1];
        int mid = 0;
        while (left <= right){
            mid = (left + right)/2;
            long tmp = 0;
            for(int i=0; i<N; i++){
                if(trees[i] > mid){
                    tmp += (trees[i] - mid);
                }
            }
            if(tmp >= M){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}

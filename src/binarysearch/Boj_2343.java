package binarysearch;

import java.util.Scanner;

public class Boj_2343 {

    static int N, M;
    static int[] vdo;
    public static void main(String[] args) {
        // M개의 블루레이 / 최소
        // 블루레이의 크기 최소
        // 레슨이 분단위로 / 레슨수 N
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        vdo = new int[N];
        int sum = 0;
        for(int i=0; i<N; i++){
            vdo[i] = sc.nextInt();
            sum += vdo[i];
        }
        int left = 0;
        int right = sum;
        int mid;
        while (left <= right){
            mid = (left+right)/2;
            if(chk(mid)){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(right+1);
        //System.out.println(left+1);
        //System.out.println(mid);
    }

    public static boolean chk(int mid){
        int cnt = 1;
        int sum = 0;
        for(int i=0; i<N; i++){
            if(vdo[i] > mid) return false;
            sum += vdo[i];
            if(sum > mid) {
                sum = vdo[i];
                cnt++;
            }
        }
        //if(sum > 0) cnt++;
        return (cnt <= M) ? true : false;
    }
}

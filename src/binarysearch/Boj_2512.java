package binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2512 {
    public static void main(String[] args) {
        // 정해진 총액 이하에서 최대한 큰
        // 요청금액 맞춰, 불가능하면? 정수 상한액
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] city = new int[N];
        for(int i=0; i<N; i++){
            city[i] = sc.nextInt();
        }
        int total = sc.nextInt();
        Arrays.sort(city);

        int left = 0;
        int right = city[N-1];
        int mid = 0;
        while (left < right){
            mid = (left + right + 1)/2;
            int tmp = 0;
            for(int e : city){
                tmp += (e > mid) ? mid : e;
            }
            if(tmp > total){
                right = mid - 1;
            } else {
                left = mid ;
            }
        }
        System.out.println(right);
    }
}

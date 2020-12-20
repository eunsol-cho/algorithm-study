package twopointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Boj_2470_rty {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        String[] tmp = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            arr[i] = Long.parseLong(tmp[i]);
        }

        Arrays.sort(arr);
        int left = 0;
        int right = N-1;
        long ans = Integer.MAX_VALUE; // Math.abs(arr[left] + arr[right]);
        long[] result =  {0, 0}; //{arr[left], arr[right]};
        while (left < right){
            long sum = arr[left] + arr[right];
            if(ans >= Math.abs(sum)){
                ans = Math.abs(sum);
                result[0] = arr[left];
                result[1] = arr[right];
            }
            if(sum < 0){
                left++;
            } else {
                right--;
            }
        }
        System.out.println(result[0] + " " + result[1]);
    }
}

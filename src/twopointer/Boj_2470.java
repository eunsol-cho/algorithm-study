package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        String[] tmp = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(tmp[i]);
        }
        Arrays.sort(arr);
        int start = 0;
        int end = N-1;
        long answer[] = {0, 0}; //{arr[start], arr[end]};
        long diff = Integer.MAX_VALUE; //Math.abs(arr[start] + arr[end]);
        while (start < end){
            long sum = arr[start] + arr[end];
            if(Math.abs(sum) < diff){
                diff = Math.abs(sum);
                answer[0] = arr[start];
                answer[1] = arr[end];
            }
            if(sum < 0){
                start++;
            } else {
                end--;
            }

        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}

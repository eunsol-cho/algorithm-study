package binarysearch;

import java.util.Arrays;

public class Prog_43238 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println("start");
        int[] times = {7, 10};
        System.out.println(solution.solution(6, times));
        //System.out.println("end");
    }
}

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        int len = times.length;
        Arrays.sort(times);
        long left = 1;
        long right = (long)n*(long)times[len-1];
        long mid;
        while (left <= right){
            mid = (left+right)/2;
            long sum = 0;
            for(int e : times){
                sum += (mid / e);
            }
            if(sum >= n){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        answer = right + 1;
        return answer;
    }
}

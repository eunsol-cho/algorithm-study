package week19;

import java.util.Arrays;

public class 입국심사 {
    public static void main(String[] args) {
        Solution_입국심사 solution_입국심사 = new Solution_입국심사();
        System.out.println(solution_입국심사.solution(6, new int[]{7, 10}));
    }
}


class Solution_입국심사 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 1;
        long right = (long)n*(long)times[times.length-1]; // long 계산시 유의!
        long mid;

        while (left <= right) { // 등호는 왜 있어야 하지??
            mid = (left + right) / 2;
            long sum = 0;
            for (int e : times) {
                sum += (mid / e);
            }

            if (sum >= n) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return right+1;
    }
}
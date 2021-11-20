package week18;

import java.util.Arrays;

public class 이진변환반복하기 {
    public static void main(String[] args) {
        Solution_이진변환반복하기 solution_이진변환반복하기 = new Solution_이진변환반복하기();
        int[] solution = solution_이진변환반복하기.solution("110010101001");
        Arrays.stream(solution).forEach(System.out::println);
    }
}

class Solution_이진변환반복하기 {

    static int removedCnt = 0;
    public int[] solution(String s) {
        // while 1이 될때 까지
        int cnt = 0;
        while (!"1".equals(s)) {
            s = convert(s);
            cnt++;
        }
        return new int[]{cnt, removedCnt};
    }

    public static String convert(String s) {
        // 0제거
        int prev = s.length();
        int cur = s.replaceAll("0", "").length();;
        removedCnt += prev - cur;

        // 길이 -> 2진수
        return Integer.toBinaryString(cur);
    }
}
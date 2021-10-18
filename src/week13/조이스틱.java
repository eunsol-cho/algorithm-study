package week13;

import java.util.LinkedList;

public class 조이스틱 {
    public static void main(String[] args) {
        Solution_조이스틱 solution_조이스틱 = new Solution_조이스틱();
        int answer = solution_조이스틱.solution("ACDAAAABA");
        System.out.println(answer);
    }
}


class Solution_조이스틱 {
    static int n, side, answer;
    static int[] gap;
    public int solution(String name) {
        char[] str = name.toCharArray();
        answer = 0;
        n = name.length();
        side = n-1;
        gap = new int[n];
        for(int i=0; i<n; i++){
            gap[i] = str[i] - 'A';
            if(gap[i] > 13){ // down
                gap[i] = 26-gap[i];
            }

            // 옆으로 이동
            // 여기서 돌아가서 뒤부터 하는게 빠른지 체크
            int idx = i + 1;
            while (idx < n && str[idx] == 'A') {
                idx++;
            }
            side = Math.min(side, (i * 2) + n - idx);

            answer += gap[i];
        }

        return answer + side;
    }
}
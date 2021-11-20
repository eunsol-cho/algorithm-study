package week18;

import java.util.*;

public class 다트게임 {
    public static void main(String[] args) {
        Solution_다트게임 solution_다트게임 = new Solution_다트게임();
        int solution = solution_다트게임.solution("1S2D*3T");
        System.out.println(solution);
    }
}


class Solution_다트게임 {
    static Stack<Integer> nums;
    static Map<Character, Integer> bonus;
    public int solution(String dartResult) {
        int answer = 0;
        init();
        Set<Character> option = new HashSet<>(Arrays.asList('*', '#'));

        char[] chars = dartResult.toCharArray();
        StringBuilder sb = new StringBuilder();
        nums = new Stack<>();
        char e;
        int num;
        for (int i = 0; i < chars.length; i++) {
            e = chars[i];
            if (bonus.containsKey(e)) {
                num = Integer.parseInt(sb.toString());
                nums.add(num);
                sb.setLength(0); // 초기화
                if (i+1 < chars.length && option.contains(chars[i+1])) {
                    calculate(e, chars[i+1]);
                    i++;
                    continue;
                }
                calculate(e);
                continue;
            }
            sb.append(e);
        }

        while (!nums.isEmpty()) {
            answer += nums.pop();
        }

        return answer;
    }

    public static void init() {
        bonus = new HashMap<>();
        bonus.put('S', 1);
        bonus.put('D', 2);
        bonus.put('T', 3);
    }

    public static void calculate(char b) {
        int cur = nums.pop();
        nums.add((int) Math.pow(cur, bonus.get(b)));
    }

    public static void calculate(char b, char o) {
        calculate(b);
        int cur = nums.pop();
        if (o == '#') {
            nums.add(cur*-1);
            return;
        }
        // *
        if (!nums.isEmpty()) {
            int pre = nums.pop();
            nums.add(pre*2);
        }
        nums.add(cur*2);
    }
}
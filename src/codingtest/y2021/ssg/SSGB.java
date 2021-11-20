package codingtest.y2021.ssg;

import java.util.Stack;

public class SSGB {
    public static void main(String[] args) {
        Solution_SSGB solution_ssgb = new Solution_SSGB();
        int e = solution_ssgb.solution("0110011");
        System.out.println(e);
    }
}


class Solution_SSGB {

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char e = chars[i];
            if(!stack.isEmpty()) {
                char top = stack.peek();
                if ((e^top) == 1) {
                    stack.pop();
                    continue;
                }
            }
            stack.add(e);
        }
        return stack.size();
    }
}
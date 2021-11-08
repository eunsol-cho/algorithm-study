package codingtest.y2021.buketplace;

import java.util.*;

public class B {
    public static void main(String[] args) {
        Solution_B solution_b = new Solution_B();

        System.out.println(solution_b.solution("oohhoooh")); // 2
        System.out.println(solution_b.solution("ohohohohoooo")); // 4
        System.out.println(solution_b.solution("ooohhohoo")); // 3
        System.out.println(solution_b.solution("ooohhhoo")); // 2
        System.out.println(solution_b.solution("ohoohho")); // 2
        System.out.println(solution_b.solution("ohhhhohoo")); //


    }

}


class Solution_B {

    public int solution(String str) {
        int todayColors = 0;
        char[] arr = str.toCharArray();
        int lastO = str.lastIndexOf('o');
        if (lastO < 0) return 0; // o가 없는경우

        int cntO = 0;
        for (int e : arr) {
            if (e == 'o') {
                cntO++;
            }
        }

        Stack<Integer> hStack = new Stack<>();
        Deque<Integer> oDeque = new ArrayDeque<>();
        for (int i = 0; i <= lastO; i++) {
            if (arr[i] == 'o') {
                oDeque.addLast(i);
            } else if (arr[i] == 'h') {
                if (!oDeque.isEmpty() && cntO >= 2) {
                    oDeque.pollFirst();
                    //System.out.println("h=" + i + ", o=" + oDeque.pollFirst());
                    hStack.add(i);
                    cntO -= 2;
                }
            }
        }

        while (!hStack.isEmpty()) {
            int hIdx = hStack.pop();
            if (!oDeque.isEmpty()) {
                //System.out.println("hIdx=" + hIdx + "," + "oStack.getLast()= " +oDeque.getLast());
                if (hIdx < oDeque.getLast()) {
                    todayColors++;
                    oDeque.pollLast();
                }
            }
        }

        return todayColors;
    }
}

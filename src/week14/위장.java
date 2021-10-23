package week14;

import java.util.*;

public class 위장 {
    public static void main(String[] args) {
        Solution_위장 solution_위장 = new Solution_위장();
        int e = solution_위장.solution(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}});
        System.out.println(e);
    }
}


class Solution_위장 {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        int cnt;
        for (String[] clothe : clothes) {
            cnt = map.getOrDefault(clothe[1], 0);
            map.put(clothe[1], cnt + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            answer *=(entry.getValue()+1);
        }

        return answer-1;
    }
}
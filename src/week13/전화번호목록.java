package week13;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class 전화번호목록 {
    public static void main(String[] args) {
        Solution_전화번호목록 solution_전화번호목록 = new Solution_전화번호목록();
        boolean answer = solution_전화번호목록.solution(new String[]{"123","456","789"});
        System.out.println(answer);
    }
}

class Solution_전화번호목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Set<String> set = new HashSet<>();

        for (String phoneNumber : phone_book) {
            set.add(phoneNumber);
        }

        for (String phoneNumber : phone_book) {
            int l = phoneNumber.length();

            for (String e : set) {
                if (e.length() <= l) {
                    /*if (set.contains((phoneNumber.substring(0, e.length()))) {
                        return false;
                    }*/
                }
            }
        }

        return answer;
    }
}
package devmatching2021;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class A {
    public static void main(String[] args) {
        Solution_A solution_a = new Solution_A();
        //String s = solution_a.solution(new String[]{"card", "ace13", "ace16", "banker", "ace17", "ace14"}, "ace15");
        String s = solution_a.solution(new String[]{"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"}, "cow");

        System.out.println(s);
    }
}


class Solution_A {
    public String solution(String[] registered_list, String new_id) {
        Set<String> set = new HashSet<>(Arrays.asList(registered_list));
        if (!set.contains(new_id)) {
            return new_id;
        }

        // 시작점 찾기
        char[] str = new_id.toCharArray();
        int idx = 0;
        for (int i = 0; i < str.length; i++) {
            if (!(str[i] >= 'a' && str[i] <= 'z')) {
                idx = i;
                break;
            }
        }

        String N = (idx == 0) ? "1" : new_id.substring(idx);
        idx = (idx == 0) ? str.length : idx;
        String S = new_id.substring(0, idx);
        int n = Integer.parseInt(N);

        while (set.contains(S+n)) {
            n++;
        }

        return S+n;
    }
}
package week13;

import java.util.*;

public class 튜플 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] ints = solution.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        int[] ints = solution.solution("{{20,111},{111}}");
        for (int e : ints) {
            System.out.println(e);
        }

    }
}


class Solution {
    public int[] solution(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        boolean isEnd  = false;

        for (int i = 0; i < s.length(); i++) {
            isEnd = false;
            if (s.charAt(i) == '{') {
                continue;
            } else if (s.charAt(i) == ',') {
                isEnd = true;
            } else if (s.charAt(i) == '}') {
                isEnd = true;
            }

            if (isEnd) {
                if (sb.length() > 0) {
                    int cur = Integer.parseInt(sb.toString());
                    int cnt = map.getOrDefault(cur, 0);
                    map.put(cur, cnt+1);
                    sb = new StringBuilder();
                }
                continue;
            }
            sb.append(String.valueOf(s.charAt(i)));
        }

        int[] answer = new int[map.size()];
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        list.forEach(System.out::println);

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i).getKey();
        }

        return answer;
    }
}

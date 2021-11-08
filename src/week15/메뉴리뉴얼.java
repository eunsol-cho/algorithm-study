package week15;

import java.util.*;

public class 메뉴리뉴얼 {
    public static void main(String[] args) {
        Solution_메뉴리뉴얼 solution_메뉴리뉴얼 = new Solution_메뉴리뉴얼();
        String[] e = solution_메뉴리뉴얼.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2,3,4});
        for (String str : e) {
            System.out.println(str);
        }
    }
}


class Solution_메뉴리뉴얼 {
    static Map<String, Integer> map;
    static int max;
    public String[] solution(String[] orders, int[] course) {

        List<String> answer = new ArrayList<>();

        List<char[]> o = new ArrayList<>();
        for (String order : orders) {
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            o.add(arr);
        }


        for (int num : course) {
            map = new HashMap<>();
            max = 2;

            for (char[] e : o) {
                dfs(e, num, new LinkedList<>(), 0);
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == max) {
                    answer.add(entry.getKey());
                }
            }
        }

        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }

    static void dfs(char[] order, int size, LinkedList<Integer> l, int idx) {
        if (l.size() == size) {
            saveMenu(l, order);
            return;
        }

        for (int i=idx; i<order.length; i++) {
            if (l.contains(i)) continue;
            l.add(i);
            dfs(order, size, l, i);
            l.removeLast();
        }
    }

    private static void saveMenu(LinkedList<Integer> l, char[] order) {
        StringBuilder sb = new StringBuilder();
        for (int idx : l) {
            sb.append(order[idx]);
        }
        String menu = sb.toString();
        int cnt = map.getOrDefault(menu, 0);
        map.put(menu, cnt+1);
        // 최대 주문수 갱신
        max = Math.max(cnt+1, max);
    }
}
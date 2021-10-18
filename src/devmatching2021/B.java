package devmatching2021;

import java.util.*;

public class B {
    public static void main(String[] args) {
        Solution_B solution_b = new Solution_B();
        int e = solution_b.solution(4,"FRI", new int[]{6, 21, 23, 27, 28});
        System.out.println(e);
        /*
        일 1 0
        월 6 0
        화 5 6
        수 4 5
        목 3 4
        금 2 3
        토 1 2

        월요일 : MON, 화요일 : TUE, 수요일 : WED, 목요일 : THU, 금요일 : FRI, 토요일 : SAT, 일요일 : SUN
        * */
    }
}


class Solution_B {

    static List<Integer> nonHolidays;
    static boolean[] isHolidays;
    int answer = 0;
    public int solution(int leave, String day, int[] holidays) {

        final int DAYS = 7;
        Set<Integer> weekend = setWeekend(day);
        isHolidays = new boolean[31];
        int cnt = 0;

        // 토일
        for (int i = 1; i <= 30; i++) {
            int mod = (i%DAYS);
            if (weekend.contains(mod)) {
                isHolidays[i] = true;
                cnt++;
            }
        }

        // 휴일
        for (int holiday : holidays) {
            if(!isHolidays[holiday]) {
                isHolidays[holiday] = true;
                cnt++;
            }
        }

        // 모두 쉴수 있음
        if (leave >= 30 - cnt) {
            return 30;
        }

        nonHolidays = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            if (!isHolidays[i]) {
                nonHolidays.add(i);
            }
        }

        dfs(leave, new LinkedList<>());

        return answer;
    }

    private void dfs(int leave, LinkedList<Integer> l) {
        if (l.size() == leave) {
            int max = getMaxDays(l);
            answer = Math.max(max, answer);
            return;
        }

        for (int i = 0; i < nonHolidays.size(); i++) {
            if(l.contains(i)) continue;
            l.add(i);
            dfs(leave, l);
            l.removeLast();
        }
    }

    private int getMaxDays(LinkedList<Integer> l) {
        int cnt = 0;
        int max = cnt;
        // idx -> day
        Set<Integer> tmp = new HashSet<>();
        for (int e : l) {
            tmp.add(nonHolidays.get(e));
        }

        for (int i = 1; i <= 30; i++) {
            if (isHolidays[i] || tmp.contains(i)) {
                cnt++;
            } else {
                max = Math.max(max, cnt);
                cnt = 0;
            }
        }
        return Math.max(max, cnt);
    }

    static Set<Integer> setWeekend(String day) {
        if ("MON".equals(day)) return new HashSet<>(Arrays.asList(6, 0));
        if ("TUE".equals(day)) return new HashSet<>(Arrays.asList(5, 6));
        if ("WED".equals(day)) return new HashSet<>(Arrays.asList(4, 5));
        if ("THU".equals(day)) return new HashSet<>(Arrays.asList(3, 4));
        if ("FRI".equals(day)) return new HashSet<>(Arrays.asList(2, 3));
        if ("SAT".equals(day)) return new HashSet<>(Arrays.asList(1, 2));
        return new HashSet<>(Arrays.asList(1, 0)); // 일
    }
}

package codingtest.y2021.cafe24;

import java.util.ArrayList;
import java.util.List;

public class Two {
    public static void main(String[] args) {
        Solution_Two solution_two = new Solution_Two();
        //String[] str = solution_two.solution(2, 5);
        String[] str = solution_two.solution(9, 1);
        for (String e : str) {
            System.out.println(e);
        }
    }
}

class Solution_Two {
    public String[] solution(int startNumber, int endNumber) {
        List<String> l = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean isMoreThanEnd = startNumber > endNumber;
        sb.append(startNumber);
        l.add(lpad(sb.toString()));
        while (startNumber != endNumber) {
            sb.append(isMoreThanEnd ? --startNumber : ++startNumber);
            l.add(lpad(sb.toString()));
        }

        String[] answer = l.toArray(new String[l.size()]);
        return answer;
    }

    private String lpad(String str) {
        return String.format("%010d", Integer.parseInt(str));
    }
}
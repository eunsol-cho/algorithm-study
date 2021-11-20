package codingtest.y2021.ssg;

import java.util.*;

public class SSGA {
    public static void main(String[] args) {
        Solution_SSGA solution_ssga = new Solution_SSGA();
        String[] e = solution_ssga.solution(new String[]{"DS7651 A0", "CA0055 D+", "AI5543 C0", "OS1808 B-", "DS7651 B+", "AI0001 F", "DB0001 B-", "AI5543 D+", "DS7651 A+", "OS1808 B-"});
        Arrays.stream(e).forEach(System.out::println);
    }
}


class Solution_SSGA {

    static Map<String, Integer> standard = new HashMap<>();
    public String[] solution(String[] grades) {
        setStandard();

        Map<String, Sort> gradeMap = new HashMap<>();
        for (int i = 0; i < grades.length; i++) {
            String[] g = grades[i].split(" ");
            int curGrade = standard.get(g[1]);
            if (gradeMap.containsKey(g[0])) {
                Sort prv = gradeMap.get(g[0]);
                if (curGrade <= prv.grade) continue; // 이전성적이 크거나 같으면 패스
            }
            gradeMap.put(g[0], new Sort(i, curGrade, g[1]));
        }

        // 정렬
        List<Map.Entry<String, Sort>> list = new ArrayList(gradeMap.entrySet());
        list.sort(Map.Entry.comparingByValue());
        String[] answer = new String[list.size()];
        Map.Entry<String, Sort> entry;
        for (int i = 0; i < answer.length; i++) {
            entry = list.get(i);
            answer[i] = entry.getKey() + " " + ((Sort) entry.getValue()).gradeNm;
        }

        return answer;
    }

    private void setStandard() {
        standard.put("A+", 13);
        standard.put("A0", 12);
        standard.put("A-", 11);
        standard.put("B+", 10);
        standard.put("B0", 9);
        standard.put("B-", 8);
        standard.put("C+", 7);
        standard.put("C0", 6);
        standard.put("C-", 5);
        standard.put("D+", 4);
        standard.put("D0", 3);
        standard.put("D-", 2);
        standard.put("F", 1);
    }
}

class Sort implements Comparable<Sort>{
    int no;
    int grade;
    String gradeNm;

    public Sort(int no, int grade, String gradeNm) {
        this.no = no;
        this.grade = grade;
        this.gradeNm = gradeNm;
    }

    @Override
    public int compareTo(Sort o) {
        if (o.grade == this.grade) return this.no - o.no;
        return o.grade - this.grade;
    }

}



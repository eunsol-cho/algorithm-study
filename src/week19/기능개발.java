package week19;

import java.util.ArrayList;
import java.util.List;

public class 기능개발 {
    public static void main(String[] args) {
        Solution_기능개발 solution_기능개발 = new Solution_기능개발();
        solution_기능개발.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        //solution_기능개발.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
    }
}

class Solution_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> result = new ArrayList<>();
        int duration = 0;
        int curDuration = 0;
        int maxIdx = 0;
        int day = 0;

        for (int i = 0; i < progresses.length; i++) {
            duration = (100-progresses[i])/speeds[i];
            if ((100-progresses[i])%speeds[i] != 0) duration++;

            if (i == 0) {
                curDuration = duration;
            } else {
                if (curDuration < duration) {
                    result.add(i-maxIdx);
                    curDuration = duration;
                    maxIdx = i;
                }
            }
        }

        result.add(progresses.length-maxIdx);
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
package programmerce.level1;

import java.util.PriorityQueue;

public class Buget {
    public static void main(String[] args) {
        Solution_Buget s = new Solution_Buget();
        s.solution(new int[]{1, 3, 2, 5, 4}, 9);
    }
}

class Solution_Buget {
    public int solution(int[] d, int budget) {
        int answer = 0;

        PriorityQueue<Integer> q = new PriorityQueue();
        for (int e : d) {
            q.add(e);
        }

        while (!q.isEmpty()) {
            Integer e = q.poll();
            budget -= e;
            if (budget >= 0) {
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
}
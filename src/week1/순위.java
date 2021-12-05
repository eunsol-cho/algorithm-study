package week1;

import java.util.*;

public class 순위 {
    public static void main(String[] args) {
        Solution_순위 solution_순위 = new Solution_순위();
        int e = solution_순위.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});
        System.out.println(e);
    }
}

class Solution_순위 {

    public int solution(int n, int[][] results) {
        boolean[][] game = new boolean[n][n];
        int answer = 0;
        for (int i = 0; i < results.length; i++) {
            game[results[i][0] - 1][results[i][1] - 1] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (game[j][i] && game[i][k]) {
                        game[j][k] = true;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int result = 0;
            for (int j = 0; j < n; j++) {
                if (game[i][j] || game[j][i]) {
                    result++;
                }
            }
            if (result == n - 1) {
                answer++;
            }
        }
        return answer;
    }

}
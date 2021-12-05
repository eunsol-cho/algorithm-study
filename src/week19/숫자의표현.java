package week19;

public class 숫자의표현 {
    public static void main(String[] args) {
        Solution_숫자의표현 solution_숫자의표현 = new Solution_숫자의표현();
        System.out.println(solution_숫자의표현.solution(15));
    }
}

class Solution_숫자의표현 {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; j <= n; j++) {
                sum += j;

                if (sum == n) {
                    answer++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }
        }
        return answer;
    }
}

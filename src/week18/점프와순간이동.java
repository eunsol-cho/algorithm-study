package week18;

public class 점프와순간이동 {
    public static void main(String[] args) {
        Solution_점프와순간이동 solution_점프와순간이동 = new Solution_점프와순간이동();
        int solution = solution_점프와순간이동.solution(5);
        System.out.println(solution);
    }
}

class Solution_점프와순간이동 {
    public int solution(int n) {
        int ans = 0;

        while(n != 0){
            if(n % 2 == 0){
                n /= 2;
            } else {
                n--;
                ans++;
            }
        }

        return ans;
    }
}

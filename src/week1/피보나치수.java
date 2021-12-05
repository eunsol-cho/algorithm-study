package week1;

public class 피보나치수 {
    public static void main(String[] args) {
        Solution_피보나치수 solution_피보나치수 = new Solution_피보나치수();
        System.out.println(solution_피보나치수.solution(3));
        System.out.println(solution_피보나치수.solution(5));
    }
}

class Solution_피보나치수 {
    public int solution(int n) {
        long[] arr = new long[100001];
        arr[0] = 0L;
        arr[1] = 1L;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-2] + arr[i-1];
        }
        return (int) (arr[n]%1234567);
    }
}
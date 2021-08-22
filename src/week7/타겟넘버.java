package week7;

public class 타겟넘버 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1, 1, 1, 1, 1}, 3));
    }
}

class Solution {

    static int size, answer;
    static boolean[][] sign;

    public int solution(int[] numbers, int target) {
        answer = 0;
        size = numbers.length;
        sign = new boolean[size][2];

        dfs(numbers, target, 0, 0);

        return answer;
    }

    static void dfs(int[] numbers, int target, int idx, int tmp) {
        if (idx == size) {
            if (tmp == target) answer++;
            return;
        }

        for (int i = 0; i < 2; i++) {
            if (!sign[idx][i]) {
                tmp = addOrMinus(tmp, numbers[idx], i == 0);
                sign[idx][i] = true;
                dfs(numbers, target, idx + 1, tmp);
                tmp = addOrMinus(tmp, numbers[idx], !(i == 0));
                sign[idx][i] = false;
            }
        }
    }

    static int addOrMinus(int a, int b, boolean isAdd) {
        if (isAdd) {
            return a + b;
        } else {
            return a - b;
        }
    }
}
package codingtest.y2021.cafe24;

public class Tree {
    public static void main(String[] args) {
        Solution_Tree solution_tree = new Solution_Tree();
        int e = solution_tree.solution(new int[]{1, 2, 5, 7, 10, 15, 18, 20}, 17);
        System.out.println(e);
    }
}


class Solution_Tree {
    public int solution(int[] sortedArray, int findValue) {
        int answer = -1;

        int left = 0;
        int right = sortedArray.length-1;

        while (left < right) {
            int mid = (left+right)/2;

            // 찾음
            if (sortedArray[mid] == findValue) {
                answer = mid;
                break;
            }

            if (sortedArray[mid] < findValue) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}
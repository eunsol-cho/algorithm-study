package week14;

import java.util.Arrays;

public class Hindex {
    public static void main(String[] args) {
        Solution_Hindex solution_hindex = new Solution_Hindex();
        //int e = solution_hindex.solution(new int[] {3, 0, 6, 1, 5});
        int e = solution_hindex.solution(new int[] {3, 1, 1, 1, 4});
        System.out.println(e);
    }
}

class Solution_Hindex {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        int left = 0;
        int right = citations.length-1;

        while (left < right) {
            int mid = (left+right)/2;
            int h = citations[mid];
            if (mid-left+1 <= h && h <= right-mid+1) {
                int nextIdx = mid;
                while (nextIdx < citations.length && h < citations[nextIdx]) {
                    nextIdx++;
                }
                while (h < citations[nextIdx] && mid-left+1 <= h && h <= right-mid+1) {
                    h++;
                }

                answer = h;
                //left = mid+1;
                left = nextIdx;
            } else {
                right = mid-1;
            }
        }

        return answer;
    }
}

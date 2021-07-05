package simulation;

import java.util.Arrays;

// 프로그래머스 - k번째수 #level1
public class KthNumber {
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        KthNumber k = new KthNumber();
        int[] aswer = k.solution(arr, commands);

        for (int e : aswer){
            System.out.println("e = " + e);
        }

    }

    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        int r = 0;
        for (int[] round : commands) {
            int s = round[0];
            int e = round[1];

            int[] tmp = new int[e-s+1];
            int idx = 0;
            for (int i=s-1; i<e; i++) {
                tmp[idx] = array[i];
                idx++;
            }
            Arrays.sort(tmp);
            answer[r] = tmp[round[2]-1];
            r++;
        }

        return answer;
    }
}

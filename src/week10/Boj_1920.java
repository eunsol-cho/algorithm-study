package week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_1920 {
    static int N, M;
    static int[] target, ele, answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = Integer.parseInt(br.readLine());
        ele = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(target);

        int left, right, mid, result;
        for (int i = 0; i < ele.length; i++) {
            left = 0;
            right = target.length-1;
            result = 0;

            while (left <= right) {
                mid = (left+right)/2;

                if (target[mid] == ele[i]) {
                    result = 1;
                    break;
                }

                if (target[mid] < ele[i]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
            sb.append(result + "\n");
        }

        System.out.println(sb.toString());

    }
}

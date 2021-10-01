package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_11403_2 {
    static int N;
    static int[][] ans;
    static Map<Integer, ArrayList<Integer>> edge = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ans = new int[N][N];

        ArrayList<Integer> t;
        for (int i = 0; i < N; i++) {
            ans[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // Floyd-Warshall
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(ans[i][k] == 1 && ans[k][j] == 1) {
                        ans[i][j] = 1;
                    }
                }
            }
        }

        // print
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(ans[i][j] + " ");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }
}

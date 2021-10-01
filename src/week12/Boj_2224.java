package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_2224 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String reg = " => ";
        int c = 53;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[c][c];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            int from = (int) line.charAt(0);
            int to = (int) line.charAt(line.length()-1);

            from = (from >= 97) ? from - 97 + 26 : from - 65;
            to = (to >= 97) ? to - 97 + 26 : to - 65;
            arr[from][to] = 1;
        }

        for (int k = 0; k < c; k++) {
            for (int i = 0; i < c; i++) {
                for (int j = 0; j < c; j++) {
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }
            }
        }

        // 알파벳
        String[] alpha = new String[c];
        for (int i = 0; i < c; i++) {
            if (i < 26) {
                alpha[i] = String.valueOf((char) (i+65));
            } else {
                alpha[i] = String.valueOf((char) (i+97-26));
            }
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < c; j++) {
                if (i != j && arr[i][j] == 1) {
                    cnt++;
                    sb.append(alpha[i] + " => " + alpha[j] + "\n");
                }
            }
        }
        System.out.println(cnt);
        System.out.println(sb.toString());
    }
}

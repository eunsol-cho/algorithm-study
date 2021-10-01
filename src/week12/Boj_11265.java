package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_11265 {
    static int N, M;
    static long[][] party;
    static String OK = "Enjoy other party\n";
    static String NO = "Stay here\n";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        party = new long[N][N];

        for (int i = 0; i < N; i++) {
            party[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (party[i][k] > 0 && party[k][j] > 0 && party[i][j] > party[i][k] + party[k][j]) {

                        party[i][j] = party[i][k] + party[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] cmd = br.readLine().split(" ");
            int A = Integer.parseInt(cmd[0]) - 1;
            int B = Integer.parseInt(cmd[1]) - 1;
            long C = Long.parseLong(cmd[2]);

            if (party[A][B] > C) {
                sb.append(NO);
            } else {
                sb.append(OK);
            }
        }

        System.out.println(sb.toString());

    }
}

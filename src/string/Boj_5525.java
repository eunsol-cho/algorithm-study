package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_5525 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long M = Long.parseLong(br.readLine());
        char[] S = br.readLine().toCharArray();

        long ans = 0;
        long Pn = N + N + 1;
        for (int i = 0; i < S.length-Pn; i++) {
            boolean isExists = true;
            for (int j = i; j < i + Pn; j++) {
                if ((j - i)% 2 == 0) {
                    if (S[j] != 'I') {
                        isExists = false;
                        break;
                    }
                } else {
                    if (S[j] != 'O') {
                        isExists = false;
                        break;
                    }
                }
            }
            ans += isExists ? 1 : 0;
        }
        System.out.println(ans);
    }
}
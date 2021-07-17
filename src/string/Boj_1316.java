package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_1316 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int ans = 0;
        System.out.println((int) 'a' - 97);
        System.out.println((int) 'z' - 97);
        for (int i = 0; i < T; i++) {
            int[] alpha = new int[26];
            char[] arr = br.readLine().toCharArray();

            int prevIdx = (int) arr[0] - 97;
            boolean isGroup = true;
            for (int j=0; j<arr.length; j++) {
                int idx = (int) arr[j] - 97;
                isGroup = (prevIdx == idx) ? true : ((alpha[idx] == 0) ? true : false);
                if (!isGroup) {
                    break;
                }
                alpha[idx]++;
                prevIdx = idx;
            }
            if (isGroup) ans++;
        }
        System.out.println(ans);
    }
}

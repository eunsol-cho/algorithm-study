package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Boj_9375 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int t = Integer.parseInt(br.readLine());
            HashMap<String, Integer> clothes = new HashMap<>();
            for (int j = 0; j < t; j++) {
                String[] arr = br.readLine().split(" ");
                String gubun = arr[1];
                int cnt = clothes.getOrDefault(gubun, 0);
                clothes.put(gubun, cnt + 1);
            }
            System.out.println(getCases(clothes));
        }
    }

    private static int getCases(HashMap<String, Integer> clothes) {
        int ans = 1;
        for (String key : clothes.keySet()) {
            ans *= (clothes.get(key) + 1);
        }
        return ans - 1;
    }
}

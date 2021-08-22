package week7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_6443 {

    static int[] alphabat;
    static char[] arr, output;
    static int size;
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            alphabat = new int[26];
            arr = br.readLine().toCharArray();
            size = arr.length;
            for (int j = 0; j < size; j++) {
                alphabat[arr[j] - 'a']++;
            }
            output = new char[size];
            dfs(0);
            bw.flush();
        }
        bw.close();
    }

    static void dfs(int idx) throws Exception {
        if (idx == size) {
            print(output);
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (alphabat[i] > 0) {
                alphabat[i]--;
                output[idx] = (char) ('a' + i);
                dfs(idx + 1);
                alphabat[i]++;
            }
        }
    }

    static void print(char[] o) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (char e : o) {
            sb.append(e);
        }
        bw.write(sb.toString() + "\n");
    }
}

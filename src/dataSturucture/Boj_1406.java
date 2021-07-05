package dataSturucture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 에디터 #silver III
// 2021.07.05 22:21
public class Boj_1406 {
    private static Stack<String> LEFT = new Stack<>();
    private static Stack<String> RIGHT = new Stack<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        for (char e : str) {
            LEFT.push(String.valueOf(e));
        }

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] cmd = br.readLine().split(" ");
            if (cmd[0].equals("L")) {
                if (!LEFT.isEmpty()) {
                    RIGHT.push(LEFT.pop());
                }
            } else if (cmd[0].equals("D")) {
                if (!RIGHT.isEmpty()) {
                    LEFT.push(RIGHT.pop());
                }
            } else if (cmd[0].equals("B")) {
                if (!LEFT.isEmpty()) {
                    LEFT.pop();
                }
            } else if (cmd[0].equals("P")) {
                LEFT.push(cmd[1]);
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();

        while (!LEFT.isEmpty()) {
            RIGHT.push(LEFT.pop());
        }

        while (!RIGHT.isEmpty()) {
            sb.append(RIGHT.pop());
        }

        System.out.println(sb.toString());
    }
}

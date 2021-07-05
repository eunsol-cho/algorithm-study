package dataSturucture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 스택수열 #silver III
// 2021.07.05 21:04
public class Boj_1874 {

    private static StringBuilder sb = new StringBuilder();
    private static Stack<Integer> stack = new Stack<>();
    private static int[] seq;
    private static int e = 1;
    private static int idx = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        while (n >= e) {
            stack.push(e);
            sb.append("+\n");
            e++;
            doPop();
        }
        doPop();

        // 출력
        if (idx != n) {
            System.out.println("NO");
        } else {
            System.out.println(sb.toString());
        }
    }

    private static void doPop() {
        while (!stack.isEmpty() && stack.peek() == seq[idx]) {
            stack.pop();
            sb.append("-\n");
            idx++;
        }
    }
}

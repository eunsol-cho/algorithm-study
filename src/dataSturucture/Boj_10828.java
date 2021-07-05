package dataSturucture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 스택 #silver IV
// 2021.07.04 16:24
public class Boj_10828 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            String[] cmd = br.readLine().split(" ");
            if ("push".equals(cmd[0])) {
                stack.push(Integer.parseInt(cmd[1]));
            } else if ("pop".equals(cmd[0])) {
                if (stack.isEmpty()) {
                    sb.append("-1" + "\n");
                } else {
                    sb.append(stack.pop() + "\n");
                }
            } else if ("size".equals(cmd[0])) {
                sb.append(stack.size() + "\n");
            } else if ("empty".equals(cmd[0])) {
                sb.append(stack.isEmpty() ? "1" : "0");
                sb.append("\n");
            } else if ("top".equals(cmd[0])) {
                if (stack.isEmpty()) {
                    sb.append("-1" + "\n");
                } else {
                    sb.append(stack.peek() + "\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}

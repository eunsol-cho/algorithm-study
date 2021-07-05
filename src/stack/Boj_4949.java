package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 균형잡힌 세상 #sliver IV
// 2021.6.13 15:12
public class Boj_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        String str = "";
        Stack<Character> stack = new Stack();

        while ((str = br.readLine()) != null) {
            System.out.println("str = " + str);
            char[] chars = str.toCharArray();
            for (char e : chars) {
                if ('(' == e || '[' == e) {
                    stack.push(e);
                }

                if (!stack.isEmpty() && ')' == e && '(' == stack.peek()) {
                    stack.pop();
                }

                if (!stack.isEmpty() && ']' == e && '[' == stack.peek()) {
                    stack.pop();
                }

                if('.' == e) {
                    result.append(stack.isEmpty() ? "yes" : "no");
                    System.out.println(stack.isEmpty() ? "yes" : "no");
                    result.append("\n");
                }
                stack.clear();
            }
        }

        System.out.println("end");
        System.out.println(stack.toString());
    }
}

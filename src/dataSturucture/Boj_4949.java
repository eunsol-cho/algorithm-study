package dataSturucture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 균형잡힌 세상 #silver IV
// 2021.07.05 21:57
public class Boj_4949 {
    public static void main(String[] args) throws Exception {
        Stack<Character> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while (!".".equals(str = br.readLine())) {
            char[] chars = str.toCharArray();
            boolean isFail = false;
            for (char e : chars) {
                if ( e == '(' ) {
                    stack.push(e);
                } else if ( e == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        isFail = true;
                        break;
                    }
                } else if ( e == '[') {
                    stack.push(e);
                } else if ( e == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        isFail = true;
                        break;
                    }
                }
            }
            System.out.println(!isFail && stack.isEmpty() ? "yes" : "no");
            stack.clear();
        }

    }
}

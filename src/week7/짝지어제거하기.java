package week7;

import java.util.Stack;

public class 짝지어제거하기 {
    public static void main(String[] args) {
        Solution_01 s = new Solution_01();
        s.solution("baabaa");
    }
}

class Solution_01
{
    public int solution(String s)
    {
        char[] arr = s.toCharArray();
        int size = arr.length;
        Stack<Character> stack = new Stack();

        stack.push(arr[0]);
        for (int i=1; i<size; i++) {

            if(stack.isEmpty()) {
                stack.push(arr[i]);
                continue;
            }

            if(stack.peek() == arr[i]) {
                stack.pop();
                continue;
            }
            stack.push(arr[i]);
        }

        return stack.isEmpty() ? 1 : 0;
    }
}

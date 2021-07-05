package dataSturucture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

// 덱 #silver IV
// 2021.07.04
public class Boj_10866 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String[] cmd = br.readLine().split(" ");
            if ("push_front".equals(cmd[0])) {
                deque.addFirst(Integer.parseInt(cmd[1]));
            } else if ("push_back".equals(cmd[0])) {
                deque.addLast(Integer.parseInt(cmd[1]));
            } else if ("pop_front".equals(cmd[0])) {
                if (deque.isEmpty()) {
                    sb.append("-1" + "\n");
                } else {
                    sb.append(deque.pollFirst() + "\n");
                }
            } else if ("pop_back".equals(cmd[0])) {
                if (deque.isEmpty()) {
                    sb.append("-1" + "\n");
                } else {
                    sb.append(deque.pollLast() + "\n");
                }
            } else if ("size".equals(cmd[0])) {
                sb.append(deque.size() + "\n");
            } else if ("empty".equals(cmd[0])) {
                sb.append(deque.isEmpty() ? "1" : "0");
                sb.append("\n");
            } else if ("front".equals(cmd[0])) {
                if (deque.isEmpty()) {
                    sb.append("-1" + "\n");
                } else {
                    sb.append(deque.getFirst() + "\n");
                }
            } else if ("back".equals(cmd[0])) {
                if (deque.isEmpty()) {
                    sb.append("-1" + "\n");
                } else {
                    sb.append(deque.getLast() + "\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}

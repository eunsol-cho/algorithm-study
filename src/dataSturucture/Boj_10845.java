package dataSturucture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;



public class Boj_10845 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int last = 0;
        for (int i = 0; i < N; i++) {
            String[] cmd = br.readLine().split(" ");
            if ("push".equals(cmd[0])) {
                int num = Integer.parseInt(cmd[1]);
                last = num;
                queue.add(num);
            } else if ("pop".equals(cmd[0])) {
                if (queue.isEmpty()) {
                    sb.append("-1" + "\n");
                } else {
                    sb.append(queue.poll() + "\n");
                }
            } else if ("size".equals(cmd[0])) {
                sb.append(queue.size() + "\n");
            } else if ("empty".equals(cmd[0])) {
                sb.append(queue.isEmpty() ? "1" : "0");
                sb.append("\n");
            } else if ("front".equals(cmd[0])) {
                if (queue.isEmpty()) {
                    sb.append("-1" + "\n");
                } else {
                    sb.append(queue.peek() + "\n");
                }
            } else if ("back".equals(cmd[0])) {
                if (queue.isEmpty()) {
                    sb.append("-1" + "\n");
                } else {
                    sb.append(last + "\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}

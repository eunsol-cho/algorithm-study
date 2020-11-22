package twopointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11659
public class Boj_11659 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] sum = new int[N+1]; // 누적합 담을 배열
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                int num = Integer.parseInt(st.nextToken());
                sum[i] = num + sum[i-1];
            }
            // 부분합 출력
            for(int i=1; i<=M; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                System.out.println(sum[end] - sum[start-1]);
            }

            br.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

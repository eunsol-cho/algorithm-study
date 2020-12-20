package backtracking;

import java.util.Scanner;

public class Boj_9663 {
    static int N, cnt;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N]; // index => column, val => row
        doing(0);
        System.out.println(cnt);
    }
    static void doing(int col){
        if(col == N){
            cnt++;
            return;
        }

        for(int row=0; row<N; row++){
            arr[col] = row;
            if(possibility(col)){
                doing(col+ 1);
            }
        }
    }
    static boolean possibility(int col){
        for(int i=0; i<col; i++){
            // 같은 row에 존재할 경우
            if(arr[col] == arr[i]){
                return false;
            }
            // 대각선상에 존재할 경우 = row와 col차가 같은경우
            else if(Math.abs(col -i) == Math.abs(arr[col] - arr[i])){
                return false;
            }
        }
        return true;
    }
}

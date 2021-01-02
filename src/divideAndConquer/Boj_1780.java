package divideAndConquer;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1780 {
    static int N;
    static int[][] arr;
    static int[] cnt = new int[3];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        doing(N, 0, 0);
        Arrays.stream(cnt).forEach(System.out::println);
    }
    static void doing(int size, int x, int y){
        int tmp = arr[x][y];
        boolean flag = false;
        Loop1 : for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(arr[i][j] != tmp){
                    for (int l = 0; l < 3; l++) {
                        for (int m = 0; m < 3; m++) {
                            doing(size / 3, x + (size * l) / 3, y + (size * m) / 3);
                        }
                    }
                    flag = true;
                    break Loop1;
                }
            }
        }
        if(!flag) cnt[tmp+1]++;
    }
}

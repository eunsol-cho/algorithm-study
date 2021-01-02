package divideAndConquer;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2630 {
    static int N;
    static int[][] arr;
    static int[] cnt = new int[2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        doing(0, 0, N);
        Arrays.stream(cnt).forEach(System.out::println);
    }

    static void doing(int x, int y, int size){
        int tmp = arr[x][y];
        boolean flag = false;
        Loop1 : for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(tmp != arr[i][j]){
                    for(int l=0; l<2; l++){
                        for(int m=0; m<2; m++){
                            doing(x + (size*l)/2, y + (size*m)/2, size/2);
                        }
                    }
                    flag = true;
                    break Loop1;
                }
            }
        }
        if(!flag) cnt[tmp]++;
    }
}

package week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://burningjeong.tistory.com/307
public class Boj_2022 {

    static double x, y, c;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double[] arr = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        x = arr[0];
        y = arr[1];
        c = arr[2];

        double left = 0, right = Math.min(x, y), mid, height;

        int cnt = 100;
        while (cnt-- > 0) {
            mid = (left + right)/2;

            if (getHeight(mid) < c) {
                right = mid;
            } else {
                left = mid;
            }
        }

        System.out.println(left);
    }

    private static double getHeight(double w) {
        double h1 = Math.sqrt(x*x - w*w);
        double h2 = Math.sqrt(y*y - w*w);
        return (h1*h2)/(h1+h2);
    }
}

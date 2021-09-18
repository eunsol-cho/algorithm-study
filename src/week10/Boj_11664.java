package week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_11664 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double[] arr = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        Dot a = new Dot(arr[0], arr[1], arr[2]);
        Dot b = new Dot(arr[3], arr[4], arr[5]);
        Dot c = new Dot(arr[6], arr[7], arr[8]);

        double answer = Double.MAX_VALUE;
        double cToLeft, cToRight, cToMid;
        Dot l = a;
        Dot r = b;
        Dot mid;

        int cnt = 100;
        while (cnt-- > 0) {

            mid = getMid(l, r);
            System.out.println("Left > " + l.toString());
            System.out.println("Right > " + r.toString());
            System.out.println("Mid > " + mid.toString());
            System.out.println();

            cToLeft = getDistance(c, l);
            cToRight = getDistance(c, r);
            cToMid = getDistance(c, mid);
            System.out.println("cToLeft = " + cToLeft);
            System.out.println("cToRight = " + cToRight);
            System.out.println("cToMid = " + cToMid);
            System.out.println();
            System.out.println();


            /*if (Math.abs(cToMid - answer) < 0.00000000001) {
                break;
            }*/

            if (cToMid < answer) {
                answer = cToMid;
            }

            if (cToLeft < cToRight) {
                r = mid;
            } else {
                l = mid;
            }
        }

        System.out.println(answer);
    }

    private static Dot getMid(Dot l, Dot r) {
        return new Dot((r.x+l.x)/2, (r.y+l.y)/2, (r.z+l.z)/2);
    }

    private static double getDistance(Dot d1, Dot d2) {
        return Math.sqrt((d2.x-d1.x)*(d2.x-d1.x) + (d2.y-d1.y)*(d2.y-d1.y) * (d2.z-d1.z)*(d2.z-d1.z));
    }
}

class Dot {
    double x;
    double y;
    double z;

    public Dot(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "Dot{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
package codingtest.y2021.talentX;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'minArea' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY x
     *  2. INTEGER_ARRAY y
     *  3. INTEGER k
     */

    public static long minArea(List<Integer> x, List<Integer> y, int k) {
        // Write your code here
        int N = x.size();
        List<Point> points = new ArrayList();
        for (int i=0; i<N; i++) {
            points.add(new Point(x.get(i), y.get(i)));
        }
        Collections.sort(points, (p1, p2) -> p1.x - p2.x);

        int cnt = 0;
        long squar = 0;
        while (cnt < k) {
            squar = findMinDistancePoints(points);
            cnt += 2;
        }

        return squar*squar;
    }

    private static long findMinDistancePoints(List<Point> points) {

        System.out.println(points.size());
        TreeSet<Point> ps = new TreeSet<>((p1, p2) -> (p1.y==p2.y)?p1.x-p2.x:p1.y-p2.y);
        ps.add(points.get(0));
        ps.add(points.get(1));
        long dist = getDistance(points.get(0), points.get(1));
        int start = 0;

        for (int i=2; i<points.size(); i++) {
            Point p = points.get(i);
            while (start < i) {
                Point pN = points.get(start);
                int xGap = p.x - pN.x;
                if (xGap*xGap > dist) { // x좌표의 거리가 현재 구한값보다 크면 제외
                    ps.remove(pN);
                    start++;
                } else {
                    break;
                }
            }

            int d = (int) Math.sqrt((double) dist) + 1;
            Point pL = new Point(-100000, p.y-d);
            Point pH = new Point(100000, p.y+d);
            for (Point e : ps.subSet(pL, pH)) {
                long tmpDist = getDistance(p, e);
                dist = Math.min(dist, tmpDist);
            }
            ps.add(p);
        }

        List<Point> l = new ArrayList<>();
        System.out.println("---------" + dist);
        for (Point e : ps) {
            points.remove(e);
            int t = (int) Math.max(Math.abs(e.x), Math.abs(e.y));
            l.add(new Point(t, t));
            System.out.println(e.toString());
        }

        System.out.println(l.get(0).x);
        System.out.println(l.get(1).x);
        return (long) l.get(0).x + l.get(1).x + 2;
    }

    private static long getDistance(Point p1, Point p2) {
        return (long) (Math.pow((p1.x-p2.x),2)) + (long) (Math.pow((p1.y-p2.y),2));
    }

}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int xCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> x = IntStream.range(0, xCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int yCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> y = IntStream.range(0, yCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        long result = Result.minArea(x, y, k);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}

package codingtest.y2021.buketplace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A {
    public static void main(String[] args) {
        Solution_A solution_a = new Solution_A();

        //System.out.println(solution_a.solution(5, new int[]{4,3,2,3,5}));

        //System.out.println(solution_a.solution(4, new int[]{3,3,3,3}));
        System.out.println(solution_a.solution(7, new int[]{4,3,2,3,5,4,4}));
    }
}

class Solution_A {

    static boolean[] visit;
    public long solution(int N, int[] height) {
        long cnt = height.length-1;

        List<Hill> hills = new ArrayList<>();
        for (int i = 0; i < height.length; i++) {
            hills.add(new Hill(i, height[i]));
        }
        Collections.sort(hills);

        visit = new boolean[N];

        for (int i = 0; i < hills.size()-1; i++) {
            Hill hillA = hills.get(i);
            Hill hillB = hills.get(i+1);
            if(check(hillA.idx, hillB.idx)) continue;
            visit[hillA.idx] = true; visit[hillB.idx] = true;
            System.out.println(hillA.idx +","+ hillB.idx);
            int gap = Math.abs(hillA.idx - hillB.idx);
            if (gap == 1) continue;
            cnt++;
        }

        return cnt;
    }

    private boolean check(int idxA, int idxB) {
        int start = 0;
        int end = 0;
        if (idxA > idxB) {
            start = idxB;
            end = idxA;
        } else {
            start = idxA;
            end = idxB;
        }
        for (int i=start; i<end; i++) {
            if(visit[i]) return false;
        }
        return true;
    }
}

class Hill implements Comparable<Hill>{
    int idx;
    int h;

    public Hill(int idx, int h) {
        this.idx = idx;
        this.h = h;
    }

    @Override
    public int compareTo(Hill o) {
        if (o.h == this.h) return this.idx - o.idx;
        return o.h - this.h;
    }
}
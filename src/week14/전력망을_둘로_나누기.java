package week14;

public class 전력망을_둘로_나누기 {
    public static void main(String[] args) {
        Solution_전력망을_둘로_나누기 solution_전력망을_둘로_나누기 = new Solution_전력망을_둘로_나누기();
        int e = solution_전력망을_둘로_나누기.solution(9, new int[][] {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}});
        System.out.println(e);

    }
}

class Solution_전력망을_둘로_나누기 {

    static int[] parent;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int skip = 0; skip < n-1; skip++) {
            initParent(n);
            for (int w = 0; w < n-1; w++) {
                if (w == skip) continue; // 절단할 전선
                union(wires[w][0], wires[w][1]);
            }
            answer = Math.min(getCnt(n), answer);
        }

        return answer;
    }

    private int getCnt(int n) {
        int type = parent[1];
        int typeCnt = 1;
        for (int i = 2; i <= n; i++) {
            parent[i] = find(i);
            if (type == parent[i]) {
                typeCnt++;
            }
        }
        return Math.abs(typeCnt - (n-typeCnt));
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    // 상위노드 찾기
    private int find(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }

    private void initParent(int n) {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

}

class Solution_해답 {
    static int p[], MIN = 987654321;

    public int solution(int n, int[][] wires) {
        int answer = -1;
        for (int i = 0; i < n-1; i++) {
            init(n + 1);
            for (int j = 0; j < n - 1; j++) {
                if (j == i) continue;
                int a = wires[j][0];
                int b = wires[j][1];
                union(a, b);
            }
            check(n + 1);
        }
        answer = MIN;
        return answer;
    }

    static void check(int n) {
        int cnt = 1;
        for (int i = 2; i < n; i++) {
            p[i] = find(i);
            if (p[1] == p[i]) {
                cnt++;
            }
        }
        int cnt2 = n - 1 - cnt;
        int ans = Math.abs(cnt2 - cnt);
        MIN = Math.min(ans, MIN);
    }

    static void init(int n) {
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            p[b] = a;
        } else {
            p[a] = b;
        }
    }

    static int find(int a) {
        if (a == p[a]) {
            return a;
        }
        return p[a] = find(p[a]);
    }
}


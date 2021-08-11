package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1260 {

    private static int nodeNum = 0;        // 정점개수
    private static int edgeNum = 0;        // 간선개수
    private static int initNode = 0;    // 시작노드

    private static int[][] matrix;            // 인접노드 행렬
    private static boolean[] visited;    // 방문여부 행렬

    // BFS : 초기노드 큐에 offer후 방문표시 > 초기노드의 큐에서 poll(출력) 인접노드 큐에 offer 하면서 방문표시
    // 핵심) queue가 빌때까지
    private static void bfs(int initNode) {

        Queue<Integer> queue = new LinkedList<Integer>();

        queue.offer(initNode);
        visited[initNode] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + 1 + " ");

            for (int k = 0; k < nodeNum; k++) {
                if (matrix[node][k] == 1 && !visited[k]) { // 인접하고 방문하지 않았다면
                    queue.offer(k);
                    visited[k] = true;
                }
            }


        }

    }

    // DFS : 초기노드 방문후 > 인접노드 중 첫번째 방문 > 그 인접노드 중 첫번째 방문
    // 핵심) 재귀, 방문한 노드가 없을때 까지.
    private static void dfs(int node) {

        visited[node] = true;
        System.out.print(node + 1 + " ");

        for (int l = 0; l < nodeNum; l++) {
            if (matrix[node][l] == 1 && !visited[l]) {
                dfs(l);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        // 입력값 변수 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        nodeNum = Integer.parseInt(st.nextToken());
        edgeNum = Integer.parseInt(st.nextToken());
        initNode = Integer.parseInt(st.nextToken());

        // 행렬 초기화
        matrix = new int[nodeNum][nodeNum];
        visited = new boolean[nodeNum];

        Arrays.fill(visited, false);

        // 간선 연결
        for (int j = 0; j < edgeNum; j++) {
            String str1 = br.readLine();
            StringTokenizer st1 = new StringTokenizer(str1, " ");
            int a = Integer.parseInt(st1.nextToken()) - 1;
            int b = Integer.parseInt(st1.nextToken()) - 1;
            matrix[a][b] = 1;
            matrix[b][a] = 1;
        }

        dfs(initNode - 1);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(initNode - 1);

    }

}

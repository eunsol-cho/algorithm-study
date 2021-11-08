package week15;

import java.util.Arrays;

public class 프렌즈4블록 {
    public static void main(String[] args) {
        Solution_프렌즈4블록 solution_프렌즈4블록 = new Solution_프렌즈4블록();
        int e = solution_프렌즈4블록.solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"});
        System.out.println(e);
    }

}


class Solution_프렌즈4블록 {
    static char[][] arr;
    static int answer = 0;

    public int solution(int m, int n, String[] board) {
        arr = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = board[i].charAt(j);
            }
        }

        boolean[][] visit;
        char[] sqare;
        int prv = 0;
        while (true) {
            visit = new boolean[m][n];

            for (char[] e : arr) {
                for (char ee : e) {
                    System.out.print(ee);
                }
                System.out.println();
            }
            System.out.println();
            // 게임
            for (int i = 1; i < m; i++) {
                LoopA:
                for (int j = 1; j < n; j++) {
                    if (arr[i][j] == '0') continue LoopA; // 빈 블럭인경우 패스
                    // 왼쪽위, 위, 왼쪽 블럭이 같다면 사각형완성
                    sqare = new char[]{arr[i - 1][j - 1], arr[i][j - 1], arr[i - 1][j]};
                    for (char e : sqare) {
                        if (arr[i][j] != e) continue LoopA;
                    }
                    // 모두 같았다면 카운트 증가 (중복카운트 방지)
                    cnt(visit, i, j);
                }
            }

            if (prv == answer) break; // 이전 게임과 지워진 블럭수가 동일하다면 더이상 지워질게 없다고 판단

           // 중력적용
            for (int j = 0; j < n; j++) {
                LoopB : for (int i = m-1; i >= 0; i--) {
                    if (!visit[i][j]) continue; // 이번턴에 지워진곳만 확인
                    // 지워진 블럭일 경우
                    int t = i;
                    while (visit[t][j] && t >= 0) {
                        arr[t][j] = '0';
                        t--;
                    }
                    if (t < 0) break LoopB; // 위가 다 빈경우
                    int gap = i-t;
                    for (int k=i; k>t; k--) {
                        if (k-gap < 0) continue;
                        arr[k][j] = arr[k-gap][j];
                        arr[k-gap][j] = '0';
                    }
                    break LoopB;
                }
            }

            prv = answer;
        }

        return answer;
    }

    private void cnt(boolean[][] visit, int i, int j) {
        if (!visit[i][j]) {
            answer++;
            visit[i][j] = true;
        }
        if (!visit[i - 1][j]) {
            answer++;
            visit[i - 1][j] = true;
        }
        if (!visit[i][j - 1]) {
            answer++;
            visit[i][j - 1] = true;
        }
        if (!visit[i - 1][j - 1]) {
            answer++;
            visit[i - 1][j - 1] = true;
        }
        //System.out.println(i + "," + j);
    }

}
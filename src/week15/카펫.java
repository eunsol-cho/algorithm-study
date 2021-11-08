package week15;

public class 카펫 {
    public static void main(String[] args) {
        Solution_카펫 solution_카펫 = new Solution_카펫();
        //int[] e = solution_카펫.solution(10, 2);
        int[] e = solution_카펫.solution(24, 24);

        for (int i : e) {
            System.out.println(i);
        }
    }
}


class Solution_카펫 {
    public int[] solution(int brown, int yellow) {
        // h <= w
        int h = 3; // 1 <= yellow <= 2*10^6, 8 <= brown <= 5000
        int w = 3;
        int total = brown+yellow;

        while (true) {
            if (total % h == 0) { // 안나누어 떨어지면 pass
                w = total / h;
                if (yellow == (h-2)*(w-2) && brown == w*2+(h-2)*2) break;
            }
            h++;
        }
        return new int[]{w, h};
    }
}
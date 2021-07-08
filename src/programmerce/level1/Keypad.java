package programmerce.level1;

import java.util.HashMap;
import java.util.Map;

public class Keypad {

}

// 내풀이
class Solution_Keypad {
    static Map<Integer, XY> map = new HashMap();
    public String solution(int[] numbers, String hand) {

        // 좌표 초기화
        for (int i=0; i<4; i++) {
            for (int j=0; j<3; j++) {
                int num = j+i*3+1;
                if(num == 11) num = 0;
                map.put(num, new XY(i, j));
            }
        }

        // 시작위치
        int currentL = 10; // *
        int currentR = 12; // #

        StringBuilder sb = new StringBuilder();
        boolean isLeft = false;
        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                isLeft = true;
            } else if (number == 3 || number == 6 || number == 9) {
                isLeft = false;
            } else {
                int l = getDistance(currentL, number);
                int r = getDistance(currentR, number);
                if (l > r) {isLeft = false;}
                else if (l < r) {isLeft = true;}
                else if (l == r) {
                    if (hand.equals("left")) {
                        isLeft = true;
                    } else {
                        isLeft = false;
                    }
                }
            }

            if (isLeft) {
                currentL = number;
                sb.append("L");
            } else {
                currentR = number;
                sb.append("R");
            }
        }

        return sb.toString();
    }

    public int getDistance(int current, int target){
        XY cur = map.get(current);
        XY tar = map.get(target);

        return Math.abs(cur.getX() - tar.getX()) + Math.abs(cur.getY() - tar.getY());
    }
}

class XY {
    int x;
    int y;

    public XY(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public String toString(){
        return "x : " + x + ",y : " + y;
    }
}

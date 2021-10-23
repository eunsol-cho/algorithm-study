package week14;

import java.util.ArrayDeque;
import java.util.Queue;

public class 다리를지나는트럭 {
    public static void main(String[] args) {
        Solution_다리를지나는트럭 solution_다리를지나는트럭 = new Solution_다리를지나는트럭();
        int e = solution_다리를지나는트럭.solution(2, 10, new int[]{7, 4, 5, 6});
        System.out.println(e);
    }
}


class Solution_다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new ArrayDeque();
        for (int truck_weight : truck_weights) {
            q.add(truck_weight);
        }

        Queue<Truck> bridge = new ArrayDeque<>();
        int sec = 0;
        int curCnt = 0;
        int curWeight = 0;
        while (!q.isEmpty() || bridge.size() > 0) {
            // 다리 지남
            int size = bridge.size();
            while (size > 0) {
                Truck truck = bridge.poll();
                truck.move();
                if (truck.pos > bridge_length) {
                    curWeight -= truck.weight;
                    curCnt--;
                } else {
                    bridge.add(truck);
                }
                size--;
            }
            // 다리 올라탐
            if (!q.isEmpty() && curCnt < bridge_length && curWeight + q.peek() <= weight) {
                curWeight += q.peek();
                curCnt++;
                bridge.add(new Truck(1, q.poll()));
            }
            sec++;
        }

        return sec;
    }
}

class Truck {
    int pos = 0;
    int weight = 0;

    public Truck(int pos, int weight) {
        this.pos = pos;
        this.weight = weight;
    }

    public void move() {
        this.pos += 1;
    }
}
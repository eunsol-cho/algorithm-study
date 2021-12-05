package week1;

import java.util.*;

public class 캐시 {
    public static void main(String[] args) {
        Solution_캐시 solution_캐시 = new Solution_캐시();
        int e = solution_캐시.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"});
        System.out.println(e);
    }
}

class Solution_캐시 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize == 0) return cities.length * 5;

        LinkedList<String> l = new LinkedList<>();
        for (String city : cities) {
            city = city.toLowerCase();
            if (l.contains(city)) {
                l.remove(city);
                l.add(city);
                answer += 1;
            } else {
                answer += 5;
            }
            if (l.size() == cacheSize) {
                l.removeFirst();
            }
            l.add(city);
        }

        return answer;
    }
}
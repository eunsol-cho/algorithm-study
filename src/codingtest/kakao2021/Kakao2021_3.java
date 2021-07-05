/*
package codingtest.kakao2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 부분집합, 바이너리 서치
public class Kakao2021_3 {
    class Solution {
        Map<String, Integer> Wordmap = new HashMap<>();
        List<List<Integer>> ScoreList = new ArrayList<>();

        public int[] solution(String[] info, String[] query){

            Wordmap.put("-", 0);
            Wordmap.put("cpp", 1);
            Wordmap.put("java", 2);
            Wordmap.put("python", 3);
            Wordmap.put("backend", 1);
            Wordmap.put("frontend", 2);
            Wordmap.put("junior", 1);
            Wordmap.put("senior", 2);
            Wordmap.put("chicken", 1);
            Wordmap.put("pizza", 2);

            for (int i=0; i<4*3*3*3; ++i){
                ScoreList.add(new ArrayList<>());
            }

            for (String str : info){
                String[] word = str.split(" ");
                int[] arr = {Wordmap.get(word[0]),
                            Wordmap.get(word[1]),
                            Wordmap.get(word[2]),
                            Wordmap.get(word[3])};
                int score = Integer.parseInt(word[4]);

                for()
            }

            int[] answer = {};
            return answer;
        }
    }
}
*/

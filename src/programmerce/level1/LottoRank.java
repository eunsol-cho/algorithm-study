package programmerce.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.LongStream;

public class LottoRank {


}

// 내풀이
class Solution_LottoRank {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int[] arr = new int[46];
        for (int win_num : win_nums) {
            arr[win_num] = 1;
        }

        int cnt = 0;
        int correct = 0;
        for (int lotto : lottos) {
            if (lotto == 0) {
                cnt++;
            } else if (arr[lotto] == 1) {
                correct++;
            }
        }


        answer[0] = getRank(correct + cnt);
        answer[1] = getRank(correct);

        return answer;
    }

    public int getRank(int cnt){
        if (cnt <= 1) {
            return 6;
        } else {
            return 7-cnt;
        }
    }
}

// TODO 람다 활용풀이
class Solution_LottoRank2 {
    public int[] solution(int[] lottos, int[] winNums) {
        return LongStream.of(
                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l) || l == 0).count(),
                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l)).count()
        )
                .mapToInt(op -> (int) (op > 6 ? op - 1 : op))
                .toArray();
    }
}
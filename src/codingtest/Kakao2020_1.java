package codingtest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;

// https://tech.kakao.com/2021/01/25/2021-kakao-recruitment-round-1/
public class Kakao2020_1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("result = " + "bat.y.abcdefghi".equals(solution.solution(	"...!@BaT#*..y.abcdefghijklm")));
        System.out.println("result = " + "z--".equals(solution.solution(		"z-+.^.")));
        System.out.println("result = " + "aaa".equals(solution.solution(		"=.=")));
        System.out.println("result = " + "123_.def".equals(solution.solution(	"123_.def")));
        System.out.println("result = " + "abcdefghijklmn".equals(solution.solution(	"abcdefghijklmn.p")));
    }

    static class Solution {
        public String solution(String new_id) {
            String answer = "";
            // https://fblens.com/entry/JAVA-Array%EB%A5%BC-List%EB%A1%9C-List%EB%A5%BC-Array%EB%A1%9C
            // 1) 소문자로
            LinkedList<Character> list = new LinkedList<>(new_id.toLowerCase().chars().mapToObj(x -> (char)x).collect(Collectors.toList()));
            ArrayList<Integer> rm = new ArrayList<>();
            for (int i=0; i<list.size(); i++) {
                Character c = list.get(i);
                // 2) 소문자, 숫자, -, _, . 제외한 문자 제외
                if(('a' <= c && c <= 'z') || ('0' <= c && c <= '9') || c == '-' || c == '_' || c == '.'){
                    // 3) .. -> .
                    // 4) . 처음 or 끝이면 제거
                    if(c == '.' && (answer.length() == 0 || answer.endsWith("."))) continue;
                    answer += c;
                }
                // 6) 15자리 이후 버림 -> .끝이면 제거
                if(answer.length() == 15) {
                    if(answer.endsWith(".")) answer = answer.substring(0, 14);
                    break;
                }
            }
            // 5) 빈문자 -> a
            if(answer.length() == 0) answer = "a";

            int len = answer.length();
            // .끝이면 제거
            if(answer.endsWith(".")) answer = answer.substring(0, len-1);
            // 7) 2자리 이하, 3자리 될때까지 마지막 문자 반복
            len = answer.length();
            if(len <= 2){
                char last = answer.charAt(len-1);
                for (int i=0; i<3-len; i++){
                    answer += last;
                }
            }
            //System.out.println("answer = " + answer);
            return answer;
        }
    }
}

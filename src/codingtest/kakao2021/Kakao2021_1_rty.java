package codingtest.kakao2021;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;

// https://tech.kakao.com/2021/01/25/2021-kakao-recruitment-round-1/
public class Kakao2021_1_rty {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("result = " + "bat.y.abcdefghi".equals(solution.solution(	"...!@BaT#*..y.abcdefghijklm")));
        System.out.println("result = " + "z--".equals(solution.solution(		"z-+.^.")));
        System.out.println("result = " + "aaa".equals(solution.solution(		"=.=")));
        System.out.println("result = " + "123_.def".equals(solution.solution(	"123_.def")));
        System.out.println("result = " + "abcdefghijklmn".equals(solution.solution(	"abcdefghijklmn.p")));
    }

    static class Solution {
        boolean isValid(char c){
            if(Character.isLetterOrDigit(c)) return true; // v
            if(c == '-' || c == '_' || c == '.') return true;
            return false;
        }
        public String solution(String new_id) {
            StringBuilder answer = new StringBuilder(); // v String일 경우 매번 새로운 객체를 생성

            boolean lastDot = false;
            for(char ch : new_id.toCharArray()){
                if(isValid(ch) == false) continue;
                if(ch == '.'){
                    if(answer.length() == 0 || lastDot) continue;
                    lastDot = true;
                } else {
                    lastDot = false;
                }

                ch = Character.toLowerCase(ch); // v
                answer.append(ch);
            }

            if(answer.length() >= 16)
                answer.setLength(15); // v

            if(answer.length() == 0)
                answer.append('a');

            if(answer.charAt(answer.length() - 1) == '.')
                answer.deleteCharAt(answer.length() - 1); // v

            if(answer.length() <= 2){
                char c = answer.charAt(answer.length() - 1);
                while (answer.length() < 3){
                    answer.append(c);
                }
            }

            return answer.toString();
        }
    }
}

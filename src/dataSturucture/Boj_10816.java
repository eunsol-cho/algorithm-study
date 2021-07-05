package dataSturucture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

// 숫자 카드 2 #silver IV
// 2021.07.05 21:40
public class Boj_10816 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] cards = br.readLine().split(" ");

        int m = Integer.parseInt(br.readLine());
        String[] candis = br.readLine().split(" ");

        HashMap<String, Integer> map = new HashMap<>();
        for (String card : cards){
            if (map.containsKey(card)) {
                int tmp = map.get(card);
                map.put(card, tmp+1);
            } else {
                map.put(card, 1);
            }
        }

        for (String candi :candis) {
            if (map.containsKey(candi)) {
                sb.append(map.get(candi) + " ");
            } else {
                sb.append("0 ");
            }
        }

        String result = sb.toString();
        System.out.println(result.substring(0, result.length()-1));

    }
}

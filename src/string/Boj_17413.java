package string;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Boj_17413 {
    public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();

        Pattern p = Pattern.compile("(<.+?>)");
        Matcher m = p.matcher(str);

        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            String[] arr = str.substring(idx, m.start()).split(" ");
            sb.append(reverse(arr));
            sb.append(m.group());
            idx = m.end();
        }

        String[] remain = str.substring(idx, str.length()).split(" ");
        sb.append(reverse(remain));
        System.out.println(sb.toString());
    }

    static String reverse(String[] str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(new StringBuilder(str[i]).reverse());
            if (i != str.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
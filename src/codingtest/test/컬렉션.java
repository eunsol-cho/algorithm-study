package codingtest.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 컬렉션 {
    public static void main(String[] args) {
          List l = Arrays.asList(new Integer[]{1,2,3,4,5});
          List l2 = new ArrayList(Arrays.asList(new Integer[]{1,2,3,4,5}));
          l2.add(6);

    }
}

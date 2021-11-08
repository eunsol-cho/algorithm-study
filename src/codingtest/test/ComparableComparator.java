package codingtest.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparableComparator {
    public static void main(String[] args) {
        List<ClassA> l = new ArrayList<>();
        l.add(new ClassA(1));
        l.add(new ClassA(7));
        l.add(new ClassA(9));
        l.add(new ClassA(2));

        l.stream().forEach(System.out::println);
        //Collections.sort(l);
        System.out.println("===");
        l.stream().forEach(System.out::println);
    }
}


class ClassA implements Comparable<ClassA>, Comparator<ClassA> {
    int num;

    public ClassA(int num) {
        this.num = num;
    }

    @Override
    public int compare(ClassA o1, ClassA o2) {
        return o1.num - o2.num;
    }

    @Override
    public int compareTo(ClassA o) {
        return o.num - this.num;
    }

    @Override
    public String toString() {
        return "ClassA{" +
                "num=" + num +
                '}';
    }
}

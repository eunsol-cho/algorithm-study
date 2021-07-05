package dataSturucture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 베스트셀러 #silver IV
// 2021.07.05 22:36
public class Boj_1302 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Book> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Book book = new Book(br.readLine(), 1);
            if (list.contains(book)) {
                int idx = list.indexOf(book);
                list.get(idx).addCnt();
            } else {
                list.add(book);
            }
        }

        Collections.sort(list);

        System.out.println(list.get(0).getName());
    }
}

class Book implements Comparable<Book> {
    private String name;
    private int cnt;

    public Book(String name, int cnt) {
        this.name = name;
        this.cnt = cnt;
    }

    public String getName() {
        return name;
    }

    public int getCnt() {
        return cnt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name);
    }

    @Override
    public int compareTo(Book o) {
        if (o.getCnt() - cnt == 0) {
            return name.compareTo(o.getName()); // TODO comparable 익히기. comparator 비교
        }
        return o.getCnt() - cnt;
    }

    public void addCnt() {
        cnt++;
    }
}
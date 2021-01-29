package dataSturucture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class Boj_5568 {

    static int n, k;
    static int[] arr;
    static Set<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n];
        set = new TreeSet<>();

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        String number;
        LinkedList<Integer> list = new LinkedList();
        dfs(list);

    }
    public static void dfs(LinkedList<Integer> list){
        if(list.size() == k){
            for(int e : list){
                System.out.print(e);
            }
            System.out.println();
            return;
        }
        for(int i=0; i<n; i++){
            if(!list.contains(i)) list.add(i);
            dfs(list);
            list.removeLast();
        }
    }
}

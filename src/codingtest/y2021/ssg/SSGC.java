package codingtest.y2021.ssg;

import java.util.*;

public class SSGC {
    public static void main(String[] args) {
        Solution_SSGC solution_ssgc = new Solution_SSGC();
        String[] e = solution_ssgc.solution(new String[]{"PIZER 3 20 99", "ASTRA 1 9 55", "YANSEN 10000 22 49"}
                        , new String[]{"susan 50 ASTRA YANSEN PIZER","kevin 55 ASTRA","luka 60 PIZER ASTRA","erica 20 YANSEN PIZER ASTRA","roy 20 PIZER"});
        Arrays.stream(e).forEach(System.out::println);
    }
}


class Solution_SSGC {
    static Map<String, Vaccine> vaccines = new HashMap<>();
    static Map<String, Booker> bookers = new HashMap<>();
    static Map<String, List<String>> result = new HashMap<>();
    public String[] solution(String[] vac, String[] peo) {
        setVaccines(vac);
        setBookers(peo);

        // 정렬
        List<Map.Entry<String, Booker>> sortedBookers = new ArrayList(bookers.entrySet());
        sortedBookers.sort(Map.Entry.comparingByValue());

        Map.Entry<String, Booker> entry;
        Booker booker;
        List<String> hopeVaccines;
        List<String> successBookers;
        for (int i = 0; i < sortedBookers.size(); i++) {
            entry = sortedBookers.get(i);
            booker = entry.getValue();
            hopeVaccines = booker.hopeVaccines;
            Vaccine vaccine;
            for (String hopeVaccine : hopeVaccines) {
                vaccine = vaccines.get(hopeVaccine);
                if (vaccine.isAbleTo(booker.age)) {
                    vaccine.use();
                    successBookers = result.getOrDefault(vaccine.name, new ArrayList<>());
                    successBookers.add(booker.name);
                    result.put(vaccine.name, successBookers);
                    break;
                }
            }
        }

        // 정렬
        List<Map.Entry<String, List<String>>> sortedResult = new ArrayList(result.entrySet());
        for (Map.Entry<String, List<String>> e : sortedResult) Collections.sort(e.getValue());
        sortedResult.sort(Map.Entry.comparingByKey());

        // 리턴문자열 만들기
        String[] answer = new String[sortedResult.size()];
        Map.Entry<String, List<String>> ety;
        for (int i = 0; i < answer.length; i++) {
            ety = sortedResult.get(i);
            answer[i] = ety.getKey() + " " + String.join(" ", ety.getValue());
        }

        return answer;
    }

    private void setVaccines(String[] vac) {
        for (String v : vac) {
            String[] s = v.split(" ");
            vaccines.put(s[0], new Vaccine(s[0], s[1], s[2], s[3]));
        }
    }

    private void setBookers(String[] peo) {
        List<String> hopeVaccines;
        String p;
        for (int i = 0; i < peo.length; i++) {
            String[] s = peo[i].split(" ");
            hopeVaccines = new ArrayList<>();
            for (int j = 2; j < s.length; j++) {
                hopeVaccines.add(s[j]);
            }
            bookers.put(s[0], new Booker(i, s[0], s[1], hopeVaccines));
        }
    }
}
class Booker implements Comparable<Booker>{
    int no;
    String name;
    int age;
    List<String> hopeVaccines;

    public Booker(int no, String name, String age, List<String> hopeVaccines) {
        this.no = no;
        this.name = name;
        this.age = Integer.parseInt(age);
        this.hopeVaccines = hopeVaccines;
    }

    @Override
    public int compareTo(Booker o) {
        if (o.age == this.age) return this.no - o.no;
        return o.age - this.age;
    }
}

class Vaccine {
    String name;
    int stock;
    int minAge;
    int maxAge;

    public Vaccine(String name, String stock, String minAge, String maxAge) {
        this.name = name;
        this.stock = Integer.parseInt(stock);
        this.minAge = Integer.parseInt(minAge);
        this.maxAge = Integer.parseInt(maxAge);
    }

    public boolean isAbleTo(int age){
        return hasStock() && isPossibleAge(age);
    }

    private boolean isPossibleAge(int age){
        return minAge <= age && maxAge >= age;
    }

    private boolean hasStock(){
        return stock > 0;
    }

    public void use(){
        stock--;
    }
}
package java8.optionaltest;

import java8.domain.OnlineClass;
import java8.domain.Progress;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalTestApp {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data optional", true));

        // optional을 리턴하는 stream의 메서드는 종료형 operation이라 할수잇다.
        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle()
                .startsWith("optional"))
                .findFirst();

        boolean present = optional.isPresent();
        boolean empty = optional.isEmpty(); // Java11 부터 제공
        System.out.println(present); // false
        System.out.println(empty); // true;

        /**
         * optional 내부값 가져오기
         * */

        // 1. get()
        //OnlineClass onlineClass = optional.get(); // NoSuchElementException 발생

        // 2. isPresent() + get() = 먼저 확인후 꺼낸다 -> 번거롭다
        /*if (optional.isPresent()) {
            OnlineClass onlineClass = optional.get();
            System.out.println(onlineClass.getTitle());
        }*/

        // 3. ifPresent(Consumer) = 값이 있는 경우만 함수가 동작한다!
        optional.ifPresent(oc -> System.out.println(oc.getTitle()));

        // 4. orElse() = 값이 없는 경우 리턴할 객체를 넣어줌 (이는 기존 Optional이 감싸고 있던 인스턴스 타입이다.)
        // BUT, 이경우 값이 있던 없던 createNewClass()가 실행은 됨. (리턴은 있는경우 그게 리턴되나 createNewClass 함수는 실행이됨)
        // 이미 만들어진 인스턴스를 사용한다면 orElse 함수로 만들어 줘야한다면, orElseGet권장!
        OnlineClass onlineClass = optional.orElse(createNewClass());
        System.out.println(onlineClass.getTitle());

        // 5. orElseGet(Supplier) = 값이 없는 경우만 createNewClass 실행
        OnlineClass onlineClass1 = optional.orElseGet(OptionalTestApp::createNewClass);
        System.out.println(onlineClass1.getTitle());

        // 6. orElseThrow(Supplier)
        OnlineClass onlineClass2 = optional.orElseThrow(() -> {
            return new IllegalArgumentException();
        });
        // 메소드 레퍼런스 사용
        OnlineClass onlineClass3 = optional.orElseThrow(IllegalArgumentException::new);

        // 7. Optional filter(Predicate) = Optional타입이 리턴됨
        Optional<OnlineClass> onlineClass4 = optional.filter(oc -> oc.getId() > 10);

        // 8. Optional map(Function) = map으로 변환한 타입을 Optional로 감싸서 리턴함
        Optional<Integer> integer = optional.map(OnlineClass::getId);
        // Optional을 리턴하는 경우 굉장히 복잡해짐
        Optional<Optional<Progress>> progress = optional.map(OnlineClass::getProgress);
        Optional<Progress> progress1 = progress.orElse(Optional.empty());

        // 9. Optional flatMap(Function)
        Optional<Progress> progress2 = optional.flatMap(OnlineClass::getProgress);

    }

    private static OnlineClass createNewClass() {
        System.out.println("createNewClass 함수 실행");
        return new OnlineClass(10 ,"New class", false);
    }
}

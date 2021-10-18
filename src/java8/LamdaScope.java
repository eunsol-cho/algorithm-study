package java8;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class LamdaScope {
    public static void main(String[] args) {
        LamdaScope LamdaScope = new LamdaScope();
        LamdaScope.run();
    }

    private void run() {
        final int baseNumber = 10; // final을 생략 할수 있는경우 = 실제 더이상 변경하지 않는경우 (effectively final)

        // 로컬 클래스 (local class)
        class LocalClass {
            void printBaseNumber() {
                //int baseNumber = 12;
                System.out.println(baseNumber);
            }
        }

        // 익명 클래스 (anonymous class)
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer i) {
                //int baseNumber = 11;
                System.out.println(i + baseNumber);
            }
        };

        // 람다 (Lamda)
        IntConsumer printInt = (i) -> {
            // int baseNumber = 1; // 같은 scope안에 같은 변수명을 사용할 수 없다. 컴파일 에러
            System.out.println(i + baseNumber); // 로컬변수 참조
        };

        new LocalClass().printBaseNumber(); // 12
        integerConsumer.accept(10); // 21
        printInt.accept(10); // 20
    }
}
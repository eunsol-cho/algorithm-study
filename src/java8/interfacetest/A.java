package java8.interfacetest;

public interface A {
    /**
     * @implSpec 이 구현체는 getName()가져온 문자열을 대문자로 바꿔 출력한다.
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    // default String toString() { return ""; } → Object메소드 재정의시 컴파일 에러
    String toString(); // 선언은 가능 → 추상메서드라고 하기엔 모든 interface생성시 기본으로 제공, 특별히 개정의 필요할때만 문서화를 추가해 작성

    void printName();

    String getName();
}
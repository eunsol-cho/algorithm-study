package java8.optionaltest;

import java8.domain.OnlineClass;
import java8.domain.Progress;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OptionalTestApp {
    public static void main(String[] args) {

        // 이슈상황
        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
        Duration studyDuration = spring_boot.getProgress().getStudyDuration();// NullPointExecption 발생
        System.out.println(studyDuration);

        // 기존 해결방법
        // 문제1. 이는 사람이 빼먹으면 에러
        // 문제2. null을 리턴하다니
        Progress progress = spring_boot.getProgress();
        if (progress != null) {
            System.out.println(progress.getStudyDuration());
        }

    }
}

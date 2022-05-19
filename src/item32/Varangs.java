package item32;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Varangs {

    static void dangerous(List<String>... stringLists){
        List<Integer> intList=List.of(42);
        Object[] objects=stringLists;
        objects[0]=intList;                  // 힙 오염 발생.
        String s=stringLists[0].get(0);      // ClassCastException
    }

    // 메서드가 반환하는 배열의 타입은 이 메서드에 인수를 넘기는 컴파일 타임에 결정 되는데, 그 시점에는 컴파일러에게
    // 충분한 정보가 주어지지 않아 타입을 잘못 판단 할 수 있다.
    // 그러므로 그대로 배열을 반환하다간 힙 오염이 생길 수 있다.
    static <T> T[] toArray(T... args){
        return args;
    }

    static <T> T[] pickTwo(T a, T b, T c){
        switch (ThreadLocalRandom.current().nextInt(3)){
            case 0: return toArray(a,b);
            case 1: return toArray(a,c);
            case 2: return toArray(b,c);
        }
        throw new AssertionError();
    }

    static <T> List<T> pickTwoSafetyV(T a, T b, T c){
        switch (ThreadLocalRandom.current().nextInt(3)){
            case 0: return List.of(a,b);
            case 1: return List.of(a,c);
            case 2: return List.of(b,c);
        }
        throw new AssertionError();
    }

    @SafeVarargs
    static <T> List<T> flattenV1(List<? extends T>... lists){
        List<T> result=new ArrayList<>();
        for(List<? extends T> list : lists){
            result.addAll(list);
        }
        return result;
    }

    static <T> List<T> flattenV2(List<List<? extends T>> lists){
        List<T> result=new ArrayList<>();
        for(List<? extends T> list : lists){
            result.addAll(list);
        }
        return result;
    }

    public static void main(String[] args){
        /**
         * toArray에서 가변 매개변수는 Object[]를 생성한다.
         * 왜냐면, pickTwo에 어떤 타입의 객체를 넘기더라도 담을 수 있는 가장 구체적인 타입이기 때문이다.
         * 물론, 지금의 코드가 별 다른 문제 없이 컴파일 되긴 하지만
         * ClassCastException이 발생하게 된다.
         * Object[]는 String[]의 하위 타입이 아니기 때문이다.
         */
        String[] attributes = pickTwo("좋은","빠른","저렴한");

        List<String> safeAttributes = pickTwoSafetyV("좋은", "빠른", "저렴한");
    }
}

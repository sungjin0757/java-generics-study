package item31;

import java.util.List;

public class Swap {

    // 비한정적 타입 매개변수
    public static <E> void swapV1(List<E> list, int i, int j){

    }

    // 비한정적 와일드카드

    /**
     *
     * recommended
     * 기본 규칙이 메서드 선언에 타입 매개변수가 한 번만 나오면 와일드 카드로 대체하라 입니다.
     * but, 이 메소드만 사용하면 컴파일 에러가 발생하게 됩니다.
     * 비 한정적 와일드 카드를 사용할 경우 null 외에는 어떤 값도 넣을 수 없기 때문이죠.
     * 그래서, 메소드를 한 가지 더 사용합니다.
     * 좀 더 복잡하더라도 클라리언트는 덕분에 swapHelper의 존재를 모르고 바로 사용할 수 있습니다.
     */
    public static void swapV2(List<?> list, int i, int j){
        swapHelper(list,i,j);
    }

    private static <E> void swapHelper(List<E> list, int i, int j){
        list.set(i,list.set(j,list.get(i)));
    }
}

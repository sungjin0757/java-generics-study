package item28;

import java.util.ArrayList;
import java.util.List;

public class TypeCasting {

    public static void main(String[] args){
        Object[] objectArray=new Long[1];
        objectArray[0]="타입이 달라 넣을 수 없음!";  //ArrayStoreException 발생.

//        List<Object> o1=new ArrayList<Long>(); // 호환되지 않는 타입.
//        o1.add("타입이 달라 넣을 수 없다!");

        // 제네릭 소거 방식 : 제네릭은 타입 정보가 런타임에는 소거된다. 원소 타입을 컴파일타임에만 검사하며 런타임에는 알 수 없다.
        List<String>[] stringLists=new List<String>[1]; //제네릭 배열은 이용할 수 없다.
        List<Integer> intList=List.of(42);
        Object[] objects=stringLists; // 배열은 공변이니 아무 문제 없다.
        objects[0]=intList; //제네릭은 소거방식이기 때문에 타입에 대한 정보를 모르니 이러한 것도 성공한다.
        // 즉, 런타임에는 List<String>[]는 단순히 List[]가 되고 List<Integer>는 List가 된다.
        String s= stringLists[0].get(0);
        /**
         * 여기서 문제, 컴파일러는 원소를 꺼내고 자동으로 String으로 저장하려는데 이 원소는 Integer이므로 ClassCastException이
         * 발생하게 된다.
         * 제네릭의 목적은 ClassCastException을 없애고자 하는 것인데 문제가 있다.
         */
    }
}

package item30;

import java.util.HashSet;
import java.util.Set;

public class MySet {

    //컴파일은 되지만 경고가 두 개 발생한다. 경고가 나오는 이유는 메소드가 타입 안전하지 않기 때문이다. 타입 매개변수를 지정해줘야 한다.
//    public static Set union(Set s1,Set s2){
//        Set result=new HashSet(s1);
//        result.addAll(s2);
//        return result;
//    }

    public static <E> Set<E> union(Set<E> s1,Set<E> s2){
        Set<E> result=new HashSet(s1);
        result.addAll(s2);
        return result;
    }
}

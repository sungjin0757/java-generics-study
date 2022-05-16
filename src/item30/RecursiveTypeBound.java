package item30;

import java.util.Collection;
import java.util.Objects;

public class RecursiveTypeBound {

    public static <E extends Comparable<E>> E max(Collection<E> c){
        if(c.isEmpty()){
            throw new IllegalArgumentException();
        }
        E res=null;
        for(E e : c){
            if(res==null || e.compareTo(res)>0){
                res= Objects.requireNonNull(e);
            }
        }

        return res;
    }
}

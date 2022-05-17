package item31;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ScheduledFuture;

public class RecursiveTypeBound {

    public static <E extends Comparable<? super E>> E max(List<? extends E> c){
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

    public static void main(String[] args){
        /**
         * scheduledFuture는 delayed를 확장했고, delayed는 compable를 확장했으므로 max의 parameter로 사용가능하게 된다.
         */
        List<ScheduledFuture<?>> scheduledFutures=new ArrayList<>();

        max(scheduledFutures);
    }
}

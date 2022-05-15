package item26;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class Stamp {
    // raw type
    private static final List stamps=new ArrayList();

    // recommended
    private static final List<Stamp> stampsRecommended=new ArrayList<>();

    private static void ListStringParameterMethod(List<String> list){

    }

    private static void unsafeAdd(List list, Object o){
        list.add(o);
    }

    private static int numElementsInCommon(Set s1,Set s2){
        int res=0;
        for(Object o1 : s1){
            if(s2.contains(o1))
                res++;
        }
        return res;
    }

    // Error
//    private static void addItemTest(Set<?> s){
//        s.add("Hello");
//    }

    private static void rawTypeException(Object o){
        if(o instanceof Set){
            Set<?> s = (Set<?>) o;
        }
    }

    public static void main(String[] args){
        stamps.add(new Coin());
        stamps.add(new Coin());

//        for(Iterator i= stamps.iterator();i.hasNext();){
//            Stamp stamp=(Stamp) i.next();
//
//        }

        List<Object> objectList =new ArrayList<>();
        List<String> stringList =new ArrayList<>();
//        ListStringParameterMethod(objectList);
        ListStringParameterMethod(stringList);

        unsafeAdd(stringList,Integer.valueOf(42));
        String s= stringList.get(0);
    }
}

class Coin{

}

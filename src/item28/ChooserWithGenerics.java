package item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserWithGenerics <T>{
    private final List<T> choiceList;

    public ChooserWithGenerics(Collection<T> choices){
        choiceList=new ArrayList<>(choices);
    }

    public T choose(){
        Random rd= ThreadLocalRandom.current();
        return choiceList.get(rd.nextInt(choiceList.size()));
    }
}

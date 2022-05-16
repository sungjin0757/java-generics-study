package item28;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserWithGenericsWithProblem<T> {
    private final T[] choiceArray;

    public ChooserWithGenericsWithProblem(Collection<T> choices) {
        this.choiceArray = (T[])choices.toArray();
    }
    public Object choose(){
        Random rd= ThreadLocalRandom.current();
        return choiceArray[rd.nextInt(choiceArray.length)];
    }
}

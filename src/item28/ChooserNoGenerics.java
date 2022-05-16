package item28;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserNoGenerics {
    private final Object[] choiceArray;

    public ChooserNoGenerics(Collection choices){
        choiceArray= choices.toArray();
    }

    // 클라이언트가 사용할 때, 타입 형변환 오류가 발생하기 쉬움. 제네릭을 사용하자.
    public Object choose(){
        Random rd= ThreadLocalRandom.current();
        return choiceArray[rd.nextInt(choiceArray.length)];
    }
}

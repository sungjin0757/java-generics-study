package item28;

public class MakeArrayToMyType <E>{
    E[] elements;

    public void init(){
        // new 연산자 사용불가. new 연산자는 compile 시점에 정확한 타입을 알고 있어야합니다.
        elements=new E[4];
    }
}

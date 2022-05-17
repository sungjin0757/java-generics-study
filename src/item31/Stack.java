package item31;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.Iterator;

class Stack<E> {
    private Object[] elements;
    private int size=0;
    private static final int DEFAULT_CAPACITY_SIZE=16;

    public Stack() {
        // 컴파일러는 오류대신 경고를 내보낸다. 타입 안전하지 않기 때문이다.
        elements=(E[])new Object[DEFAULT_CAPACITY_SIZE];
    }

    public void push(E e){
        ensureCapacity();
        elements[size++]=e;
    }

    public E pop(){
        if(size==0){
            throw new EmptyStackException();
        }

        //push에서 E 타입만 허용하므로 이 형변환은 안전하다.
        @SuppressWarnings("unchecked") E result=(E) elements[--size];
        elements[size]=null;
        return result;
    }

    /**
     *
     * List<String>은 자칫 List<Object>의 하위 타입같이 보이지만, 하위 타입이 아닙니다. 즉, 논리적인 상황으론
     * 맞지만, 실제로는 오류를 발생하게 됩니다.
     * 이럴때는 와일드 카드를 정의해야합니다.
     */
    public void pushAllV1(Iterable<E> src){
        for(E e : src){
            push(e);
        }
    }

    //와일드 카드 정의된 버전.
    public void pushAllV2(Iterable<? extends E> src){
        for(E e : src){
            push(e);
        }
    }

    public void popAll(Collection<? super E> dst){
        while(!isEmpty()){
            dst.add(pop());
        }
    }

    public boolean isEmpty(){
        return size==0;
    }

    private void ensureCapacity(){
        if(elements.length==size){
            elements= Arrays.copyOf(elements,2*size+1);
        }
    }

}



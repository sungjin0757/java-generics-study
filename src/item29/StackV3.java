package item29;

import java.util.Arrays;
import java.util.EmptyStackException;

@SuppressWarnings("unchecked")
public class StackV3<E> {
    private E[] elements;
    private int size=0;
    private static final int DEFAULT_CAPACITY_SIZE=16;

    public StackV3() {
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
        E result=elements[--size];
        elements[size]=null;
        return result;
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

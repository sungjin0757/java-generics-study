package item29;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackV2<E> {
    private E[] elements;
    private int size=0;
    private static final int DEFAULT_CAPACITY_SIZE=16;

    public StackV2() {
        // 오류 발생. E와 같은 실체화 불가 타입은 배열로 만들수 없다.
        elements=new E[DEFAULT_CAPACITY_SIZE];
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

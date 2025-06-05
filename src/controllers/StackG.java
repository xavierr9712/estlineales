package controllers;

import java.util.EmptyStackException;
import models.NodeGeneric;

public class StackG <T>{

    private NodeGeneric <T> top;
    private int size;

    public StackG() { 
        this.size = 0;
    }

    public void push (T value){ 
        NodeGeneric<T> newNode = new NodeGeneric<>(value);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    public T pop (){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        T value = top.getValue();
        top = top.getNext();
        size--;
        return value;
    }

    public T peek (){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return top.getValue();
    }

    public int size (){
        return size;
    }

    public boolean isEmpty (){
        return top == null;
    }

    public void printStack (){
        NodeGeneric<T> current = top;
        
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
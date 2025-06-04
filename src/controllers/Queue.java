package controllers;

import java.util.EmptyStackException;

import models.Node;

public class Queue {

    private Node primero;
    private Node ultimo; 

    public Queue() {
        this.primero = null;
        this.ultimo = null;
    }

    public void add (int value){
        Node newNode = new Node(value);
        if (isEmpty()){
            primero = newNode;
            ultimo = newNode;
        }else{    
            ultimo.setNext(newNode);
            ultimo = newNode;
        }
    }

    public int remove (){
        if (isEmpty()){
            throw new EmptyStackException();
        }

        primero = primero.getNext();
        return primero.getValue();
    }
    
    public boolean isEmpty(){
        return primero==null;
    }
}

package controllers;

import java.util.EmptyStackException; 
import models.NodeGeneric;
import models.Persona; 

public class QueueG <T> {

    private NodeGeneric<T> primero;
    private NodeGeneric<T> ultimo;
    private int size;

    public QueueG() {
        this.primero = null;
        this.ultimo = null;
        this.size = 0;
    }

    public void add (T value){
        NodeGeneric<T> newNode = new NodeGeneric<>(value);
        if (isEmpty()){
            primero = newNode;
            ultimo = newNode;
        }else{    
            ultimo.setNext(newNode);
            ultimo = newNode;
        }
        size++;
    }

    public T remove (){
        if (isEmpty()){
            throw new EmptyStackException(); 
        }
        T value = primero.getValue();
        primero = primero.getNext();
        if (primero == null) {
            ultimo = null;
        }
        size--;
        return value;
    }
    
    public boolean isEmpty(){
        return primero == null;
    }

    public int size() {
        return size;
    }

    public void printCola (){ 
        NodeGeneric<T> current = primero;
        System.out.print("Queue (Generic): ");
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    
    public Persona findBYName(String name) { 
        NodeGeneric<T> current = primero;
        while (current != null) {
            if (current.getValue() instanceof Persona) {
                Persona p = (Persona) current.getValue();
                if (p.getName().equalsIgnoreCase(name)) {
                    return p;
                }
            }
            current = current.getNext();
        }
        return null; 
    }

    public Persona deleteBYName(String name) { 
        if (isEmpty()) {
            return null;
        }

        if (primero.getValue() instanceof Persona) {
            Persona firstPersona = (Persona) primero.getValue();
            if (firstPersona.getName().equalsIgnoreCase(name)) {
                return (Persona) remove(); 
            }
        }

        NodeGeneric<T> current = primero;
        while (current.getNext() != null) {
            if (current.getNext().getValue() instanceof Persona) {
                Persona nextPersona = (Persona) current.getNext().getValue();
                if (nextPersona.getName().equalsIgnoreCase(name)) {
                    T valueToDelete = current.getNext().getValue();
                    current.setNext(current.getNext().getNext());
                    size--;
                    if (current.getNext() == null) { 
                        ultimo = current;
                    }
                    return (Persona) valueToDelete;
                }
            }
            current = current.getNext();
        }
        return null; 
    }
}
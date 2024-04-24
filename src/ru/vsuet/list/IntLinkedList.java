package ru.vsuet.list;

import java.util.function.Predicate;

public class IntLinkedList implements IntList {
    private List head;
    private int size;

    private class List{
        int value;
        List next;

        List(int value){
            this.value = value;
            this.next = null;
        }
    }
    @Override
    public int get(int idx){
        if (idx > size || idx < 0){
            throw new IndexOutOfBoundsException("Index out of bounds: " + size);
        }

        List current = head;
        for (int i = 0; i < idx; i++){
            current = current.next;
        }
        return current.value;
    }
    @Override
    public void add(int value){
        if (value < 0){
            throw new IndexOutOfBoundsException("List does not accept negative values.");
        }

        List list = new List(value);
        if (head == null){
            head = list;
        }else{
            List current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = list;
        }
        size++;
    }
    @Override
    public void add(int idx, int value){
        if (idx > size || idx < 0){
            throw new IndexOutOfBoundsException("Index out of bounds: " + size);
        }
        if (value < 0){
            throw new IndexOutOfBoundsException("List does not accept negative values.");
        }
        if (idx == 0) {
            List list = new List(value);
            list.next = head;
            head = list;
        } else {
            List current = head;
            for (int i = 0; i < idx - 1; i++) {
                current = current.next;
            }
            List list = new List(value);
            list.next = current.next;
            current.next = list;
        }
        size++;
    }
    @Override
    public void remove(int idx) {
        if (idx > size || idx < 0){
            throw new IndexOutOfBoundsException("Index out of bounds: " + size);
        }
        if (idx == 0) {
            head = head.next;
        } else {
            List current = head;
            for (int i = 0; i < idx - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }
    @Override
    public void remove(Predicate<Integer> condition) {
        List current = head;
        List previous = null;
        while (current != null) {
            if (condition.test(current.value)) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
            } else {
                previous = current;
            }
            current = current.next;
        }
    }
    @Override
    public int size() {

        return size;
    }

    public void printList() {
        List current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

}

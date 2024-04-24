package ru.vsuet.list;

public class Main {
     public static void main(String[] args) {
          IntLinkedList list = new IntLinkedList();

          list.add(5);
          list.add(10);

          System.out.println("List size: " + list.size());

          list.add(10);
          list.add(1);
          list.add(2);
          list.add(4);
          list.add(12);
          list.add(11);
          list.add(20);

          System.out.println("List: ");
          list.printList();

          list.add(5, 30);
          list.remove(6);

          System.out.println("List: ");
          list.printList();

          list.remove(element -> element > 10);

          System.out.println("List: ");
          list.printList();
          System.out.println("List size: " + list.size());
     }
}

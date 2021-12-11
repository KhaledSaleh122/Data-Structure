/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylinked;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author khale
 */
public class MyLinked<T> {

    private Node<T> head;
    private Node<T> tail;
    int size = 0;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void add(T element) {
        if (head == null) {
            head = tail = new Node<>(element);
            size++;
        } else {
            Node cur = head;
            while (cur.getNext() != null) {
                cur = cur.getNext();
            }
            Node temp = new Node(element);
            cur.setNext(temp);
            //temp.setPreviuse(cur);
            tail = temp;
            size++;
        }
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new RuntimeException("Wrong index");
        }
        if (index == 0) {
            if (head == null) {
                head = tail = new Node<>(element);
                size++;
            } else {
                Node temp = new Node(element);
                temp.setNext(head);
                //head.setPreviuse(temp);
                head = temp;
                size++;
            }
        } else {
            Node cur = head;
            int index1 = 0;
            while (index1 < index - 1) {
                cur = cur.getNext();
                index1++;
            }
            Node temp = new Node(element);
            temp.setNext(cur.getNext());
            if (temp.getNext() == null) {
                tail = temp;
            } else {
                //temp.getNext().setPreviuse(temp);
            }
            cur.setNext(temp);
            //temp.setPreviuse(cur);
            size++;
        }
    }

    public T removeByIndex(int index) {
        T temp;
        if (index < 0 || index > size) {
            throw new RuntimeException("error");
        }
        if (index == 0) {
            if (head.getNext() == null) {
                temp = head.getData();
                head = tail = null;
                size--;
            } else {
                temp = head.getData();
                head = head.getNext();
                head.setPreviuse(null);
                size--;
            }
        } else {
            Node cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.getNext();
            }
            temp = head.getData();
            cur.setNext(cur.getNext().getNext());
            if (cur.getNext() != null) //cur.getNext().setPreviuse(cur);
            {
                size--;
            }
        }
        return temp;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public T remove() {
        T temp;
        if (head == null) {
            throw new RuntimeException("Size = 0");
        } else if (head.getNext() == null) {
            temp = head.getData();
            head = tail = null;
            size = 0;
        } else {
            temp = head.getData();
            head = head.getNext();
            //head.setPreviuse(null);
            size--;
        }
        return temp;
    }

    @Override
    public String toString() {
        Node cur = head;
        if (cur == null) {
            return "[ ]";
        }
        String s = "";
        while (cur != null) {
            s = s + cur.getData() + ",";
            cur = cur.getNext();
        }
        return "[" + s.substring(0, s.length() - 1) + "]";
    }

    public void midL() {
        if (head == null) {
            throw new RuntimeException("Error");
        }
        Node f = head;
        Node s = head;
        while (f.getNext() != null && f.getNext().getNext() != null) {
            f = f.getNext().getNext();
            s = s.getNext();
        }
        System.out.println(s.getData());
    }

    public void reverse() {
        if (head == null) {
            throw new RuntimeException("Error");
        }
        Node<T> cur = head;
        Node<T> next = null;
        Node<T> pre = null;
        tail = head;
        if (head.getNext() != null) {
            next = head.getNext();
        }
        if (next != null && next.getNext() != null) {
            pre = next.getNext();
        }
        while (pre != null) {
            next.setNext(cur);
            cur = next;
            next = pre;
            pre = pre.getNext();
        }
        if (next != null) {
            next.setNext(cur);
            head = next;
            tail.setNext(null);
        }

    }

    public void addFirst(T elemnt) {
        if (head == null) {
            tail = head = new Node(elemnt);
            size++;
        } else {
            Node<T> temp = new Node(elemnt);
            temp.setNext(head);
            head = temp;
            size++;
        }
    }

    public void removelast() {
        if (head != null) {
            if (head.getNext() == null) {
                tail = head = null;
                size--;
            } else {
                Node<T> cur = head;
                while (cur.getNext().getNext() != null) {
                    cur = cur.getNext();
                }
                tail = cur;
                tail.setNext(null);
                size--;
            }
        }
    }

    public void sort() {
        if (head.getNext() != null) {
            for (int i = 0; i < size; i++) {
                Node<T> cur = head;
                Node<T> next = head.getNext();
                for (int j = 0; j < size - 1; j++) {
                    if ((Integer) next.getData() < (Integer) cur.getData()) {
                        replaceData(j + 1);
                    }
                    cur = cur.getNext();
                    next = next.getNext();
                }
            }
        }
    }

    public void replaceData(int index) {
        if (index != 0) {
            Node<T> cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.getNext();
            }
            T temp = cur.getData();
            cur.setData((T) cur.getNext().getData());
            cur.getNext().setData(temp);
        }
    }

    public static Node sumTowLinked(Node l1, Node l2) {
        String num1 = "";
        String num2 = "";
        if (l1 == null) {
            if(l2 == null ){
                return new Node(0);
            }else{
                return l2;
            }
        } else if (l2 == null) {
            if(l1 == null ){
                return new Node(0);
            }else{
                return l1;
            }
        }
        Node cur = l1;
        while(cur != null){
            num1 = num1 + cur.getData();
            cur = cur.getNext();
        }
        cur = l2;
       while(cur != null) {
            num2 = num2 + cur.getData();
            cur = cur.getNext();
        }
        int theSum = Integer.valueOf(num1) + Integer.valueOf(num2);
        String sum = String.valueOf(theSum);
        Node theHead = null;
        //cur = theHead;
        for (int i = 0; i < sum.length(); i++) {
            int Data = Integer.valueOf(String.valueOf(sum.charAt(i)));
            if (theHead == null) {
                theHead = new Node(Data);
               // theHead.setSize(sum.length());
                cur = theHead;
            } else {
                Node Temp = new Node(Data);
                cur.setNext(Temp);
                cur = Temp;
            }
        }
        return theHead;
    }
    public void cycel(int index ){
        tail.setNext(head);
    }
    public static void main(String[] args) {
        MyLinked<Integer> t = new MyLinked<>();
        t.add(1);
        t.add(2);
        t.add(3);
        MyLinked<Integer> f = new MyLinked<>();
        f.add(3);
        f.add(2);
        f.add(1);
        Node n = sumTowLinked(t.head, f.head);
        Node cur  =  n;
        while(cur != null){
            System.out.print(cur.getData() + " ");
            cur= cur.getNext();
        }
    }
}

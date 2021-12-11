/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylinked;

/**
 *
 * @author khale
 */
public class Node<T> {
    private T data;
    private Node next;
    private Node previuse;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node getPreviuse() {
        return previuse;
    }

    public void setPreviuse(Node previuse) {
        this.previuse = previuse;
    }
    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
}

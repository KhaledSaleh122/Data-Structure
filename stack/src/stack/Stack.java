/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import static java.lang.System.in;

/**
 *
 * @author khale
 */
public class Stack<T> {

    private T arr[] = (T[]) new Object[2];
    private int size = 0;

    public void capasity() {
        if (size == arr.length) {
            T temp[] = (T[]) new Object[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }
    }

    public boolean push(T element) {
        capasity();
        arr[size] = element;
        size++;
        return true;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public T pop() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Empty");
        }
        T temp = arr[size - 1];
        size--;
        return temp;
    }

    public T peek() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Empty");
        }
        return arr[size - 1];
    }
    
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s = s + arr[i] + ",";
        }
        if (s.length() < 1) {
            return "Empty";
        }
        return "[" + s.substring(0, s.length() - 1) + "]";
    }
    public static Stack revers(Stack<Integer> s){
        Stack temp = new Stack();
        while(!s.isEmpty()){
            temp.push(s.pop());
        }
       return temp;
    }
    public  void revers1(){
        Stack temp = new Stack();
        while(!isEmpty()){
            temp.push(pop());
        }
        this.arr = (T[]) temp.arr;
        this.size = temp.size;
    }
    public static void shiftRight(Stack<Integer> s,int times){
        while(times > 0){
        Stack<Integer> temp = new Stack<>();
        int num = s.pop();
        while(!s.isEmpty()){
            temp.push(s.pop());
        }
        s.push(num);
        while(! temp.isEmpty()){
            s.push(temp.pop());
        }
        times--;
        }
    }
    
    public static void shiftLeft(Stack<Integer> s,int times){
        times = times % s.size;
        while(times > 0){
        Stack<Integer> temp = new Stack<>();
        while(!s.isEmpty()){
            temp.push(s.pop());
        }
        int num = temp.pop();
        while(! temp.isEmpty()){
            s.push(temp.pop());
        }
        s.push(num);
        times--;
        }
    }
    public static Stack maxandmin(Stack<Integer> s){
        Stack temp = new Stack<>();
        int max = s.peek();
        int min = s.peek();
        temp.push(s.pop());
        while(!s.isEmpty()){
            if (max < s.peek())
                max = s.peek();
            if(min > s.peek())
                min = s.peek();
            temp.push(s.pop());
        }
        System.out.println("max = "+max);
        System.out.println("min = "+min);
        return temp;
    }
    public <f extends Integer> void  sort(){ //sort without stack
        Stack<T> temp = new Stack<>();
        f min = (f) peek(); 
        temp.push(this.pop());
        while(!this.isEmpty()){
            if(min <= (f) peek()){
                min = (f) peek();
                temp.push(pop());
            }else{
               f tempnum =  (f) this.pop();
               while(!temp.isEmpty() && tempnum < (f) temp.peek()){
                   this.push( temp.pop());
               }
               temp.push((T) tempnum);
            }
        }
        this.arr = temp.arr;
        this.size = temp.size;
    }
    public void evenAndOdd(){
        Stack<Integer>  Temp = new  Stack();
        while(!this.isEmpty()){
            if( (Integer) this.peek() %  2 == 0){
                Temp.push((Integer) this.pop());
            }else{
                this.pop();
            }
        }
        System.out.println(Temp);
    }
    public static void main(String[] args) {
        Arraylist<int> s = new 
        Stack s = new Stack();
        s.push(5);
        s.push(2);
        s.push(1);
        s.sort();
        System.out.println(s);
    }


}

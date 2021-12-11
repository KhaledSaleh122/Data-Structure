package arraylistagain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class ArrayListAgain<E>  {

    private int size = 0;
    private E[] arr = (E[]) new Object[3];

    public void checkSize() {
        if (size == arr.length) {
            E[] arr1 = (E[]) new Object[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                arr1[i] = arr[i];
            }
            arr = arr1;
        }
    }

    public void checkIndexAdd(int x) {
        if (x < 0 || x > size) {
            throw new ArrayIndexOutOfBoundsException("index = " + x);
        }
    }

    public void checkIndexGetElement(int x) {
        if (x < 0 || x >= size) {
            throw new ArrayIndexOutOfBoundsException("index = " + x);
        }
    }

    public void add(int x, E element) {
        checkSize();
        checkIndexAdd(x);
        for (int i = size; i > x; i--) {
            arr[i] = arr[i - 1];
        }
        arr[x] = element;
        size++;
    }

    public void add(E element) {
        checkSize();
        arr[size] = element;
        size++;
    }
    
    public void addAll(Collection list) {
        Iterator<E> element = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            add(element.next());
        }
    }

    public void addAll(int x, Collection list) {
        checkIndexAdd(x);
        Iterator<E> element = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            add(x++, element.next());
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s = s + arr[i] + " ";
        }
        return "[" + s + "]";
    }

    public void clear() {
        size = 0;
    }

    public E getElement(int x) {
        checkIndexGetElement(x);
        return arr[x];
    }

    public void set(int x, E element) {
        checkIndexGetElement(x);
        arr[x] = element;
    }

    @Override
    public ArrayListAgain clone() {
        ArrayListAgain<E> arr2 = new ArrayListAgain<>();
        for (int i = 0; i < size; i++) {
            arr2.add(arr[i]);
        }
        return arr2;
    }

    public boolean contains(E element) {
        boolean isFound = false;
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }

    public int indexOf(E element) {
        int theIndex = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                theIndex = i;
                break;
            }
        }
        return theIndex;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int lastIndexOf(E element) {
        int theIndex = -1;
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i] == element) {
                theIndex = i;
                break;
            }
        }
        return theIndex;
    }

    public E remove(int x) {
        checkIndexGetElement(x);
        E temp = arr[x];
        for (int i = x; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return temp;
    }

    public boolean removeElement(E element) {
        boolean isFound = false;
        if (contains(element)) {
            isFound = true;
            for (int i = indexOf(element); i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }
            size--;
        }
        return isFound;
    }
    
    public Iterator<E> iterator(){
        Iterator<E> it = new Iterator<E>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                E temp = arr[currentIndex++];
                return temp;
            }
        };
        return it;
    }
    public void removeint(int x,int x1){
        E[] temp = (E[]) new Object[size - ((x1-x)+1)];
        int counter = 0;
        for(int i = 0 ; i < size;i++){
            if(x > i || i > x1){
                System.out.println(arr[i]);
                temp[counter] = arr[i];
                counter++;
            }
        }
        
        size = size - ((x1-x)+1);
        arr = temp;
    }
    public static void main(String[] args) {
        ArrayListAgain arr2 = new ArrayListAgain();
        arr2.add(0, 2);
        arr2.add(0, 5);
        arr2.add(0,1);
        arr2.add(0, 4);
        arr2.removeint(1, 2);
        System.out.println(arr2);
    }
}

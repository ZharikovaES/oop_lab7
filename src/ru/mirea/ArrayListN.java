package ru.mirea;
import java.util.Arrays;
import java.util.Comparator;

public class ArrayListN<T> {
    private T[] arr;
    private int size;
    private int count;

    public ArrayListN(){
        this(8);
    }

    public ArrayListN(int size) {
        this.size = size;
        arr = (T[]) new Object[size];
        count = 0;
    }

    public ArrayListN(ArrayListN<T> other){
        this.count = other.count;
        this.size = other.size;
        this.arr = (T[]) new Object[size];
        System.arraycopy(other.arr, 0, arr, 0, count);
    }

    public void add(T o){
        if(size - count == 1) resize(size*2);
        arr[count++] = o;
    }
    public void add(T o, int index){
        if(size - count == 1) resize(size*2);
        System.arraycopy(arr, index, arr, index + 1, count-index);
        arr[index] = o;
    }

    public boolean addAll(int index, ArrayListN<T> other){
        if(other.count == 0) return false;
        int newSize = size;
        while (newSize <= count + other.count) newSize *= 2;
        resize(newSize);
        System.arraycopy(arr, index, arr, index + other.count, count - index);
        System.arraycopy(other.arr, 0, arr, index, other.count);
        count += other.count;
        return true;
    }

    public int indexOf(T o){
        for(int i = 0; i < count; i++)
            if(arr[i].equals(o)) return i;
        return -1;
    }

    public int lastIndexOf(T o){
        for(int i = count-1; i >=0; i--)
            if(arr[i].equals(o)) return i;
        return -1;
    }

    public void set(int index, T o){
        arr[index] = o;
    }

    public T remove(int index){
        if(index > count)
            throw new IndexOutOfBoundsException();
        T o = arr[index];
        System.arraycopy(arr, index+1, arr, index, count-index);
        arr[--count] = null;

        if(count < size/2) resize(size/2);
        return o;
    }

    public void sort(Comparator<? super T> comp){
        boolean isSorted = false;
        T buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < count - 1; i++) {
                if(comp.compare(arr[i], arr[i+1]) > 0){
                    isSorted = false;
                    buf = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buf;
                }
            }
        }
    }

    public ArrayListN<T> subList(int start, int end){
        ArrayListN<T> nl = new ArrayListN<>();
        for(int i = start; i<end; i++) nl.add(arr[i]);
        return nl;
    }


    private void resize(int nSize){
        if(nSize > size)
            arr = Arrays.copyOf(arr, nSize);
        else{
            T[] tmp = (T[])new Object[nSize];
            System.arraycopy(arr, 0, tmp, 0, nSize);
            arr = tmp;
        }
        size = nSize;
    }
    public T get(int index){
        if(index > count)
            throw new IndexOutOfBoundsException();
        return arr[index];
    }

    public int getCount() {
        return count;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "ArrayListN: " + "arr = " + Arrays.toString(arr) + ", count = " + count + ", size = " + size;
    }
}

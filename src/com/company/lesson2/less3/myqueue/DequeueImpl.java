package ru.geekbrains.ads.lesson3.myqueue;

public class DequeueImpl<E> implements ru.geekbrains.ads.lesson3.myqueue.Dequeue<E> {


    private static final int DEFAULT_TAIL = -1;
    private static final int DEFAULT_HEAD = 0;

    protected E[] data;
    protected int size;

    private int tail;
    private int head;

    public DequeueImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        this.head = DEFAULT_HEAD;
        this.tail = DEFAULT_TAIL;
    }

    public boolean insert(E value) {
        if (isFull()) {
            return false;
        }

        if (tail == data.length - 1) {
            tail = DEFAULT_TAIL;
        }

        data[++tail] = value;
        size++;
        return true;
    }

    public E remove() {
        if (isEmpty()) {
            return null;
        }

        E removedValue = data[head++];
        size--;
        return removedValue;
    }

    @Override
    public boolean insertRight(E value) {
        if (isFull()) {
            return false;
        }

        if (tail == data.length - 1) {
            tail = DEFAULT_TAIL;
        }

        data[++tail] = value;
        size++;
        return true;
    }

    @Override
    public boolean insertLeft(E value) {
        if(isFull()){
            return false;
        }

        if(tail == DEFAULT_TAIL){
            insert(value);
            return true;
        }

        E[] copyData = (E[]) new Object[data.length + 1];
        copyData[head] = value;

        for (Object obj: data) {
            copyData[++head] = (E) obj;;
        }
        size++;
        tail = size - 1;
        head = DEFAULT_HEAD;
        data = copyData;
        return true;
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }

        if (head == data.length) {
            head = DEFAULT_HEAD;
        }

        E removedValue = data[head++];
        size--;
        return removedValue;
    }

    @Override
    public E removeLeft() {
        if (isEmpty()) {
            return null;
        }

        head = DEFAULT_HEAD;

        E[] copyQueue = (E[]) new Object[data.length - 1];

        E removedValue = data[head];
        for (int i = 0; i < copyQueue.length - 1; i++) {
            copyQueue[i] = data[++head];
        }

        data = copyQueue;
        size--;
        tail = size - 1;
        head = DEFAULT_HEAD;
        return removedValue;
    }

    @Override
    public E peekHead() {
        return data[head];
    }

    public E peekTail() {
        return data[tail];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return data.length == size;
    }

}

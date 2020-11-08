package ru.geekbrains.ads.lesson3.myqueue;

public interface Dequeue<E> {

    boolean insertRight(E value);

    boolean insertLeft(E value);

    E removeRight();

    E removeLeft();

    E peekHead();

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

    boolean isFull();
}

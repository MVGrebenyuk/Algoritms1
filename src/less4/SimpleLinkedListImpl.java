package less4;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SimpleLinkedListImpl<E> implements LinkedList<E>, Iterable{

    protected int size;
    protected Node<E> firstElement; //001[005]


    @Override
    public void insertFirst(E value) {
        Node<E> newNode = new Node<>(value, firstElement); // 002[007] | 002[..next->005]
        firstElement = newNode; //001[007]
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedElement = firstElement;
        E data = removedElement.item;

        firstElement = firstElement.next;
        removedElement.next = null;
        removedElement.item = null;

        size--;
        return data;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == firstElement) {
            firstElement = firstElement.next;
        }
        else {
            previous.next = current.next;
        }

        current.next = null;
        current.item = null;

        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void display() {
        System.out.println("-----------");
        Node<E> current = firstElement;
        while (current != null) {
            System.out.println(current.item);
            current = current.next;
        }
        System.out.println("-----------");
    }

    @Override
    public E getFirst() {
        return firstElement.item;
    }

    public class Myiterator implements Iterator {
        private Node curr;

        public Myiterator() {
            this.curr = SimpleLinkedListImpl.this.firstElement; // голова списка
        }

        public boolean hasNext() {
            return this.curr != null;
        }

        public Object next() {
            if (!this.hasNext()) {
                System.out.println("Последний элемент");
            }
            Object value = curr.item; // значение в текущем узле
            curr = curr.next;     // следующий узел
            return value;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator iterator() {
        return new Myiterator();
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }
}

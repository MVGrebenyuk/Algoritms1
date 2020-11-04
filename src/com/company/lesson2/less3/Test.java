package com.company.lesson2.less3;

import ru.geekbrains.ads.lesson3.mystack.Stack;
import ru.geekbrains.ads.lesson3.mystack.StackImpl;

public class Test {

    public static void main(String[] args) {
        inverseMethod();
        testDequeue();
    }

    private static void inverseMethod() {
        Stack<Integer> stack = new StackImpl<>(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Создали стек");

        Stack<Integer> stack2 = new StackImpl<>(5);

        stack2.push(stack.pop());
        System.out.println(stack2.peek());
        stack2.push(stack.pop());
        System.out.println(stack2.peek());
        stack2.push(stack.pop());
        System.out.println(stack2.peek());
        stack2.push(stack.pop());
        System.out.println(stack2.peek());
        stack2.push(stack.pop());
        System.out.println(stack2.peek());

        System.out.println("Перевернули стек");

        stack = stack2;

        System.out.println("------------------");

    }

    private static void testDequeue(){
        ru.geekbrains.ads.lesson3.myqueue.Dequeue dequeue = new ru.geekbrains.ads.lesson3.myqueue.DequeueImpl<Integer>(10);

        System.out.println("Создали очередь со вставкой в начало");
        System.out.println("v: " + dequeue.insertLeft(1));
        System.out.println("v: " + dequeue.insertLeft(2));
        System.out.println("v: " + dequeue.insertLeft(3));
        System.out.println("v: " + dequeue.insertLeft(4));
        System.out.println("v: " + dequeue.insertLeft(5));
        System.out.println("v: " + dequeue.insertLeft(6));
        System.out.println("v: " + dequeue.insertLeft(7));
        System.out.println("v: " + dequeue.insertLeft(8));
        System.out.println("v: " + dequeue.insertLeft(9));
        System.out.println("v: " + dequeue.insertLeft(10));

        System.out.println("Получили очередь, где начале - последний элемент");
        System.out.println(dequeue.peekHead());
        System.out.println(((ru.geekbrains.ads.lesson3.myqueue.DequeueImpl) dequeue).peekTail());

        System.out.println("Удаляем его");
        System.out.println("v: " + dequeue.removeLeft());
        System.out.println(dequeue.peekHead());
        System.out.println(((ru.geekbrains.ads.lesson3.myqueue.DequeueImpl) dequeue).peekTail());

        System.out.println("Дек?");

    }

    private static void testStack() {
        Stack<Integer> stack = new StackImpl<>(5);

        System.out.println("Add value 1: " + addToStack(stack, 1));
        System.out.println("Add value 2: " + addToStack(stack, 2));
        System.out.println("Add value 3: " + addToStack(stack, 3));
        System.out.println("Add value 4: " + addToStack(stack, 4));
        System.out.println("Add value 5: " + addToStack(stack, 5));
        System.out.println("Add value 6: " + addToStack(stack, 6));

        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack top: " + stack.peek());

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static boolean addToStack(Stack<Integer> stack, int value) {
        if (!stack.isFull()) {
            stack.push(value);
            return true;
        }
        return false;
    }

    private static void testQueue() {
//        Queue<Integer> queue = new QueueImpl<>(5);
        ru.geekbrains.ads.lesson3.myqueue.Queue<Integer> queue = new ru.geekbrains.ads.lesson3.myqueue.PriorityQueue<Integer>(5);
        System.out.println(queue.insert(3));
        System.out.println(queue.insert(5));
        System.out.println(queue.insert(1));
        System.out.println(queue.insert(2));
        System.out.println(queue.insert(6));
        System.out.println(queue.insert(4));

        System.out.println("Queue peek: " + queue.peekHead());
        System.out.println("Queue size: " + queue.size());
        System.out.println("Queue is full: " + queue.isFull());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}

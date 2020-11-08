package com.company.lesson2;

public class TestArray {

    private static int array = 10000;
    private static Array<Integer> data = new ArrayImpl<>(array);

    public static void main(String[] args) {
        create();
        Array<Integer> arr1 = data.copy();
        Array<Integer> arr2 = data.copy();
        Array<Integer> arr3 = data.copy();

        long start = System.currentTimeMillis();
        arr1.sortBubble();
        long finish = System.currentTimeMillis();
        System.out.println("bubble sort :" + (finish - start));

        start = System.currentTimeMillis();
        arr2.sortSelect();
        finish = System.currentTimeMillis();
        System.out.println("select sort :" + (finish - start));

        start = System.currentTimeMillis();
        arr2.sortInsert();
        finish = System.currentTimeMillis();
        System.out.println("insert sort :" + (finish - start));
    }

    private static void create() {
        for (int i = 0; i < array - 1; i++) {
            data.add((int) (Math.random() * array));
        }

        };
    }

package com.rfiser.algorithms.stack;

public class StackArray<Item> {
    private Item[] array;
    private int N = 0;

    public StackArray(int capacity) {
        array = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Item pop() {
        return array[--N];
    }

    public void push(Item item) {
        array[N++] = item;
    }
}

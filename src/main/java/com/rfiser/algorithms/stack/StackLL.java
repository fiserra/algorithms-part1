package com.rfiser.algorithms.stack;

public class StackLL<Item> {
    private Node<Item> first = null;

    private class Node<S> {
        private S item;
        private Node<S> next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(final Item item) {
        final Node<Item> prevFirst = first;
        final Node<Item> node = new Node<Item>();
        node.item = item;
        first = node;
        node.next = prevFirst;
    }

    public Item pop() {
        final Item item = first.item;
        first = first.next;
        return item;
    }
}

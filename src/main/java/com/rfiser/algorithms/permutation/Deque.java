package com.rfiser.algorithms.permutation;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> first = null;
    private Node<Item> last = null;
    private int size = 0;

    private class Node<S> {
        private S item;
        private Node<S> next;
        private Node<S> prev;
    }

    /**
     * Construct an empty deque
     */
    public Deque() {
    }

    /**
     * is the deque empty?
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Return the number of items on the deque
     */
    public int size() {
        return size;
    }

    /**
     * add the item to the front
     *
     * @param item
     */
    public void addFirst(final Item item) {
        if (item != null) {
            final Node<Item> newNode = new Node<Item>();
            newNode.item = item;
            if (first != null) {
                final Node<Item> prevFirst = first;
                newNode.next = prevFirst;
                prevFirst.prev = newNode;
                first = newNode;
            } else {
                first = newNode;
                last = first;
            }
            size++;
        } else {
            throw new NullPointerException();
        }
    }

    /**
     * Add the item to the end
     *
     * @param item item to be added at the end of the deque
     */
    public void addLast(Item item) {
        if (item != null) {
            final Node<Item> newNode = new Node<Item>();
            newNode.item = item;
            if (last != null) {
                final Node<Item> prevLast = last;
                newNode.prev = prevLast;
                prevLast.next = newNode;
                last = newNode;

            } else {
                last = newNode;
                first = last;
            }
            size++;
        } else {
            throw new NullPointerException();
        }
    }

    /**
     * Remove and return the item from the front
     *
     * @return the item from the front
     */
    public Item removeFirst() {
        if (first != null) {
            final Item item = first.item;
            if (first == last) {
                last = null;
            }
            first = first.next;
            size--;
            return item;
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Remove and return the item from the end
     *
     * @return the last item
     */
    public Item removeLast() throws NoSuchElementException {
        if (last != null) {
            final Item item = last.item;
            if (first == last) {
                first = null;
            }
            last = last.prev;
            size--;
            return item;
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Return an iterator over items in order from front to end
     *
     * @return an iterator
     */
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        private Node<Item> current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            final Item currentItem = current.item;
            current = current.next;
            return currentItem;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
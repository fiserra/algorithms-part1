package com.rfiser.algorithms.permutation;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items;
    private int N = 0;

    /**
     * construct an empty randomized queue
     */
    public RandomizedQueue() {
        items = (Item[]) new Object[1];
    }

    /**
     * is the queue empty?
     *
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * return the number of items on the queue
     *
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * Add an item
     *
     * @param item item to be added
     * @throws NullPointerException if item is null
     */
    public void enqueue(Item item) throws NullPointerException {
        if (item != null) {
            if (N == items.length) {
                resize(2 * items.length);
            }
            items[N++] = item;
        } else {
            throw new NullPointerException();
        }
    }

    private void resize(int capacity) {
        final Item[] copy = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, copy, 0, N);
        items = copy;
    }

    /**
     * Remove and return a random item
     *
     * @return a random item
     * @throws NoSuchElementException
     */
    public Item dequeue() throws NoSuchElementException {
        if (N == 0) {
            throw new NoSuchElementException();
        } else {
            int randomIndex = StdRandom.uniform(0, N);
            final Item item = items[randomIndex];
            items[randomIndex] = null;
            N--;
            if (N > 0 && N == items.length / 4) resize(items.length / 2);
            return item;
        }
    }

    /**
     * Return (but do not remove) a random item
     */
    public Item sample() {
        if (N == 0) {
            throw new NoSuchElementException();
        } else {
            int randomIndex = StdRandom.uniform(0, N);
            return items[randomIndex];
        }
    }

    /**
     * Return an independent iterator over items in random order
     */
    public Iterator<Item> iterator() {
        return null;
    }

    private class RandomQueueIterator implements Iterator<Item> {
        public boolean hasNext() {
            return N > 0;
        }

        public Item next() {
            return dequeue();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
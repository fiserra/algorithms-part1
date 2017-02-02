package com.rfiser.algorithms.permutation;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class RandomizedQueueTest {

    @Test
    public void isEmpty() throws Exception {
        final RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<Integer>();
        assertTrue(randomizedQueue.isEmpty());
        randomizedQueue.enqueue(1);
        assertFalse(randomizedQueue.isEmpty());
        randomizedQueue.dequeue();
        assertTrue(randomizedQueue.isEmpty());
    }

    @Test
    public void size() throws Exception {
        final RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<Integer>();
        assertEquals(randomizedQueue.size(), 0);
        randomizedQueue.enqueue(1);
        assertEquals(randomizedQueue.size(), 1);
        randomizedQueue.enqueue(3);
        assertEquals(randomizedQueue.size(), 2);
    }

    @Test
    public void enqueue() throws Exception {
        final RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<Integer>();

        randomizedQueue.enqueue(1);
        randomizedQueue.enqueue(2);
        randomizedQueue.enqueue(3);
        assertEquals(randomizedQueue.size(), 3);
    }

    @Test(expected = NullPointerException.class)
    public void enqueue_NullPointerException() throws Exception {
        final RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<Integer>();
        randomizedQueue.enqueue(null);
    }

    @Test
    public void dequeue() throws Exception {
        final RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<Integer>();
        randomizedQueue.enqueue(1);
        randomizedQueue.enqueue(2);
        randomizedQueue.enqueue(3);
        final Integer val1 = randomizedQueue.dequeue();
        assertTrue(val1 == 1 || val1 == 2 || val1 == 3);
        final Integer val2 = randomizedQueue.dequeue();
        assertTrue(val2 == 1 || val2 == 2 || val2 == 3);
        final Integer val3 = randomizedQueue.dequeue();
        assertTrue(val3 == 1 || val3 == 2 || val3 == 3);
        assertTrue(randomizedQueue.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void dequeue_NoSuchElementException() throws Exception {
        final RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<Integer>();
        randomizedQueue.dequeue();
    }

    @Test
    public void sample() throws Exception {
        final RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<Integer>();
        randomizedQueue.enqueue(1);
        randomizedQueue.enqueue(2);
        randomizedQueue.enqueue(3);
        final Integer val1 = randomizedQueue.sample();
        assertTrue(val1 == 1 || val1 == 2 || val1 == 3);
        final Integer val2 = randomizedQueue.sample();
        assertTrue(val2 == 1 || val2 == 2 || val2 == 3);
        final Integer val3 = randomizedQueue.sample();
        assertTrue(val3 == 1 || val3 == 2 || val3 == 3);
        assertFalse(randomizedQueue.isEmpty());
    }

    @Test
    public void iterator() throws Exception {
        final RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<Integer>();
        randomizedQueue.enqueue(1);
        randomizedQueue.enqueue(2);
        Iterator<Integer> it = randomizedQueue.iterator();
        assertTrue(it.hasNext());
        final Integer val1 = it.next();
        assertTrue(val1 == 1 || val1 == 2);
        assertTrue(it.hasNext());
        final Integer val2 = it.next();
        assertTrue(val2 == 1 || val2 == 2);
        assertFalse(it.hasNext());
    }
}
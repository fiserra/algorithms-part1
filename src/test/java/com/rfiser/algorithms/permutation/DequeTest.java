package com.rfiser.algorithms.permutation;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class DequeTest {

    @Test
    public void isEmpty() throws Exception {
        final Deque<Integer> deque = new Deque<Integer>();
        assertTrue(deque.isEmpty());
        deque.addFirst(1);
        deque.addLast(2);
        assertFalse(deque.isEmpty());
        deque.removeFirst();
        deque.removeLast();
        assertTrue(deque.isEmpty());
    }

    @Test
    public void size() throws Exception {
        final Deque<Integer> deque = new Deque<Integer>();
        assertTrue(deque.size() == 0);
        deque.addFirst(1);
        deque.addLast(2);
        assertTrue(deque.size() == 2);
    }

    @Test
    public void addFirst() throws Exception {
        final Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(1);
        assertTrue(deque.size() == 1);
        deque.addFirst(2);
        assertTrue(deque.size() == 2);
    }

    @Test(expected = NullPointerException.class)
    public void addFirstNullPointerException() throws Exception {
        final Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(null);
    }

    @Test
    public void addLast() throws Exception {
        final Deque<Integer> deque = new Deque<Integer>();
        deque.addLast(1);
        assertTrue(deque.size() == 1);
        deque.addFirst(2);
        assertTrue(deque.size() == 2);
    }

    @Test(expected = NullPointerException.class)
    public void addLastNullPointerException() throws Exception {
        final Deque<Integer> deque = new Deque<Integer>();
        deque.addLast(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void removeFirstNoSuchElementException() throws Exception {
        final Deque<Integer> deque = new Deque<Integer>();
        deque.removeFirst();
    }

    @Test
    public void removeFirst() throws Exception {
        final Deque<Integer> deque = new Deque<Integer>();
        deque.addLast(1);
        final Integer item = deque.removeFirst();
        assertTrue(item == 1);
        deque.addFirst(2);
        deque.addLast(3);
        final Integer item2 = deque.removeFirst();
        assertTrue(item2 == 2);
        assertTrue(deque.size() == 1);
    }

    @Test(expected = NoSuchElementException.class)
    public void removeLastNoSuchElementException() throws Exception {
        final Deque<Integer> deque = new Deque<Integer>();
        deque.removeLast();
    }

    @Test
    public void removeLast() throws Exception {
        final Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(3);
        assertTrue(deque.removeLast() == 3);

        deque.addLast(4);
        assertTrue(deque.removeLast() == 4);
        assertTrue(deque.isEmpty());
    }

    @Test
    public void iterator() throws Exception {
        final Deque<Integer> deque = new Deque<Integer>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        final Iterator<Integer> iterator = deque.iterator();
        assertNotNull(iterator);
        assertTrue(iterator.hasNext());
        assertTrue(iterator.next() == 1);
        assertTrue(iterator.hasNext());
        assertTrue(iterator.next() == 2);
        assertTrue(iterator.hasNext());
        assertTrue(iterator.next() == 3);
        assertFalse(iterator.hasNext());
    }

    @Test(expected = NullPointerException.class)
    public void iteratorNullPointerException() throws Exception {
        final Deque<Integer> deque = new Deque<Integer>();
        deque.addLast(1);

        final Iterator<Integer> iterator = deque.iterator();
        assertNotNull(iterator);
        assertTrue(iterator.hasNext());
        assertTrue(iterator.next() == 1);
        assertFalse(iterator.hasNext());
        iterator.next();
    }
}
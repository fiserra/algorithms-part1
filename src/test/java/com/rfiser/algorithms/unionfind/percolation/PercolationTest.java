package com.rfiser.algorithms.unionfind.percolation;

import org.junit.Test;

import static org.junit.Assert.*;

public class PercolationTest {

    @Test
    public void testPercolates2sites() throws Exception {
        final Percolation percolation = new Percolation(2);

        percolation.open(1, 1);

        assertTrue(percolation.isOpen(1, 1));
        assertTrue(percolation.isFull(1, 1));
        assertFalse(percolation.percolates());

        percolation.open(2, 1);

        assertTrue(percolation.percolates());
        assertTrue(percolation.numberOfOpenSites() == 2);
    }

    @Test
    public void testPercolates5sites() throws Exception {
        final Percolation percolation = new Percolation(5);

        percolation.open(1, 3);
        percolation.open(2, 3);
        percolation.open(2, 4);
        percolation.open(2, 5);
        percolation.open(4, 5);
        percolation.open(4, 4);
        percolation.open(5, 4);

        assertFalse(percolation.percolates());

        percolation.open(3, 5);

        assertTrue(percolation.percolates());
    }

    @Test
    public void testPercolates3sites() throws Exception {
        final Percolation percolation = new Percolation(3);

        percolation.open(1, 1);
        percolation.open(2, 1);
        percolation.open(2, 2);

        assertTrue(percolation.isFull(2, 2));

        percolation.open(3, 3);

        assertFalse(percolation.isFull(3, 3));

        assertFalse(percolation.percolates());

        percolation.open(3, 2);

        assertTrue(percolation.percolates());
    }

    @Test
    public void testPercolates4sites() throws Exception {
        final Percolation percolation = new Percolation(4);

        percolation.open(1, 1);
        percolation.open(1, 2);
        percolation.open(1, 3);
        percolation.open(1, 4);
        percolation.open(2, 1);
        percolation.open(2, 2);
        percolation.open(2, 3);
        percolation.open(2, 4);
        percolation.open(3, 1);
        percolation.open(4, 3);

        assertFalse(percolation.isFull(4, 3));
        assertFalse(percolation.percolates());

        percolation.open(3, 3);

        assertTrue(percolation.percolates());
        assertTrue(percolation.numberOfOpenSites() == 11);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testOpenIndexOutOfBoundsException() throws Exception {
        final Percolation percolation = new Percolation(4);
        percolation.open(5, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIsOpenIndexOutOfBoundsException() throws Exception {
        final Percolation percolation = new Percolation(3);
        percolation.isOpen(2, -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIsFullIndexOutOfBoundsException() throws Exception {
        final Percolation percolation = new Percolation(3);
        percolation.isOpen(0, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testConstructorIndexOutOfBoundsException() throws Exception {
        new Percolation(0);
    }
}
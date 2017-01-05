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
    }

    @Test
    public void testPercolates5sites() throws Exception {
        final Percolation percolation = new Percolation(5);

        percolation.open(0, 2);
        percolation.open(1, 2);
        percolation.open(1, 3);
        percolation.open(1, 4);
        percolation.open(2, 4);
        percolation.open(3, 4);
        percolation.open(3, 3);
        percolation.open(3, 2);

        assertFalse(percolation.percolates());

        percolation.open(4, 2);

        assertTrue(percolation.percolates());
    }
}
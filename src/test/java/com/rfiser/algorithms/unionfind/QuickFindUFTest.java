package com.rfiser.algorithms.unionfind;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickFindUFTest {

    @Test
    public void union_connected() throws Exception {
        final QuickFindUF quickFindUF =  new QuickFindUF(10);
        quickFindUF.union(1, 3);
        quickFindUF.union(4, 5);

        assertTrue(quickFindUF.connected(1, 3));
        assertTrue(quickFindUF.connected(4, 5));
        assertTrue(quickFindUF.connected(5, 4));
        assertFalse(quickFindUF.connected(1, 2));
        assertFalse(quickFindUF.connected(7, 8));
    }
}
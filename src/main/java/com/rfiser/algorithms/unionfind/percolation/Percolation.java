package com.rfiser.algorithms.unionfind.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    // create n-by-n grid, with all sites blocked
    private int[][] sites;
    private int openSites = 0;
    private WeightedQuickUnionUF uf;
    private int virtualTopSite;
    private int virtualBottomSite;
    private int n = 0;

    public Percolation(int n) {
        if (n <= 0) throw new java.lang.IndexOutOfBoundsException(" n should be greater then 0");
        else {
            this.n = n;
            sites = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sites[i][j] = 0;
                }
            }
            virtualTopSite = n * n;
            virtualBottomSite = virtualTopSite + 1;
            uf = new WeightedQuickUnionUF(n * n + 2);
        }

    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 1 || col < 1) throw new IndexOutOfBoundsException("row or col should be greater or equal to 1");
        else {
            if (!isOpen(row, col)) {
                sites[row - 1][col - 1] = 1;
                openSites += 1;

                connectNeighbouringOpenSites(row, col);
            }
        }
    }

    private void connectNeighbouringOpenSites(int row, int col) {
        if (row == 1) {
            uf.union((row - 1) * n + col - 1, virtualTopSite);
        }

        if (row == n) {
            uf.union((row - 1) * n + col - 1, virtualBottomSite);
        }

        if (row - 2 >= 0 && isOpen(row - 1, col)) uf.union((row - 1) * n + col - 1, (row - 2) * n + col - 1);
        if (row + 1 <= n && isOpen(row + 1, col)) uf.union((row - 1) * n + col - 1, row * n + col - 1);
        if (col - 2 >= 0 && isOpen(row, col - 1)) uf.union((row - 1) * n + col - 1, (row - 1) * n + col - 2);
        if (col + 1 <= n && isOpen(row, col + 1)) uf.union((row - 1) * n + col - 1, (row - 1) * n + col);

    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 1 || col < 1) throw new IndexOutOfBoundsException("row or col should be greater or equal to 1");
        else return sites[row - 1][col - 1] == 1;
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 1 || col < 1) throw new IndexOutOfBoundsException("row or col should be greater or equal to 1");
        else return uf.connected((row - 1) * n + col - 1, virtualTopSite);
    }

    // number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.connected(virtualBottomSite, virtualTopSite);
    }
}

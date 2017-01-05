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
            virtualBottomSite = n * n;
            virtualTopSite = virtualBottomSite - 1;
            uf = new WeightedQuickUnionUF(n * n + 1);
        }

    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        if(row < 1 || col < 1) throw new IndexOutOfBoundsException("row or col should be greater or equal to 1");
        else {
            if (!isOpen(row, col)) {
                sites[row - 1][col - 1] = 1;
                openSites += 1;

                connectNeighbouringOpenSites(row, col);
            }
        }
    }

    private void connectNeighbouringOpenSites(int row, int col) {
        if (row == 0) {
            uf.union(row * n + col, virtualTopSite);
        }

        if (row == n - 1) {
            uf.union(row * n + col, virtualBottomSite);
        }

        if (row - 1 >= 0 && isOpen(row - 1, col)) uf.union(row * n + col, (row - 1) * n + col);
        if (row + 1 < n && isOpen(row + 1, col)) uf.union(row * n + col, (row + 1) * n + col);
        if (col - 1 >= 0 && isOpen(row, col - 1)) uf.union(row * n + col, row * n + col - 1);
        if (col + 1 < n && isOpen(row, col + 1)) uf.union(row * n + col, row * n + col + 1);

    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        if(row < 1 || col < 1) throw new IndexOutOfBoundsException("row or col should be greater or equal to 1");
        else return sites[row - 1][col - 1] == 1;
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        if(row < 1 || col < 1) throw new IndexOutOfBoundsException("row or col should be greater or equal to 1");
        else return uf.connected(row * n + col, virtualTopSite);
    }

    // number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.connected(virtualBottomSite, virtualTopSite);
    }

    // test client (optional)
    public static void main(String[] args) {

    }
}

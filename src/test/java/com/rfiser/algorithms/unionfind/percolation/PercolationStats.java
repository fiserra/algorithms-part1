package com.rfiser.algorithms.unionfind.percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    // perform trials independent experiments on an n-by-n grid

    private double[] experimentResults;

    private int trials;

    public PercolationStats(int n, int trials) {
        if (n <= 0 && trials <= 0) {
            throw new IllegalArgumentException("`n` and `trials` should be greater then 0");
        }

        this.trials = trials;
        experimentResults = new double[this.trials];

        for (int i = 0; i < this.trials; i++) {
            Percolation percolation = new Percolation(n);

            while (!percolation.percolates()) {
                int randomRow = StdRandom.uniform(1, n + 1);
                int randomCol = StdRandom.uniform(1, n + 1);
                percolation.open(randomRow, randomCol);
            }

            int openSites = percolation.numberOfOpenSites();
            experimentResults[i] = (double) openSites /( n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(experimentResults);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(experimentResults);
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - (1.96 * stddev()) / Math.sqrt(trials);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + (1.96 * stddev()) / Math.sqrt(trials);
    }

    public static void main(String[] args) {
        PercolationStats percolationStats =  new PercolationStats(2, 10000);
        System.out.println("mean = " + percolationStats.mean());
        System.out.println("stddev = " + percolationStats.stddev());
        System.out.println("95% confidence interval = " + percolationStats.confidenceLo() + ", "  + percolationStats.confidenceHi());

    }
}
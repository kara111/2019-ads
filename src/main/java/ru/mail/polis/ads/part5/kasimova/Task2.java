package ru.mail.polis.ads.part5.kasimova;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Task2 {
    private void solve() {
        long w = nextInt();
        long h = nextInt();
        long n = nextInt();
        long left = Math.max(w, h);
        long right = n * Math.max(w, h);

        while (left < right) {
            long m = (left + right) / 2;
            long v = (m / w) * (m / h);

            if (n <= v){
                right = m;
            } else {
                left = m + 1;
            }

        }
        out.println(left);
    }


    public static void main(String[] args) {
        new Task2().run();
    }

    private void init() {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }

    private void run() {
        try {
            long timeStart = System.currentTimeMillis();

            init();
            solve();

            out.close();

            long timeEnd = System.currentTimeMillis();
            /*System.err.println("Time = " + (timeEnd - timeStart));*/
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * FAST_SCANNER
     */

    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer st;

    String nextLine() {
        try {
            return in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String delimiter = " ";

    private String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(in.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return st.nextToken(delimiter);
    }

    private int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    private int[] nextIntArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        return a;
    }

    int[][] nextIntMatrix(int n, int m) {
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = nextIntArray(m);
        }
        return a;
    }

    int getMaxArray(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int x : a) {
            max = Math.max(max, x);
        }
        return max;
    }

    private void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

}

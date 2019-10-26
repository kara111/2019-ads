package ru.mail.polis.ads.part5.kasimova;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Task4 {
    private void solve() {
        String s1 = nextLine();
        String s2 = nextLine();
        String w;
        String p;
        if (s1.contains("*") || s1.contains("?") ){
            w = s2;
            p = s1;
        } else {
            w = s1;
            p = s2;
        }

        int n = w.length();
        int m = p.length();

        boolean [][] d = new  boolean[n+1][m+1];
        d[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (w.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    d[i][j] = d[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    d[i][j] = d[i - 1][j] || d[i - 1][j - 1] || d[i][j - 1];
                } else d[i][j] = false;
            }
        }

        out.println(d[n][m] ? "YES" : "NO");

    }


    public static void main(String[] args) {
        new Task4().run();
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

    private String nextLine() {
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

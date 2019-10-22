package ru.mail.polis.ads.part5.kasimova;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        double c = scanner.nextDouble();
        double l = 0;
        double r = c;
        double x, y;
        do {
            x = (l + r) / 2;
            y = x * x + Math.sqrt(x);
            if (y > c) {
                r = x;
            } else {
                l = x;
            }
        } while (Math.abs(y - c) > 1.e-6);
        System.out.println(String.format("%.6f", x));
    }
}
package com.owlbg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class App {

    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter output = new PrintWriter(System.out, true);


    public static void main(String[] args) throws IOException {
        output.println("Введите первый IP адрес");
        String firstIpString = input.readLine();
        output.println("Введите второй IP адрес");
        String lastIpString = input.readLine();

        PrintableIpAddress printIp = new PrintableIpAddress(firstIpString);
        PrintableIpAddress lastIp = new PrintableIpAddress(lastIpString);

        if (!printIp.isLessThan(lastIp)) {
            output.println("Первый IP адрес должен быть меньше второго.");
            return;
        }

        printIp.increment();
        while (printIp.isLessThan(lastIp)) {
            output.println(printIp);
            printIp.increment();
        }
    }
}

package com.owlbg;

import org.apache.commons.validator.routines.InetAddressValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class App {

    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter output = new PrintWriter(System.out, true);


    public static void main(String[] args) throws IOException {
        InetAddressValidator ipValidator = InetAddressValidator.getInstance();

        output.println("Введите первый IP адрес");
        String firstIpString = input.readLine();
        if (!ipValidator.isValidInet4Address(firstIpString)) {
            output.println("Неправильный формат IP-адреса");
            return;
        }

        output.println("Введите второй IP адрес");
        String lastIpString = input.readLine();
        if (!ipValidator.isValidInet4Address(lastIpString)) {
            output.println("Неправильный формат IP-адреса");
            return;
        }

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

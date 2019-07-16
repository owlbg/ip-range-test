package com.owlbg;

import java.util.Arrays;

/**
 * Увеличиваемый IP4-адрес.<br/>
 * Поддерживает создание из строки, инкремент, сравнение (<) и вывод на печать, что позволяет проводить перебор IP-адресов.
 */
public class PrintableIpAddress {

    private int[] parts;

    /**
     * Создаёт экземпляр класса из заданной строки. Строка должна содержать правильный IP4-адрес.
     * @param ipString строка, содержащая правильный IP4-адрес.
     */
    public PrintableIpAddress(String ipString) {
        this.parts = ipStringToParts(ipString);
    }

    private static int[] ipStringToParts (String ipString) {
        int[] result = new int[4];

        String[] partsStrings = ipString.split("[.]");
        for (int i = 0; i <= 3; i++) {
            result[i] = Integer.parseInt(partsStrings[i]);
        }

        return result;
    }

    /**
     * Увеличение IP-адреса на единицу.
     */
    public void increment() {
        for (int i = 3; i >= 0; i--) {
            if (parts[i] < 255) {
                parts[i]++;
                break;
            } else {
                parts[i] = 0;
            }
        }
    }

    /**
     * Проверяем, что IP-адрес строго меньше другого IP-адреса.
     * @param another другой адрес
     * @return <b>true</b>, если вызывающий адрес строго меньше другого адреса, <b>false</b> в противном случае.
     */
    public boolean isLessThan(PrintableIpAddress another) {
        for (int i = 0; i <= 3; i++) {
           if (this.parts[i] < another.parts[i]) {
               return true;
           } else if (this.parts[i] > another.parts[i]) {
               return false;
           }
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("%d.%d.%d.%d", parts[0], parts[1], parts[2], parts[3]);
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj != null) && (obj instanceof PrintableIpAddress)) {
            return this.parts == ((PrintableIpAddress) obj).parts;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(parts);
    }
}

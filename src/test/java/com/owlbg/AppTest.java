package com.owlbg;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;

public class AppTest {
    @Test
    public void printableIpCreationTest() {
        PrintableIpAddress ipAddress = new PrintableIpAddress("1.4.7.4");
        assertThat("Строковый вывод должен совпадать с изначальной строкой адреса", ipAddress.toString(), equalTo("1.4.7.4"));
    }

    @Test
    public void printableIpIncrementTest() {
        PrintableIpAddress ipAddress1 = new PrintableIpAddress("23.12.130.254");
        for (int i = 1; i <= 10; i++) {
            ipAddress1.increment();
        }
        assertThat("23.12.130.254 после 10 инкрементов", ipAddress1.toString(), equalTo("23.12.131.8"));

        PrintableIpAddress ipAddress2 = new PrintableIpAddress("0.0.0.1");
        for (int i = 1; i <= 256 * 256; i++) {
            ipAddress2.increment();
        }
        assertThat("0.0.0.1 после 256*256 инкрементов", ipAddress2.toString(), equalTo("0.1.0.1"));
    }

    @Test
    public void printableIpLessTnanTest() {
        PrintableIpAddress ipAddress1 = new PrintableIpAddress("23.12.130.254");
        PrintableIpAddress ipAddress2 = new PrintableIpAddress("23.12.130.254");
        PrintableIpAddress ipAddress3 = new PrintableIpAddress("24.12.132.254");

        assertThat("23.12.130.254 < 23.12.130.254", ipAddress1.isLessThan(ipAddress2), equalTo(false));
        assertThat("23.12.130.254 < 24.12.132.254", ipAddress1.isLessThan(ipAddress3), equalTo(true));
        assertThat("24.12.132.254 < 23.12.130.254", ipAddress3.isLessThan(ipAddress1), equalTo(false));
    }
}

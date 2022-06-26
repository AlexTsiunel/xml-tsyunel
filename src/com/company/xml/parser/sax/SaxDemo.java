package com.company.xml.parser.sax;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.company.xml.Employee;

public class SaxDemo {
    private static final SaxEmployeeHandler handler = new SaxEmployeeHandler();

    public static void main(String[] args) {

        try (InputStream in = new FileInputStream("resources\\in\\employees.xml")) {
            List<Employee> employees = handler.deserialize(in);
            employees.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.company.xml.parser.stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.company.xml.Employee;
import com.company.xml.EmployeeRepositoryInMemory;
import com.company.xml.Repository;

public class StAXDemo {
    private static final Repository repo = new EmployeeRepositoryInMemory();
    private static final StAXDeserializer xmlReader = new StAXDeserializer();

    public static void main(String[] args) throws FileNotFoundException, IOException {

        try (InputStream in = new FileInputStream("resources\\employees.xml")) {
            List<Employee> employees = xmlReader.deserialize(in);
            employees.forEach(System.out::println);
        }
    }
}

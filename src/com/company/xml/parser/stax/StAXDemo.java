package com.company.xml.parser.stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.company.xml.Employee;
import com.company.xml.EmployeeRepositoryInMemory;
import com.company.xml.Repository;

public class StAXDemo {
//    private static final Repository repo = new EmployeeRepositoryInMemory();
    private static final StAXDeserializer xmlReader = new StAXDeserializer();
    private static final StAXSerializer xmlWriter = new StAXSerializer();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        List<Employee> employees = null;
        try (InputStream in = new FileInputStream("resources\\in\\employees.xml")) {
            employees = xmlReader.deserialize(in);
            employees.forEach(System.out::println);
        }
        
        try(OutputStream out = new FileOutputStream("resources\\out\\StAXemployees.xml")){
            xmlWriter.serialize(employees, out);
        }
    }
}

package com.company.xml.parser.jaxb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.company.xml.Employee;
import com.company.xml.EmployeeRepositoryInMemory;
import com.company.xml.Employees;
import com.company.xml.Repository;

public class JAXBDemo {
    private static final Repository<Employee> repo = new EmployeeRepositoryInMemory();
    private static final JAXBDeserializer xmlReader = new JAXBDeserializer();
    private static final JAXBSerializer xmlWriter = new JAXBSerializer();

    public static void main(String[] args) throws FileNotFoundException, IOException, JAXBException {
        try (InputStream in = new FileInputStream("resources\\in\\employees.xml")) {
            Employees employees = xmlReader.deserialize(in);
            List<Employee> list = employees.getEmployees();
            System.out.println(list.size());
            list .forEach(System.out::println);
        }

        try (OutputStream out = new FileOutputStream("resources\\out\\JAXBemployees.xml")) {
            Employees employees = new Employees();
            employees.setEmployees(repo.getAll());
            xmlWriter.serialize(employees, out);
        }
    }
}

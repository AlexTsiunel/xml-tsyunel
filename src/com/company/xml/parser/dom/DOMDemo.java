package com.company.xml.parser.dom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.company.xml.Employee;
import com.company.xml.EmployeeRepositoryInMemory;
import com.company.xml.Repository;

public class DOMDemo {
    private static Repository<Employee> repo = new EmployeeRepositoryInMemory();
    private static DOMDeserializer xmlReader = new DOMDeserializer();
    private static DOMSerializer xmlWriter = new DOMSerializer();

    public static void main(String[] args)
            throws FileNotFoundException, IOException, ParserConfigurationException, SAXException, TransformerException {
        
        try (InputStream in = new FileInputStream("resources\\in\\employees.xml")) {
            List<Employee> employees = xmlReader.deserialize(in);
            employees.forEach(System.out::println);
        }
        
        
        try(OutputStream out = new FileOutputStream("resources\\out\\DOMemployees.xml")){
            List<Employee> employees = repo.getAll();
            Document doc = xmlWriter.createDocument(employees);
            xmlWriter.serializer(doc, out, true);
        }
    }
}

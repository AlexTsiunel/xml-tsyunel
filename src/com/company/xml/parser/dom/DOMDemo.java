package com.company.xml.parser.dom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.company.xml.Employee;

public class DOMDemo {
    private static DOMDeserializer xmlWriter = new DOMDeserializer();

    public static void main(String[] args)
            throws FileNotFoundException, IOException, ParserConfigurationException, SAXException {
        
        
        try (InputStream in = new FileInputStream("resources\\in\\employees.xml")) {
            List<Employee> employees = xmlWriter.deserialize(in);
            employees.forEach(System.out::println);
        }
    }
}

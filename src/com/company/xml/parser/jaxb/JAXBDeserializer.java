package com.company.xml.parser.jaxb;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.company.xml.Employees;

public class JAXBDeserializer {
    public Employees deserialize(InputStream in) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            return (Employees) un.unmarshal(in);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}

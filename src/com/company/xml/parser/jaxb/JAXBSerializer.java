package com.company.xml.parser.jaxb;

import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.company.xml.Employees;

public class JAXBSerializer {
    public void serialize(Employees employees, OutputStream out) {
        try {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(employees, out);
        } catch (JAXBException e) {
            
            e.printStackTrace();
        }
    }
}

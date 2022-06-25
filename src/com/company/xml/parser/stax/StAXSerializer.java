package com.company.xml.parser.stax;

import java.io.OutputStream;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.company.xml.Employee;


public class StAXSerializer {
    public void serialize(List<Employee> employees, OutputStream out) {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = null;
        try {
            writer = factory.createXMLStreamWriter(out);
            writer.writeStartDocument();
            writer.writeStartElement("employees");

            for (Employee employee : employees) {
                serialize(employee, writer);
            }

            writer.writeEndElement();
            writer.writeEndDocument();
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } finally {
            close(writer);
        }
    }

    public void serialize(Employee user, XMLStreamWriter writer) throws XMLStreamException {
        writer.writeStartElement("user");
        writer.writeAttribute("id", user.getId().toString());

        writer.writeStartElement("firstName");
        writer.writeCharacters(user.getFirstName());
        writer.writeEndElement();

        writer.writeStartElement("lastName");
        writer.writeCharacters(user.getLastName());
        writer.writeEndElement();

        writer.writeStartElement("email");
        writer.writeCharacters(user.getEmail());
        writer.writeEndElement();

        writer.writeStartElement("phoneNumber");
        writer.writeCharacters(user.getPhoneNumber());
        writer.writeEndElement();
        
        writer.writeStartElement("password");
        writer.writeCharacters(user.getPassword());
        writer.writeEndElement();
        
        writer.writeStartElement("tag");
        writer.writeCharacters(user.getTag());
        writer.writeEndElement();
        
        writer.writeStartElement("userRoleId");
        writer.writeCharacters(user.getUserRoledId().toString());
        writer.writeEndElement();

        writer.writeEndElement();
    }

    private void close(XMLStreamWriter writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (XMLStreamException e) {
                throw new RuntimeException();
            }
        }
    }
}

package com.company.xml.parser.stax;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.company.xml.Employee;

public class StAXDeserializer {

    public List<Employee> deserialize(InputStream in) {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader reader = factory.createXMLEventReader(in);

            List<Employee> employees = new ArrayList<>();
            Employee employee = null;
            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                if (event.isStartElement()) {
                    StartElement start = event.asStartElement();
                    String elementName = start.getName().getLocalPart();
                    switch (elementName) {
                    case "employee":
                        employee = processEmployee(start, employees);
                        break;
                    case "firstName":
                        processFirstName(reader, employee);
                        break;
                    case "lastName":
                        processLastName(reader, employee);
                        break;
                    case "email":
                        processEmail(reader, employee);
                        break;

                    case "phoneNumber":
                        processPhoneNumber(reader, employee);
                        break;

                    case "password":
                        processPassword(reader, employee);
                        break;

                    case "tag":
                        processTag(reader, employee);
                        break;
                    case "userRoleId":
                        processUserRoleId(reader, employee);
                        break;
                    }
                }
            }
            return employees;
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        }
    }

    private Employee processEmployee(StartElement start, List<Employee> employees) {
        Employee employee = new Employee();
        employee.setId(Long.parseLong(start.getAttributeByName(new QName("id")).getValue()));
        employees.add(employee);
        return employee;
    }

    private void processFirstName(XMLEventReader reader, Employee employee) throws XMLStreamException {
        employee.setFirstName(reader.getElementText());
    }

    private void processLastName(XMLEventReader reader, Employee employee) throws XMLStreamException {
        employee.setLastName(reader.getElementText());
    }

    private void processEmail(XMLEventReader reader, Employee employee) throws XMLStreamException {
        employee.setEmail(reader.getElementText());
    }

    private void processPhoneNumber(XMLEventReader reader, Employee employee) throws XMLStreamException {
        employee.setPhoneNumber(reader.getElementText());
    }

    private void processPassword(XMLEventReader reader, Employee employee) throws XMLStreamException {
        employee.setPassword(reader.getElementText());
    }

    private void processTag(XMLEventReader reader, Employee employee) throws XMLStreamException {
        String rawData = reader.getElementText();
        employee.setTag(rawData);
    }

    private void processUserRoleId(XMLEventReader reader, Employee employee) throws XMLStreamException {
        String rawData = reader.getElementText();
        employee.setUserRoledId(Byte.parseByte(rawData));
    }
}

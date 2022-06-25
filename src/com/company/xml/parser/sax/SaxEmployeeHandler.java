package com.company.xml.parser.sax;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.company.xml.Employee;

public class SaxEmployeeHandler extends DefaultHandler {

    private List<Employee> employees;
    private Employee employee;
    private String element;
    private StringBuilder text;

    public List<Employee> deserialize(InputStream in) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(in, this);
            return employees;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void startDocument() throws SAXException {
        employees = new ArrayList();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        element = qName;
        switch (element) {
        case "employees":
            break;

        case "employee":
            employee = new Employee();
            employees.add(employee);
            String rawId = attributes.getValue("id");
            Long id = Long.parseLong(rawId);
            employee.setId(id);
            break;

        default:
            text = new StringBuilder();
            break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (text != null) {
            text.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String content = text.toString();
        switch (element) {
        case "firstName":
            employee.setFirstName(content);
            break;
        case "lastName":
            employee.setLastName(content);
            break;
        case "email":
            employee.setEmail(content);
            break;
        case "phoneNumber":
            employee.setPhoneNumber(content);
            break;
        case "password":
            employee.setPassword(content);
            break;
        case "tag":
            employee.setTag(content);
            break;
        case "userRoleId":
            byte[] contentAsBytes = content.getBytes();
            employee.setUserRoledId(contentAsBytes[0]);
            break;
        }
        element = "";
    }

    @Override
    public void endDocument() throws SAXException {
    }
}

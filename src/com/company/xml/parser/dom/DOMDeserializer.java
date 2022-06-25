package com.company.xml.parser.dom;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.company.xml.Employee;

public class DOMDeserializer {
    public List<Employee> deserialize(InputStream in) throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(in);

        List<Employee> employees = new ArrayList<>();
        Element root = document.getDocumentElement();
        NodeList nodes = root.getElementsByTagName("employee");

        for (int i = 0; i < nodes.getLength(); i++) {
            employees.add(getEmployee(nodes.item(i)));
        }

        return employees;

    }

    private static Employee getEmployee(Node node) {
        Element employeeElm = (Element) node;
        Employee employee = new Employee();

        String rawId = employeeElm.getAttribute("id");
        long id = Long.parseLong(rawId);
        employee.setId(id);

        Element firstNameElm = (Element) employeeElm.getElementsByTagName("firstName").item(0);
        employee.setFirstName(firstNameElm.getTextContent());

        Element lastNameElm = (Element) employeeElm.getElementsByTagName("lastName").item(0);
        employee.setLastName(lastNameElm.getTextContent());

        Element emailElm = (Element) employeeElm.getElementsByTagName("email").item(0);
        employee.setEmail(emailElm.getTextContent());

        Element phoneNumberElm = (Element) employeeElm.getElementsByTagName("phoneNumber").item(0);
        employee.setPhoneNumber(lastNameElm.getTextContent());

        Element passwordElm = (Element) employeeElm.getElementsByTagName("password").item(0);
        employee.setPassword(passwordElm.getTextContent());

        Element tagElm = (Element) employeeElm.getElementsByTagName("tag").item(0);
        employee.setTag(tagElm.getTextContent());

        Element userRoleIdElm = (Element) employeeElm.getElementsByTagName("userRoleId").item(0);
        byte[] byteArray = userRoleIdElm.getTextContent().getBytes();
        employee.setUserRoledId(byteArray[0]);

        return employee;
    }
}

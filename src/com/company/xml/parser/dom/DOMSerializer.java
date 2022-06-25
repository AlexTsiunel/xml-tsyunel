package com.company.xml.parser.dom;

import java.io.OutputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.company.xml.Employee;

public class DOMSerializer {

    public void serializer(List<Employee> employees, OutputStream out, boolean prettyFormate) {
        serializer(createDocument(employees), out, prettyFormate);
    }

    public void serializer(Document document, OutputStream out, boolean prettyFormate) {

        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            if (prettyFormate == true) {
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            }
            transformer.transform(new DOMSource(document), new StreamResult(out));
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    public Document createDocument(List<Employee> employees) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("employees");
            document.appendChild(root);

            employees.forEach(employee -> {
                serializeUser(document, employee, root);
            });

            return document;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private void serializeUser(Document document, Employee employee, Element root) {
        Element employeeElm = createEmployeeElement(document, employee, root);
        processFirstName(document, employee, employeeElm);
        processLastName(document, employee, employeeElm);
        processEmail(document, employee, employeeElm);
        processPhoneNumber(document, employee, employeeElm);
        processPassword(document, employee, employeeElm);
        processTag(document, employee, employeeElm);
        processUserRoleId(document, employee, employeeElm);
    }

    private Element createEmployeeElement(Document document, Employee employee, Element root) {
        Element employeeElm = document.createElement("employee");
        root.appendChild(employeeElm);
        employeeElm.setAttribute("id", employee.getId().toString());
        return employeeElm;
    }

    private void processFirstName(Document document, Employee employee, Element employeeElm) {
        Element firstNameElm = document.createElement("firstName");
        employeeElm.appendChild(firstNameElm);
        firstNameElm.setTextContent(employee.getFirstName());
    }

    private void processLastName(Document document, Employee employee, Element employeeElm) {
        Element lastNameElm = document.createElement("lastName");
        employeeElm.appendChild(lastNameElm);
        lastNameElm.setTextContent(employee.getLastName());
    }

    private void processEmail(Document document, Employee employee, Element employeeElm) {
        Element emailElm = document.createElement("email");
        employeeElm.appendChild(emailElm);
        emailElm.setTextContent(employee.getEmail());
    }

    private void processPassword(Document document, Employee employee, Element employeeElm) {
        Element passwordElm = document.createElement("password");
        employeeElm.appendChild(passwordElm);
        passwordElm.setTextContent(employee.getPassword());
    }

    private void processPhoneNumber(Document document, Employee employee, Element employeeElm) {
        Element phoneNumberElm = document.createElement("phoneNumber");
        employeeElm.appendChild(phoneNumberElm);
        phoneNumberElm.setTextContent(employee.getPhoneNumber());
    }

    private void processTag(Document document, Employee employee, Element employeeElm) {
        Element tagElm = document.createElement("tag");
        employeeElm.appendChild(tagElm);
        tagElm.setTextContent(employee.getTag());
    }

    private void processUserRoleId(Document document, Employee employee, Element employeeElm) {
        Element userRoleIdElm = document.createElement("userRoleId");
        employeeElm.appendChild(userRoleIdElm);
        userRoleIdElm.setTextContent(employee.getUserRoledId().toString());
    }
}

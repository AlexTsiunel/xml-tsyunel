package com.company.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employees")
public class Employees {
    
    private List<Employee> employees = new ArrayList<>();

    public Employees() {
        super();
    }

    public List<Employee> getEmployees() {
        return employees;
    }
    @XmlElement( name = "employee" )
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public boolean add(Employee em) {
        return employees.add(em);
    }

    @Override
    public String toString() {
        return "Employees [employees=" + employees + "]";
    }
}
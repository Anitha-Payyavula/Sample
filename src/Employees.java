package com.anitha.demorest;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
public class Employees 
{
    
    private List<Employee> employeeList;
 
    public List<Employee> getEmployeeList() {
        return employeeList;
    }
 
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
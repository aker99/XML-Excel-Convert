package com.demo.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "customers")
public class Customers {
    List<Customer> customers;

    public List<Customer> getCustomers() {
        return customers;
    }

    @XmlElement(name = "customer")
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "customers=" + customers.toString() +
                '}';
    }

    public void add(Customer customer){
        if(this.customers==null){
            this.customers = new ArrayList<Customer>();
        }
        this.customers.add(customer);
    }
}

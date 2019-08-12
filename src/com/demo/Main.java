package com.demo;

import com.demo.model.Customer;
import com.demo.model.Customers;
import com.demo.utlis.ExcelConvert;
import com.demo.utlis.XMLConvert;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("ABC12","Himanshu","xyz","9582882013");
        Customer customer1 = new Customer("ABC13","Himan","xyz","9582882013");
        Customers customers = new Customers();
        customers.add(customer);
        customers.add(customer1);
        try {
            XMLConvert.objectToXML(customers);
            Customers readCust = XMLConvert.XMLToObject();
            ExcelConvert.objectToExcel(readCust);
            readCust = ExcelConvert.ExcelToObject();
            System.out.println("Customer:"+readCust.toString());
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }

    }
}

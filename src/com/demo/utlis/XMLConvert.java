package com.demo.utlis;

import com.demo.model.Customer;
import com.demo.model.Customers;

import javax.xml.bind.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class XMLConvert {

    static JAXBContext contextObj;
    static File file = new File("customer.xml");

//    {
//        try {
//            contextObj = JAXBContext.newInstance(Customer.class);
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//    }
    public  static void objectToXML(Customers customer) throws JAXBException, FileNotFoundException {
        contextObj = JAXBContext.newInstance(Customers.class);
        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshallerObj.marshal(customer, new FileOutputStream(file));
    }

    public static  Customers XMLToObject() throws JAXBException {
        contextObj = JAXBContext.newInstance(Customers.class);
        Unmarshaller unmarshaller = contextObj.createUnmarshaller();
        return  (Customers) unmarshaller.unmarshal(file);
    }
}

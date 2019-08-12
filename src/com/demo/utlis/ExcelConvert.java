package com.demo.utlis;

import com.demo.model.Customer;
import com.demo.model.Customers;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;

public class ExcelConvert {
    private static File file = new File("customer.xlsx");

    public static void objectToExcel(Customers customers) throws IOException {

        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        int rowCount = 0;

        for (Customer customer : customers.getCustomers()) {
            Row row = sheet.createRow(rowCount++);
            writeBook(customer, row);
        }

        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            workbook.write(outputStream);
        }
    }

    public  static Customers ExcelToObject() throws IOException {

        FileInputStream excelFile = new FileInputStream(file);
        Workbook workbook = new HSSFWorkbook(excelFile);
        Sheet datatypeSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = datatypeSheet.iterator();
        Customers customers =  new Customers();

        while (iterator.hasNext()) {

            Row currentRow = iterator.next();
            customers.add(readBook(currentRow));
        }
        return  customers;
    }

    private static void writeBook(Customer customer, Row row) {
        Cell cell = row.createCell(1);
        cell.setCellValue(customer.getId());

        cell = row.createCell(2);
        cell.setCellValue(customer.getName());

        cell = row.createCell(3);
        cell.setCellValue(customer.getAddress());

        cell = row.createCell(4);
        cell.setCellValue(customer.getPhone());
    }

    private static Customer readBook(Row row) {
        Customer customer = new Customer();

        Cell cell = row.getCell(1);
        customer.setId(cell.getStringCellValue());

        cell = row.createCell(2);
        customer.setName(cell.getStringCellValue());

        cell = row.createCell(3);
        customer.setAddress(cell.getStringCellValue());

        cell = row.createCell(4);
        customer.setPhone(cell.getStringCellValue());

        return customer;
    }
}

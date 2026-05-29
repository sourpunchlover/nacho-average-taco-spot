package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
    private String folderPath = "orderreceipts/";

    public void saveOrderReceipt(Order order) {

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String fileName = date.format(dateFormatter) + ".txt";


        try {
            FileWriter fileWriter = new FileWriter(folderPath + fileName);
            BufferedWriter buffWriter = new BufferedWriter(fileWriter);
            buffWriter.write(order.getOrderSummary());

            buffWriter.close();
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("Error! Receipt not saved!");
        }
    }
}

package com.company;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Adding_homework {
    Adding_homework(){
        Scanner input = new Scanner(System.in);
        Scanner zz = new Scanner(System.in);
        System.out.println("********************************************");
        System.out.print("Enter the subject : ");
        String subject = input.next();
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        System.out.print("Enter due date : ");
        String due_date = input.next();
        System.out.println("Enter the hw : ");
        String hw = zz.nextLine();
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\BN Gaming\\IdeaProjects\\school managment\\src\\com\\company\\database_files\\homework.db");
            Statement stm = conn.createStatement();
            String query ="INSERT INTO homework " +
                    "(subject,hw,Date,due_date) VALUES("+"'"+subject+"',"+"'"+hw+"',"+"'"+formattedDate+"',"+"'"+due_date+"'"+");";
            stm.executeUpdate(query);
            System.out.println("written homework in database : ");
            System.out.println("subject : "+subject);
            System.out.println("homework : "+hw);
            System.out.println("added on : "+formattedDate);
            System.out.println("due date : "+due_date);
        }catch(Exception e){
            System.out.println("error : "+e);
        }
        System.out.println("***************************************");
        System.out.print("Enter 1 to enter another homework  \nEnter 2 to go back to admin panel \nEnter : ");
        int ask = input.nextInt();
        switch (ask){
            case 1:
                new Adding_homework();
                break;
            case 2:
                new admin();
                break;
            default:
                System.out.println("You entered a wrong number going back to admin panel");
                new admin();
                break;
        }
    }
}

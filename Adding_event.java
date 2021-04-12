package com.company;


import java.sql.*;
import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Adding_event {
    Adding_event(){
        Scanner input = new Scanner(System.in);
        System.out.println("********************************************");
        System.out.println("Enter an event : ");
        String insert = input.nextLine();
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");

        String formattedDate = myDateObj.format(myFormatObj);
        String all ="Event : "+insert;
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\BN Gaming\\IdeaProjects\\school managment\\src\\com\\company\\database_files\\events.db");
            Statement stm = conn.createStatement();
            String query ="INSERT INTO events " +
                    "(event, Date) VALUES('"+all+"',"+"'"+formattedDate+"');";
            stm.executeUpdate(query);
            System.out.println("written event in database : ");
        }catch(Exception e){
            System.out.println("error : "+e);
        }
        System.out.println(all+"\nDate : "+formattedDate);
        System.out.println("***************************************");
        System.out.print("Enter 1 to enter another event  \nEnter 2 to go back to admin panel \nEnter : ");
        int ask = input.nextInt();
        switch (ask){
            case 1:
                new Adding_event();
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

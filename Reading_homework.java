package com.company;

import java.sql.*;

public class Reading_homework {
    Reading_homework(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\BN Gaming\\IdeaProjects\\school managment\\src\\com\\company\\database_files\\homework.db");
            Statement stm = conn.createStatement();
            String query ="SELECT * FROM homework ;";
            ResultSet rs =stm.executeQuery(query);
            int i =0;
            System.out.println("\n******************************* Home work *******************************\n");
            while (rs.next()){
                i+=1;
                String  subject = rs.getString("subject");
                String hw  = rs.getString("hw");
                String Date = rs.getString("Date");
                String due_date = rs.getString("due_date");
                System.out.println("homework no "+i+" :"+"\nSubject : "+subject+"\nHome work : "+hw);
                System.out.println("added on :"+Date+"\nDue Date:"+due_date);
                System.out.println(" ");
            }
            System.out.println("**********************************************************************");
                System.out.println("sorry seasion timed out please enter password again");
                new Student();
        }catch(Exception e){
            System.out.println("error : "+e);
        }
    }
}

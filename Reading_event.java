package com.company;

import java.sql.*;


public class Reading_event {
    Reading_event(String type){
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\BN Gaming\\IdeaProjects\\school managment\\src\\com\\company\\database_files\\events.db");
            Statement stm = conn.createStatement();
            String query ="SELECT * FROM events ;";
            ResultSet rs =stm.executeQuery(query);
            int i =0;
            System.out.println("\n*******************************Events portal*******************************\n");
            while (rs.next()){
                i+=1;
                String  event = rs.getString("event");
                String Date  = rs.getString("Date");
                System.out.println(i+". "+event+"\n"+"added on : "+Date);
            }
            System.out.println("**********************************************************************");
            if (type.equals("admin")){
                System.out.println("sorry seasion timed out please enter password again");
               new admin();
            }
            else {
                System.out.println("sorry seasion timed out please enter password again");
                new Student();
            }
        }catch(Exception e){
            System.out.println("error : "+e);
        }
    }
}

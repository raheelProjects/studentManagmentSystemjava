package com.company;

import java.sql.*;
import java.util.Scanner;

public class Authentication  {
    private String user;
    private String pass;
     Authentication(){
         Scanner ab = new Scanner(System.in);
         System.out.println("*************************************************");
         System.out.print("enter user : ");
        this.user = ab.next();
         System.out.print("enter password : ");
        this.pass = ab.next();
     }

     boolean authenticate(String file_name,String table_name) {
         boolean st ;
         try {
             Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\BN Gaming\\IdeaProjects\\school managment\\src\\com\\company\\database_files\\"+file_name);
             Statement stm = conn.createStatement();
             String query ="SELECT * FROM "+table_name+" WHERE username = '"+this.user+"'"+" AND password = '"+this.pass+"';";
             ResultSet rs = stm.executeQuery(query);
             if (rs.next()){
                 st=true;
                 return st;
             }
             else{
                 st=false;
                 return st;
             }

         } catch (Exception e) {
             System.out.println("The error is:"+e);
             st=false;
             return st;
         }
     }
}

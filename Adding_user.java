package com.company;
import java.sql.*;
import java.util.Scanner;

public class Adding_user {
    /* created by raheel,kavish ,mir,zaid*/
    Adding_user(){
        Scanner input = new Scanner(System.in);
        System.out.println("********************************************");
        System.out.print("Enter name for user : ");
        String user_name = input.next();
        System.out.print("Enter password:");
        String password_created =input.next();
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\BN Gaming\\IdeaProjects\\school managment\\src\\com\\company\\database_files\\student.db");
            Statement stm = conn.createStatement();
            Statement ab = conn.createStatement();
            String query ="SELECT * FROM students WHERE username = '"+user_name+"';";
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()){
                System.out.println("*****************************************");
                System.out.println(" sorry user exists please try again");
                System.out.println("********************************************");
                new Adding_user();
            }else{
            String insert ="INSERT INTO students " +
                    "(username, password) VALUES("+"'"+user_name+"',"+"'"+password_created+"'"+");";
            ab.executeUpdate(insert);
            System.out.println("user created : ");}
        }catch(Exception e){
            System.out.println("error : "+e);
        }
        System.out.println("username : "+user_name);
        System.out.println("password : "+password_created);
        System.out.println("***************************************");
        System.out.print("Enter 1 to enter another user  \nEnter 2 to go back to admin panel \nEnter : ");
        int ask = input.nextInt();
        switch (ask){
            case 1:
                new Adding_user();
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

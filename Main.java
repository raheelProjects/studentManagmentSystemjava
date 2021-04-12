package com.company;

import java.util.Scanner;



public class Main {
    public static void done(){
        try {
        Scanner input = new Scanner(System.in);
        String xyz ="xyz school portal";
        String command[]={"to access admin panel","to access student portal","exit portal"};
        Intro_fun z = new Intro_fun(xyz,command,3);
        String intro = z.makeit();
        System.out.println(intro);
        System.out.print("Enter a number:");
        int abc = input.nextInt();
        switch (abc){
            case 1:
                new admin();
                break;
            case 2:
                new Student();
                break;
            case 3:
                System.out.println("\nclosing portal");
                break;
            default:
                System.out.println("entered a wrong number enter 3 if you want to exit portal");
                done();
                break;}

        }catch(Exception e){
            System.out.println("you did something wrong");
            done();
        }
    }

    public static void main(String[] args) {
        done();

    }
}

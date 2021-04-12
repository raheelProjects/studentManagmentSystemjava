package com.company;

import java.util.Scanner;

import static com.company.Main.done;

public class Student {

    Student() {
        String person = "student portal";
        String commands[] = {"to check event", "to check homework", "log out"};
        int len = 3;
        Intro_fun z = new Intro_fun(person, commands, len);
        String doit = z.makeit();
        Scanner input = new Scanner(System.in);
        Authentication ab = new Authentication();
        if (ab.authenticate("student.db", "students")) {
            st_activation(doit);

        } else {
            System.out.println("sorry wrong username or password enter again:");
            new Student();
        } }
    public static void st_activation (String ab) {
        System.out.println(ab);
        Scanner itn = new Scanner(System.in);
        System.out.print("Enter : ");
        int az = itn.nextInt();
        switch (az) {
            case 1:
                new Reading_event("student");
                break;
            case 2:
                new Reading_homework();
                break;
            case 3:
                done();
                break;
            default:
                System.out.println("Entered wrong number");
                st_activation(ab);
                break;
        }
    }
}
package com.company;


import java.util.Scanner;

import static com.company.Main.done;

public class admin {

    admin() {
        String person = "admin panel";
        String commands[] = {"to add event", "to add user","read events","to add homework","Log out"};
        int len = 5;
        Intro_fun z = new Intro_fun(person, commands, len);
        String doit = z.makeit();
        Authentication ab = new Authentication();
        if (ab.authenticate("admin_au.db","admin_au")) {
            activation(doit);
        } else {
            System.out.println("you entered wrong password ");
            System.out.println("****************************************");
            System.out.println("loging back to main system");
            done();
        }
    }

    public static void activation(String ab) {
        System.out.println(ab);
        Scanner itn = new Scanner(System.in);
        System.out.print("Enter : ");
        int az = itn.nextInt();
        switch (az) {
            case 1:
                new Adding_event();
                break;
            case 2:
                new Adding_user();
                break;
            case 3:
                new Reading_event("admin");
                break;
            case 4:
                new Adding_homework();
                break;
            case 5:
                done();
                break;
            default:
                System.out.println("Entered wrong number");
                activation(ab);
                break;
        }
    }
}

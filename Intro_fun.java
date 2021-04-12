package com.company;

public class Intro_fun {
    final private String person;
    final private String commands[];
    final private int len;
    Intro_fun(String person,String commands[],int len){
        this.person=person;
        this.commands=commands;
        this.len=len;
    }
    String makeit(){
       String first_line="";
       String end_line="";
       for(int i =0;i<58;i++){
           first_line+="*";
           end_line+="*";
       }
       String per="\nWell come to "+person+" \n"+"\n";
       String press="";
       for(int m=0;m<len;m++){
           press+="Press "+(m+1)+" "+commands[m]+"\n";
       }
       String made =first_line+per+press+end_line;
       return made;
    }
}

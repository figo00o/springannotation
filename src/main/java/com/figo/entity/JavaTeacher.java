package com.figo.entity;

import java.util.Date;

public class JavaTeacher extends Teacher {
    public JavaTeacher(String name,String idno){
        super(name,idno);
        System.out.println("JavaTeacher");
    }

    public Date getDate(){
       return super.getDate();
    }
}

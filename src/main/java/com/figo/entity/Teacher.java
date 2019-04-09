package com.figo.entity;

import java.util.Date;

public abstract class Teacher {
    private String name;
    private String idno;

    public Teacher(){
        System.out.println("teacher");
    }
    public Teacher(String name,String idno){
        this.name = name;
        this.idno = idno;
    }

    public  Date getDate(){
        return new Date();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }
}

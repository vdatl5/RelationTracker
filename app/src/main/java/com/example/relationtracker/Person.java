package com.example.relationtracker;

import android.content.Context;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person {

    ArrayList<Person> children;
    ArrayList<Person> parents;
    ArrayList<Person> friends;
    private int gender; //0 is female, 1 is male
    private String firstName;
    private String lastName;

    private Date birthDay;


    public Person(String newfirstName, String newlastName, int newgender){
        children = new ArrayList<>();
        parents = new ArrayList<>();
        friends = new ArrayList<>();

        //set the compulsory data
        gender = newgender;
        firstName = newfirstName;
        lastName = newlastName;


    }

    public void addChild(Person child){
        children.add(child);

    }

    public void getChildrenNames(){
        String names = "";

        for(Person child: children){
            System.out.println(child.firstName + " " + child.lastName);
        }

    }


    public void addParents(Person parent){
        parents.add(parent);
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public int getGender(){
        return this.gender;

    }




}

package com.example.myapplications;

public class customer {
    String Name;
    String Add;
    String City;
    String State;


    public customer(String name,String add,String city,String state) {
        Name = name;
        Add=add;
        City=city;
State=state;
    }


    public String getName() {
        return Name;
    }

    public String getAdd() {
        return Add;
    }

    public String getCity() {
        return City;
    }
    public String getState() {
        return State;
    }

}

package com.company;

public class Player {
    private String name;

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
//        check against null and empty name
        if(name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }
}

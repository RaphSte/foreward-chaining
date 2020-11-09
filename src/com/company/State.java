package com.company;

public class State implements Evaluatable {

    private String name;
    private int state = -1;

    public State(String name) {
        this.name = name;
    }

    public State(int state) {
        this.state = state;
    }


    public State(String name, int state) {
        this.state = state;
    }

    public State() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        System.out.println("Set State " + name +" to '" + state+"'");
    }

    public State not() {
        if (state == 0){
            return new State("not "+ this.name, 1);
        }
        if (state == 1){
            return new State("not "+ this.name, 0);
        }
        if (state == -1){
            return new State("not "+ this.name, -1);
        }
        return this;
    }

    @Override
    public int evaluate() {
            return state;
    }
}

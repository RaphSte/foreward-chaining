package com.company;

import java.util.ArrayList;

public class Premise implements Evaluatable {

    private ArrayList<Evaluatable> evaluatables;
    private Evaluatable result;
    private int state = -1;

    public Premise() {
        this.evaluatables = new ArrayList<Evaluatable>();
    }

    public void addEvaluatable(Evaluatable evaluatable){
        evaluatables.add(evaluatable);
    }

    public void addResult(Evaluatable result){
        this.result = result;
    }

    @Override
    public int evaluate(){

        if(result.evaluate() == 0){
            evaluatables.get(0).setState(0);
            return (0);
        }
        if(result.evaluate() == 1){
            evaluatables.get(0).setState(1);
            return (1);
        }
        if(evaluatables.get(0).evaluate() == 1){
            result.setState(1);
            return (1);
        }
        if(evaluatables.get(0).evaluate() == 0){
            result.setState(0);
            return (0);
        }
        return -1;
    }

    @Override
    public void setState(int state) {
        this.state = state;
    }

}

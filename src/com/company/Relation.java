package com.company;

public class Relation implements Evaluatable {

    private Evaluatable evaluatableA;
    private Evaluatable evaluatableB;
    private LogicConnection logicConnection;
    private int state = -1;

    public Relation(Evaluatable evaluatableA, LogicConnection logicConnection, Evaluatable evaluatableB) {
        this.evaluatableA = evaluatableA;
        this.evaluatableB = evaluatableB;
        this.logicConnection = logicConnection;
    }

    public Relation() {
    }

    public Evaluatable getEvaluatableA() {
        return evaluatableA;
    }

    public void setEvaluatableA(Relation RelationA) {
        this.evaluatableA = RelationA;
    }

    public Evaluatable getEvaluatableB() {
        return evaluatableB;
    }

    public void setEvaluatableB(Relation RelationB) {
        this.evaluatableB = RelationB;
    }

    public LogicConnection getLogicConnection() {
        return logicConnection;
    }

    public void setLogicConnection(LogicConnection logicConnection) {
        this.logicConnection = logicConnection;
    }

    public int getState() {
        return state;
    }

    @Override
    public void setState(int state) {
        this.state = state;
    }

    @Override
    public int evaluate() {

        int evalA = evaluatableA.evaluate();
        int evalB = evaluatableB.evaluate();

        if (logicConnection.equals(LogicConnection.AND)) {
            //and
            if (evalA == 1 && evalB == 1) {
                setState(1);
                return 1;
            }
            if (evalA == 0 && evalB == 1) {
                setState(0);
                return 0;
            }
            if (evalA == 1 && evalB == 0) {
                setState(0);
                return 0;
            }
            if (evalA == 0 && evalB == 0) {
                setState(0);
                return 0;
            } else {
                //invalid or not set
                setState(-1);
                return -1;
            }

        } else {
            //or
            if (evaluatableA.evaluate() == 1 || evaluatableB.evaluate() == 1) {
                return 1;
            }
            if (evaluatableA.evaluate() == 0 && evaluatableB.evaluate() == 0) {
                return 0;
            } else {
                //invalid or not set
                return -1;
            }
        }

    }


}

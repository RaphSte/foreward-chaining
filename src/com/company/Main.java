package com.company;

public class Main {

    public static void main(String[] args) {

        //willIWearSunGlasses();

        //(sunny v hot) ^ free time -> swimming
        //willGoSwimming();

        //willWeBeHomeBySunset();

        enemyOfUsa();
    }

    private static void enemyOfUsa() {
        //define states
        State nonoHasMissiles = new State("nonoHasMissiles");
        State colWestIsAmerican = new State("colWestIsAmerican");
        State nonoHasWeapons = new State("nonoHasWeapons");
        State colWestSoldMissiles = new State("colWestSoldMissiles");
        State nonoIsHostile = new State("hostile");
        State nonoIsEnemy = new State("nonoIsEnemy");
        State colWestCommittedCrime = new State("colWestCommittedCrime");
        State colWestisCriminal = new State("colWestisCriminal");


        //given States from knowledge base
        //nono has missiles
        nonoHasMissiles.setState(1);
        //col. west is colWestIsAmerican
        colWestIsAmerican.setState(1);
        //col. west sold to nono
        colWestSoldMissiles.setState(1);
        //nono is nonoIsEnemy
        nonoIsEnemy.setState(1);


        //nonoHasMissiles -> nonoHasWeapons
        Premise p3 = new Premise();
        p3.addEvaluatable(nonoHasMissiles);
        p3.addResult(nonoHasWeapons);
        p3.evaluate();

        //nonoIsEnemy -> hostile
        Premise p2 = new Premise();
        p2.addEvaluatable(nonoIsEnemy);
        p2.addResult(nonoIsHostile);
        p2.evaluate();


        //relations to connect all things with AND
        // r3 = colWestIsAmerican ^ nonoHasWeapons ^ selling ^ hostileNation
        Relation r1 = new Relation(colWestIsAmerican, LogicConnection.AND, nonoHasWeapons);
        Relation r2 = new Relation(colWestSoldMissiles, LogicConnection.AND, nonoIsHostile);
        Relation r3 = new Relation(r1, LogicConnection.AND, r2);

        //crime to for colWestIsAmerican to sell weapons to hostile nations (colWestIsAmerican ^ nonoHasWeapons ^ selling ^ hostileNation -> crime)
        Premise p1 = new Premise();
        p1.addEvaluatable(r3);
        p1.addResult(colWestCommittedCrime);
        p1.evaluate();

        //committed crime -> crimminal
        Premise p5 = new Premise();
        p5.addEvaluatable(colWestCommittedCrime);
        p5.addResult(colWestisCriminal);
        p5.evaluate();


        System.out.println("\n###############################\nCol. West is is a criminal? " +
                colWestisCriminal.getState() +
                "\n###############################\n");

    }


    private static void willGoSwimming() {
        State sunny = new State("sunny");
        State hot = new State("hot");
        State freeTime = new State("free time");
        State goSwimming = new State("go swimming");

        sunny.setState(0);
        hot.setState(1);
        freeTime.setState(1);


        Relation sunnyOrHot = new Relation(sunny, LogicConnection.OR, hot);
        Relation rel1AndFreeTime = new Relation(sunnyOrHot, LogicConnection.AND, freeTime);

        Premise p1 = new Premise();
        p1.addEvaluatable(rel1AndFreeTime);
        p1.addResult(goSwimming);
        p1.evaluate();

        System.out.println("Will I go swimming? " + goSwimming.getState());

    }


    private static void willIWearSunGlasses() {
        State sunny = new State("sunny");
        State hot = new State("hot");
        State wearSunGlasses = new State("wearing sunglasses");

        sunny.setState(1);
        hot.setState(1);
        Relation sunnyAndHot = new Relation(sunny, LogicConnection.AND, hot);


        Premise p1 = new Premise();
        p1.addEvaluatable(sunny);
        p1.addResult(wearSunGlasses);
        p1.evaluate();

        System.out.println("wearSunGlasses: " + wearSunGlasses.getState());


    }


    private static void willWeBeHomeBySunset() {
        //declare states
        State sunny = new State("sunny");
        State colder = new State("colder");
        State swimming = new State("swimming");
        State canoue = new State("canoue");
        State homeBySunset = new State("homeBySunset");


        //set known states
        sunny.setState(0);
        colder.setState(1);

        //1
        Relation notSunnyAndColderRelation = new Relation(sunny, LogicConnection.AND, colder);

        //2
        Premise sunnyPremise = new Premise();
        sunnyPremise.addEvaluatable(swimming);
        sunnyPremise.addResult(sunny);

        sunnyPremise.evaluate();

        //3
        Premise canoePremise = new Premise();
        canoePremise.addEvaluatable(swimming.not());
        canoePremise.addResult(canoue);

        canoePremise.evaluate();

        //4
        Premise homeBySunsetPremise = new Premise();
        homeBySunsetPremise.addEvaluatable(canoue);
        homeBySunsetPremise.addResult(homeBySunset);

        homeBySunsetPremise.evaluate();
        System.out.println("homeBySunset?: " + homeBySunset.getState());
    }

}


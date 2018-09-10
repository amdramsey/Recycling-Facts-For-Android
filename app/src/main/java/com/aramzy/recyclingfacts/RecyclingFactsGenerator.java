package com.aramzy.recyclingfacts;

import java.util.Random;

public class RecyclingFactsGenerator {

    String facts[];

    RecyclingFactsGenerator(String[] facts) {

        this.facts = facts;

    }

    public String generateFact() {

        Random random = new Random();
        int rNum = random.nextInt(facts.length);
        return facts[rNum];

    }

}
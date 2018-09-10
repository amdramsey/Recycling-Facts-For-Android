package com.aramzy.recyclingfacts;

import java.util.Random;

public class RecyclingColorGenerator {

    String colors[];

    RecyclingColorGenerator(String[] colors) {

        this.colors = colors;

    }

    public String generateColor() {

        Random random = new Random();
        int rNum = random.nextInt(colors.length);
        return colors[rNum];

    }

}
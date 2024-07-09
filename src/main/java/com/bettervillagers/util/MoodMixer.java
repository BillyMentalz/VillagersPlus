package com.bettervillagers.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class MoodMixer {
    public enum Stat {
        MOTIVATION,
        DISCONTENT,
        HUNGER,
        ENERGY,
        SOCIAL,
        COMFORT,
        WORK,
    };
    public static List<Integer> GenerateMood() {
        List<Integer> CURRENT_MOOD = new ArrayList<Integer>(20);
        CURRENT_MOOD.set(Stat.MOTIVATION.ordinal(),50);
        CURRENT_MOOD.set(Stat.DISCONTENT.ordinal(),0);
        CURRENT_MOOD.set(Stat.HUNGER.ordinal(),50);
        CURRENT_MOOD.set(Stat.ENERGY.ordinal(), ThreadLocalRandom.current().nextInt(0, 101));
        CURRENT_MOOD.set(Stat.SOCIAL.ordinal(),100);
        CURRENT_MOOD.set(Stat.COMFORT.ordinal(),50);
        CURRENT_MOOD.set(Stat.WORK.ordinal(),50);
        return CURRENT_MOOD;
    };


}

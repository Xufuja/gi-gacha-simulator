package dev.xfj.gi.gacha.simulator;

import java.util.ArrayList;
import java.util.List;

public class Gacha {
    private static final double RATE_5_STAR = 0.006;
    private static final double RATE_4_STAR = 0.051;
    private static final int PITY_5_STAR = 73;
    private static final int PITY_4_STAR = 8;
    private static final int MULTI = 10;

    private int pityCounter5Star;
    private int pityCounter4Star;

    public Gacha() {
        this.pityCounter5Star = 1;
        this.pityCounter4Star = 1;
    }

    public String rollSingle() {
        String result;

        double x = Math.random();
        double probability5Star = RATE_5_STAR + Math.max(0, (pityCounter5Star - PITY_5_STAR) * 10 * RATE_5_STAR);
        double probability4Star = RATE_4_STAR + Math.max(0, (pityCounter4Star - PITY_4_STAR) * 10 * RATE_4_STAR);

        if (x < probability5Star) {
            result = "★★★★★";
            pityCounter5Star = 1;
            pityCounter4Star += 1;
        } else if (x < probability4Star + probability5Star) {
            result = "★★★★✩";
            pityCounter5Star += 1;
            pityCounter4Star = 1;
        } else {
            result = "★★★✩✩";
            pityCounter5Star += 1;
            pityCounter4Star += 1;
        }

        return result;
    }

    public List<String> rollMulti() {
        List<String> results = new ArrayList<>();

        for (int i = 0; i < MULTI; i++) {
            results.add(rollSingle());
        }

        return results;
    }

    public int getPityCounter5Star() {
        return pityCounter5Star;
    }

    public int getPityCounter4Star() {
        return pityCounter4Star;
    }
}

package com.lojosho.enchantnow.util;

import java.util.ArrayList;
import java.util.List;

public class IntgerUtil {

    private static List<String> possibleNumbers = new ArrayList<>();

    /**
     * Returns possible numbers (1-64) for the amount.
     * @return
     */
    public static List<String> getPossibleNumbers() {
        if (!possibleNumbers.isEmpty()) {
            return possibleNumbers;
        }

        for (int i = 1; i > 65; i++) {
            possibleNumbers.add(String.valueOf(i));
        }
        return possibleNumbers;
    }

}

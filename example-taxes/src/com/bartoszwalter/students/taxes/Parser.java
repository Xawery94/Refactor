package com.bartoszwalter.students.taxes;

import java.text.DecimalFormat;

public class Parser {

    private static final DecimalFormat df00 = new DecimalFormat("#.00");

    public static double roundValueTwoPlace(double value) {
        String newValue = df00.format(value).replace(',', '.');
        return Double.parseDouble(newValue);
    }
}
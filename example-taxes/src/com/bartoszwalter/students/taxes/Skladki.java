package com.bartoszwalter.students.taxes;

import java.util.HashMap;

public class Skladki {

    private HashMap<String, Double> skladki;

    public Skladki() {
        this.skladki = new HashMap<>();
    }

    public void setSkladki(String key, Double newValue) {
        this.skladki.put(key, newValue);
    }

    public Double getSkladkiAboutKey(String key) {
        return skladki.get(key);
    }

    public void printAllKeys() {
        for (HashMap.Entry<String, Double> entry : skladki.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(parseKey(key) + " " + value);
        }
    }

    private String parseKey(String key) {
        switch (key) {
            case "emerytalna":
                return "Składka emerytalna: ";
            case "rentowa":
                return "Składka Rentowa: ";
            case "chorobowa":
                return "Składka Chorobowa: ";
            case "podstawaWymiaruSkladekZdrowotnych":
                return "Podstawa Wymiaru Skladek Zdrowotnych: ";
            case "zaliczkaNaUSZaokraglona":
                return "Zaliczka Na US Zaokraglona: ";
            case "kosztyUzyskaniaPrzychodu":
                return "Koszty Uzyskania Przychodu: ";
            case "podstawaOpodatkowania":
                return "Podstawa Opodatkowania: ";
            case "wynagrodzenieNetto":
                return "Wynagrodzenie Netto: ";
            case "zaliczkaNaPod":
                return "ZaliczkaNaPod: ";
            case "podatekPotracony":
                return "Podatek Potracony: ";
            case "zdrowotna9":
                return "Zdrowotna 9%: ";
            case "zdrowotna775":
                return "Zdrowotna 7,75%: ";
            default:
                return "";
        }
    }
}

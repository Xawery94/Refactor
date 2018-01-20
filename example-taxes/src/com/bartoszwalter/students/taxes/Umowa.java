package com.bartoszwalter.students.taxes;

public class Umowa {
    private char typUmowy;
    private double wynagrodzenie;
    protected Skladki skladki = new Skladki();

    private static final double procentSkladkiEmerytalnej_9_76 = 0.0976;
    private static final double procentSkladkiRentowej_1_5 = 0.015;
    private static final double procentSkladkiChorobowej_2_45 = 0.0245;
    private static final double procentZaliczkiNaPodatekDochodowy_18 = 0.18;
    private static final double procentSkladkiZdrowotnej_9 = 0.09;
    private static final double procentSkladkiZdrowotnej_7_75 = 0.0775;

    public char getTypUmowy() {
        return typUmowy;
    }

    public void setTypUmowy(char typUmowy) {
        this.typUmowy = typUmowy;
    }

    public double getWynagrodzenie() {
        return this.wynagrodzenie;
    }

    public void setWynagrodzenie(int wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }

    public double getProcentZaliczkiNaPodatekDochodowy_18() {
        return this.procentZaliczkiNaPodatekDochodowy_18;
    }

    public Skladki getSkladki() {
        return this.skladki;
    }

    public void updateSkladki(String key, Double value) {
        this.skladki.setSkladki(key, Parser.roundValueTwoPlace(value));
    }

    public void obliczonaPodstawa() {
        Double skladkaEmerytalna = wynagrodzenie * procentSkladkiEmerytalnej_9_76;
        Double skladkaRentowa = wynagrodzenie * procentSkladkiRentowej_1_5;
        Double ubezpieczenieChorobowe = wynagrodzenie * procentSkladkiChorobowej_2_45;
        double podstawaWymiaruSkladekZdrowotnych = wynagrodzenie - skladkaEmerytalna - skladkaRentowa - ubezpieczenieChorobowe;

        this.updateSkladki("emerytalna", skladkaEmerytalna);
        this.updateSkladki("rentowa", skladkaRentowa);
        this.updateSkladki("chorobowa", ubezpieczenieChorobowe);
        this.updateSkladki("podstawaWymiaruSkladekZdrowotnych", podstawaWymiaruSkladekZdrowotnych);
    }

    public void obliczUbezpieczenia() {
        Double podstawa = skladki.getSkladkiAboutKey("podstawaWymiaruSkladekZdrowotnych");
        this.updateSkladki("zdrowotna9", podstawa * procentSkladkiZdrowotnej_9);
        this.updateSkladki("zdrowotna775", podstawa * procentSkladkiZdrowotnej_7_75);
    }

    public void obliczWynagrodzenie() {
        double s_emerytalna = skladki.getSkladkiAboutKey("emerytalna");
        double s_rentowa = skladki.getSkladkiAboutKey("rentowa");
        double u_chorobowe = skladki.getSkladkiAboutKey("chorobowa");
        double zdrowotna = skladki.getSkladkiAboutKey("zdrowotna9");
        double zaliczkaNaUS = skladki.getSkladkiAboutKey("zaliczkaNaUSZaokraglona");
        double wynagrodzenieNetto = this.getWynagrodzenie() - ((s_emerytalna + s_rentowa + u_chorobowe) + zdrowotna + zaliczkaNaUS);

        this.updateSkladki("wynagrodzenieNetto", wynagrodzenieNetto);
    }
}

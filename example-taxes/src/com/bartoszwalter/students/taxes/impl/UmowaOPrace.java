package com.bartoszwalter.students.taxes.impl;

import com.bartoszwalter.students.taxes.Parser;
import com.bartoszwalter.students.taxes.Umowa;
import com.bartoszwalter.students.taxes.service.UmowaService;

public class UmowaOPrace extends Umowa implements UmowaService {

    private double kwotaWolnaOdPodatku_46_33 = 46.33;
    private double kosztyUzyskaniaPrzychodu_111_25 = 111.25;

    public UmowaOPrace(int wynagrodznie) {
        this.setTypUmowy('P');
        this.setWynagrodzenie(wynagrodznie);
    }

    @Override
    public void oblicz() {
        skladki.setSkladki("kosztyUzyskaniaPrzychodu", kosztyUzyskaniaPrzychodu_111_25);
        this.obliczonaPodstawa();
        this.obliczUbezpieczenia();
        obliczPodstaweOpodat();
        obliczZaliczke();
        this.obliczWynagrodzenie();
    }

    private void obliczPodstaweOpodat() {
        double podstawa = skladki.getSkladkiAboutKey("podstawaWymiaruSkladekZdrowotnych");
        double podstawaOpodat = podstawa - kosztyUzyskaniaPrzychodu_111_25;
        double zaliczkaNaPod = Parser.roundValueTwoPlace(podstawaOpodat) * this.getProcentZaliczkiNaPodatekDochodowy_18();
        double podatekPotracony = zaliczkaNaPod - kwotaWolnaOdPodatku_46_33;

        this.updateSkladki("podstawaOpodatkowania", podstawaOpodat);
        this.updateSkladki("zaliczkaNaPod", zaliczkaNaPod);
        this.updateSkladki("podatekPotracony", podatekPotracony);
    }

    private void obliczZaliczke() {
        double zaliczkaNaPod0 = skladki.getSkladkiAboutKey("zaliczkaNaPod");
        double zdrowotna775 = skladki.getSkladkiAboutKey("zdrowotna775");
        double zaliczkaUS = zaliczkaNaPod0 - zdrowotna775 - kwotaWolnaOdPodatku_46_33;

        this.updateSkladki("zaliczkaNaUSZaokraglona", zaliczkaUS);
    }

    @Override
    public void printSkladki() {
        skladki.printAllKeys();
    }
}

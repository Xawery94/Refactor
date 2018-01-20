package com.bartoszwalter.students.taxes.impl;

import com.bartoszwalter.students.taxes.Parser;
import com.bartoszwalter.students.taxes.Umowa;
import com.bartoszwalter.students.taxes.service.UmowaService;

public class UmowaZlecenie extends Umowa implements UmowaService {

    public UmowaZlecenie(int wynagrodznie) {
        this.setTypUmowy('Z');
        this.setWynagrodzenie(wynagrodznie);
    }

    @Override
    public void oblicz() {
        this.obliczonaPodstawa();
        this.obliczUbezpieczenia();
        obliczPodstaweOpodat();
        obliczZaliczke();
        this.obliczWynagrodzenie();
    }

    private void obliczPodstaweOpodat() {
        double podstawa = skladki.getSkladkiAboutKey("podstawaWymiaruSkladekZdrowotnych");
        double kosztyUzyskania = (podstawa * 20) / 100;
        double podstawaOpodat = podstawa - kosztyUzyskania;
        double zaliczkaNaPod = Parser.roundValueTwoPlace(podstawaOpodat) * this.getProcentZaliczkiNaPodatekDochodowy_18();

        this.updateSkladki("podstawaOpodatkowania", podstawaOpodat);
        this.updateSkladki("zaliczkaNaPod", zaliczkaNaPod);
        this.updateSkladki("podatekPotracony", zaliczkaNaPod);
    }

    private void obliczZaliczke() {
        double zaliczkaNaPod0 = skladki.getSkladkiAboutKey("zaliczkaNaPod");
        double zdrowotna775 = skladki.getSkladkiAboutKey("zdrowotna775");
        double zaliczkaUS = zaliczkaNaPod0 - zdrowotna775 - 0;

        this.updateSkladki("zaliczkaNaUSZaokraglona", zaliczkaUS);
    }

    @Override
    public void printSkladki() {
        skladki.printAllKeys();
    }
}

package com.bartoszwalter.students.taxes;

import com.bartoszwalter.students.taxes.impl.UmowaOPrace;
import com.bartoszwalter.students.taxes.impl.UmowaZlecenie;
import com.bartoszwalter.students.taxes.service.UmowaService;

public class DaneUmowy {

    private UmowaService umowa;
    private char typ;
    private int wynagrodzenie;

    public DaneUmowy(char typ, int wynagrodzenie) {
        this.typ = Character.toUpperCase(typ);
        this.wynagrodzenie = wynagrodzenie;
        factory();
    }

    private void factory() {
        switch (typ) {
            case 'Z': {
                umowa = new UmowaZlecenie(wynagrodzenie);
                break;
            }
            case 'P': {
                umowa = new UmowaOPrace(wynagrodzenie);
                break;
            }
        }

        umowa.oblicz();
        umowa.printSkladki();
    }
}

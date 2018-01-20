package com.bartoszwalter.students.taxes;

public class Main {

    public static void main(String[] args) {
        System.out.println("UMOWA O ZLECENIE:");
         new DaneUmowy('z', 1000);

        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println("UMOWA O PRACE:");
        new DaneUmowy('p', 1000);
    }
}

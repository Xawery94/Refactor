package testy;

import com.bartoszwalter.students.taxes.impl.UmowaOPrace;
import com.bartoszwalter.students.taxes.impl.UmowaZlecenie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UmowaTest {
    private UmowaOPrace umowaOPrace;
    private UmowaZlecenie umowaZlecenie;

    @Before
    public void setUp() {
        umowaZlecenie = new UmowaZlecenie(1500);
        umowaOPrace = new UmowaOPrace(1000);
    }

    @Test
    public void typeShouldBeP() {
        assertEquals(umowaOPrace.getTypUmowy(), 'P');
    }

    @Test
    public void shouldBeCorrectValues() {
        umowaOPrace.oblicz();
        assertEquals(umowaOPrace.getSkladki().getSkladkiAboutKey("emerytalna"), new Double(97.6));
        assertEquals(umowaOPrace.getSkladki().getSkladkiAboutKey("rentowa"), new Double(15.0));
        assertEquals(umowaOPrace.getSkladki().getSkladkiAboutKey("chorobowa"), new Double(24.5));
        assertEquals(umowaOPrace.getSkladki().getSkladkiAboutKey("podstawaWymiaruSkladekZdrowotnych"), new Double(862.9));
        assertEquals(umowaOPrace.getSkladki().getSkladkiAboutKey("zaliczkaNaUSZaokraglona"), new Double(22.1));
        assertEquals(umowaOPrace.getSkladki().getSkladkiAboutKey("kosztyUzyskaniaPrzychodu"), new Double(111.25));
        assertEquals(umowaOPrace.getSkladki().getSkladkiAboutKey("podstawaOpodatkowania"), new Double(751.65));
        assertEquals(umowaOPrace.getSkladki().getSkladkiAboutKey("wynagrodzenieNetto"), new Double(763.14));
        assertEquals(umowaOPrace.getSkladki().getSkladkiAboutKey("zaliczkaNaPod"), new Double(135.3));
        assertEquals(umowaOPrace.getSkladki().getSkladkiAboutKey("podatekPotracony"), new Double(88.97));
        assertEquals(umowaOPrace.getSkladki().getSkladkiAboutKey("zdrowotna9"), new Double(77.66));
        assertEquals(umowaOPrace.getSkladki().getSkladkiAboutKey("zdrowotna775"), new Double(66.87));
    }

    @Test
    public void shouldReturnCorrectMainValue() {
        UmowaOPrace umowa = new UmowaOPrace(2000);
        umowa.obliczonaPodstawa();
        assertEquals(umowa.getSkladki().getSkladkiAboutKey("emerytalna"), new Double(195.2));
        assertEquals(umowa.getSkladki().getSkladkiAboutKey("rentowa"), new Double(30.0));
        assertEquals(umowa.getSkladki().getSkladkiAboutKey("chorobowa"), new Double(49.0));
        assertEquals(umowa.getSkladki().getSkladkiAboutKey("podstawaWymiaruSkladekZdrowotnych"), new Double(1725.8));
    }

    @Test
    public void shouldBeCorrectValues1() {
        umowaZlecenie.oblicz();
        assertEquals(umowaZlecenie.getSkladki().getSkladkiAboutKey("emerytalna"), new Double(146.4));
        assertEquals(umowaZlecenie.getSkladki().getSkladkiAboutKey("rentowa"), new Double(22.5));
        assertEquals(umowaZlecenie.getSkladki().getSkladkiAboutKey("chorobowa"), new Double(36.75));
        assertEquals(umowaZlecenie.getSkladki().getSkladkiAboutKey("podstawaWymiaruSkladekZdrowotnych"), new Double(1294.35));
        assertEquals(umowaZlecenie.getSkladki().getSkladkiAboutKey("zaliczkaNaUSZaokraglona"), new Double(86.08));
        assertEquals(umowaZlecenie.getSkladki().getSkladkiAboutKey("podstawaOpodatkowania"), new Double(1035.48));
        assertEquals(umowaZlecenie.getSkladki().getSkladkiAboutKey("wynagrodzenieNetto"), new Double(1091.78));
        assertEquals(umowaZlecenie.getSkladki().getSkladkiAboutKey("zaliczkaNaPod"), new Double(186.39));
        assertEquals(umowaZlecenie.getSkladki().getSkladkiAboutKey("podatekPotracony"), new Double(186.39));
        assertEquals(umowaZlecenie.getSkladki().getSkladkiAboutKey("zdrowotna9"), new Double(116.49));
        assertEquals(umowaZlecenie.getSkladki().getSkladkiAboutKey("zdrowotna775"), new Double(100.31));
    }

    @Test
    public void shouldReturnCorrectMainValu1e() {
        UmowaZlecenie umowa = new UmowaZlecenie(2000);
        umowa.obliczonaPodstawa();
        assertEquals(umowa.getSkladki().getSkladkiAboutKey("emerytalna"), new Double(195.2));
        assertEquals(umowa.getSkladki().getSkladkiAboutKey("rentowa"), new Double(30.0));
        assertEquals(umowa.getSkladki().getSkladkiAboutKey("chorobowa"), new Double(49.0));
        assertEquals(umowa.getSkladki().getSkladkiAboutKey("podstawaWymiaruSkladekZdrowotnych"), new Double(1725.8));
    }
}
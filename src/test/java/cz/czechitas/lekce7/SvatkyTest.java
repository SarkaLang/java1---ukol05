package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

    /**
     * Testuje metodu {@link Svatky#vratKdyMaSvatek(String)}
     */
    @Test
    void kdyMaSvatek() {
        Svatky svatky = new Svatky();
        assertEquals(MonthDay.of(5, 18), svatky.vratKdyMaSvatek("Nataša"));
        assertNull(svatky.vratKdyMaSvatek("Eva"));
    }

    /**
     * Testuje metodu {@link Svatky#jeVSeznamu(String)}
     */
    @Test
    void jeVSeznamu() {
        Svatky svatky = new Svatky();
        assertTrue(svatky.jeVSeznamu("Vanesa"));
        assertFalse(svatky.jeVSeznamu("Max"));
    }

    /**
     * Testuje metodu {@link Svatky#getPocetJmen()}
     */
    @Test
    void getPocetJmen() {
        Svatky svatky = new Svatky();
        int pocetJmen = svatky.getPocetJmen();
        assertEquals(37, pocetJmen);

    }

    /**
     * Testuje metodu {@link Svatky#getSeznamJmen()}
     */
    @Test
    void getSeznamJmen() {
        Svatky svatky = new Svatky();
        Set<String> seznamJmen = svatky.getSeznamJmen();

        assertEquals(37, seznamJmen.size());
        assertTrue(seznamJmen.contains("Vanesa"));
        assertTrue(seznamJmen.contains("Alex"));
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, int)}
     */
    @Test
    void pridejSvatekDenMesicInt() {
        Svatky svatky = new Svatky();
        String jmeno = "Radoslav";
        int den = 6;
        int mesic = 5;

        svatky.pridejSvatek(jmeno, den, mesic);

        assertTrue(svatky.jeVSeznamu(jmeno));
        assertEquals(MonthDay.of(mesic, den), svatky.vratKdyMaSvatek(jmeno));
    }


    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, Month)}
     */
    @Test
    void pridatSvatekDenMesicMonth() {
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
        String jmeno = "Žofinka";
        int den = 15;
        Month mesic = Month.MAY;

        svatky.pridejSvatek(jmeno, den, mesic);

        assertTrue(svatky.jeVSeznamu(jmeno));
        assertEquals(MonthDay.of(mesic, den), svatky.vratKdyMaSvatek(jmeno));

    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, MonthDay)}
     */
    @Test
    void prridatSvatekMonthDay() {
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
        String jmeno = "Vlastík";
        MonthDay denMesic = MonthDay.of(5, 17);

        svatky.pridejSvatek(jmeno, denMesic);

        assertTrue(svatky.jeVSeznamu(jmeno));
        assertEquals(denMesic, svatky.vratKdyMaSvatek(jmeno));
    }

    /**
     * Testuje metodu {@link Svatky#smazSvatek(String)}
     */
    @Test
    void smazatSvatek() {
        //TODO Zkontrolovat, že po smazání bude počet svátků odpovídat novému počtu.
        Svatky svatky = new Svatky();
        int pocetPredSmazanim = svatky.getPocetJmen();
        String jmenoKSmazani = "Zikmund";

        // Act
        svatky.smazSvatek(jmenoKSmazani);
        int pocetPoSmazani = svatky.getPocetJmen();

        // Assert
        assertEquals(pocetPredSmazanim - 1, pocetPoSmazani);
        assertFalse(svatky.jeVSeznamu(jmenoKSmazani));
    }
}

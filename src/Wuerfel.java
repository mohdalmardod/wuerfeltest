import java.util.Random;

/**
 * Wuerfelklasse
 */
public class Wuerfel {

    /**
     * Anzahl der Augenzahlen
     */
    public int maxAugenzahl;

    /**
     * Wuerfelkonstruktor
     *
     * @param maxAugenzahl Maximale Wuerfelzahl
     */
    public Wuerfel(int maxAugenzahl) {

        this.maxAugenzahl = maxAugenzahl;
    }

    /**
     * ich füge mein UML dieser Methode hinzu
     *
     * @return maxAugenzahl
     */
    public int getMaxAugenzahl() {
        return maxAugenzahl;
    }

    /**
     * Wuerfel wuerfeln
     *
     * @return zufall.nextInt(maxAugenzahl)+1
     */
    public int wuerfeln() {

        Random zufall = new Random();
        return zufall.nextInt(maxAugenzahl) + 1;
    }
}
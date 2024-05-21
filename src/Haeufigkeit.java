import java.util.HashMap;
import java.util.Map;

/**
 * Haeufigkeit Klasse
 * Das Experiment untersucht die Wahrscheinlichkeiten von einer Münze und einer Würfel und vergleicht anschließend die
 * Wahrscheinlichkeiten, welche Augenzahl vorkommt anhand von vielen Anzahl von Versuchen
 */
public class Haeufigkeit {

    /**
     * n ist die Anzahl der Versuche
     */
    private int n;
    /**
     * Eine Tabelle, die die absolute Haeufigkeit speichert
     */
    private Map<Integer, Integer> absoluteHaeufigkeit;
    /**
     * Eine Tabelle, die die relative Haeufigkeit speichert
     */
    private Map<Integer, Double> relativeHaeufigkeit;
    /**
     * Eine Tabelle, die den absoluten Fehler speichert
     */
    private Map<Integer, Double> absoluteFehler;
    /**
     * Eine Tabelle, die den relativen Fehler speichert
     */
    private Map<Integer, Double> relativeFehler;
    /**
     * Eine Instanz aus der Klasse Wuerfel
     */
    private Wuerfel wuerfel;

    /**
     * Haeufigkeitkonstruktor
     * @param n Maximale Wuerfelzahl
     */
    public Haeufigkeit(int n, Wuerfel wuerfel) {

        this.n = n;
        this.wuerfel = wuerfel;

    }

    /**
     *
     * @return n
     */
    public int getN() {
        return n;
    }

    /**
     *
     * @return absoluteHaeufigkeit
     */
    public Map<Integer, Integer> getAbsoluteHaeufigkeit() {
        return absoluteHaeufigkeit;
    }

    /**
     *
     * @return relativeHaeufigkeit
     */
    public Map<Integer, Double> getRelativeHaeufigkeit() {
        return relativeHaeufigkeit;
    }

    /**
     *
     * @return absoluteFehler
     */
    public Map<Integer, Double> getAbsoluteFehler() {
        return absoluteFehler;
    }

    /**
     *
     * @return relativeFehler
     */
    public Map<Integer, Double> getRelativeFehler() {
        return relativeFehler;
    }

    /**
     * erstellt eine Tabelle und fügt dieser die Augenzahlen und ihre zugehörige absolute Häufigkeit hin zu
     */
    public void absoluteHaeufigkeit() {

      absoluteHaeufigkeit = new HashMap<>();
      //Initialfall
      for (int i = 1; i <= wuerfel.getMaxAugenzahl(); i++) {
          absoluteHaeufigkeit.put(i, 0);

      }
      for (int i = 0; i < n; i++) {

          int result = wuerfel.wuerfeln();
          absoluteHaeufigkeit.put(result, absoluteHaeufigkeit.get(result) + 1);
      }
    }

    /**
     * erstellt eine Tabelle und fügt dieser die Augenzahlen und ihre zugehörige relative Häufigkeit hin zu
     */
    public void relativeHaeufigkeit() {

        relativeHaeufigkeit = new HashMap<>();

        for (int i = 1; i <= wuerfel.getMaxAugenzahl(); i++) {
            relativeHaeufigkeit.put(i, (double) absoluteHaeufigkeit.get(i) / n);
        }


    }

    /**
     * erstellt eine Tabelle und fügt dieser die Augenzahlen und ihren zugehörigen absoluten Fehler hin zu
     */
    public void absoluteFehler() {

        absoluteFehler = new HashMap<>();

        double berechneteWahrscheinlichkeit = (double) 1/wuerfel.getMaxAugenzahl();

        for (int i = 1; i <= wuerfel.getMaxAugenzahl(); i++) {
            absoluteFehler.put(i, relativeHaeufigkeit.get(i) - berechneteWahrscheinlichkeit);
        }

    }

    /**
     * erstellt eine Tabelle und fügt dieser die Augenzahlen und ihren zugehörigen absoluten Fehler hin zu
     */
    public void relativeFehler() {

        relativeFehler = new HashMap<>();

        double berechneteWahrscheinlichkeit = (double) 1/wuerfel.getMaxAugenzahl();

        for (int i = 1; i <= wuerfel.getMaxAugenzahl(); i++) {
            relativeFehler.put(i, absoluteFehler.get(i) / berechneteWahrscheinlichkeit);
        }
    }
}

import java.util.Map;
import java.util.Scanner;
import de.oop2024.util.UserInterface;

/**
 * Mainklasse
 * Die Main-Klasse enthält die Hauptmethode des Programms, das die Häufigkeit von Augenzahlen beim Würfeln mit einem Würfel berechnet
 * und verschiedene statistische Metriken wie absolute und relative Häufigkeit sowie absolute und relative Fehler ausgibt.
 */
public class Main {

    /**
     * Mainmethode
     * @param args Mainargumente
     */
    public static void main(String[] args) {


        int n = UserInterface.in.requestInt("Bitte Anzahl der Wuerfe angeben:" , 1);
        int maxAugenzahl = 2;

        Haeufigkeit haeufigkeit = new Haeufigkeit(n, new Wuerfel(maxAugenzahl));
        haeufigkeit.absoluteHaeufigkeit();
        haeufigkeit.relativeHaeufigkeit();
        haeufigkeit.absoluteFehler();
        haeufigkeit.relativeFehler();

        for (Map.Entry<Integer, Double> value : haeufigkeit.getRelativeHaeufigkeit().entrySet()) {

            System.out.println("Augenzahl: " + value.getKey() + ", Relative Häufigkeit: " + value.getValue()+ " Mathematisch berechnet wäre: "+(float) 1/maxAugenzahl);
        }
        System.out.println();
        for (Map.Entry<Integer, Double> value : haeufigkeit.getAbsoluteFehler().entrySet()) {

            System.out.println("Augenzahl: " + value.getKey() + ", absoluter Fehler: " + value.getValue());

        }
        System.out.println();
        for (Map.Entry<Integer, Double> value : haeufigkeit.getRelativeFehler().entrySet()) {

            System.out.println("Augenzahl: " + value.getKey() + ", relativer Fehler: " + Math.abs(value.getValue()));

        }
    }
}

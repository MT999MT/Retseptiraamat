/**
 * Klass Koostisosa esindab üht koostisosa – sellel on nimi, kogus ja mõõtühik.

 */

public class Koostisosa {

    // Koostisosa nimi
    private String nimi;

    // Kogus arvuliselt
    private int kogus;

    // Mõõtühik
    private String yksus;

    /**
     Konstruktor – loob uue koostisosa.
     nimi   koostisosa nimi
     kogus  kogus arvuliselt
     yksus  mõõtühik
     */
    public Koostisosa(String nimi, int kogus, String yksus) {
        this.nimi = nimi;
        this.kogus = kogus;
        this.yksus = yksus;
    }

    // Get-meetodid

    public String getNimi() {
        return nimi;
    }

    public int getKogus() {
        return kogus;
    }

    public String getYksus() {
        return yksus;
    }

    // Set-meetodid

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setKogus(int kogus) {
        this.kogus = kogus;
    }

    public void setYksus(String yksus) {
        this.yksus = yksus;
    }

    public String toString() {
        return kogus + " " + yksus + " " + nimi;
    }
}
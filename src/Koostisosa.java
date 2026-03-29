/**
 * Klass Koostisosa esindab üht koostisosa – sellel on nimi ja kogus.
 * Kasutatakse nii retseptides kui ka külmkapis olevate asjade kirjeldamiseks.
 */
public class Koostisosa {

    // Koostisosa nimi, nt "makaronid", "munad"
    private String nimi;

    // Kogus ühikutes (nt gramm, tk, dl) – lihtsustuse mõttes kasutame täisarvu
    private int kogus;

    // Mõõtühik, nt "g", "tk", "dl", "spl"
    private String yksus;

    /**
     * Konstruktor – loob uue koostisosa antud nime, koguse ja ühikuga.
     *
     * @param nimi   koostisosa nimi
     * @param kogus  kogus arvuliselt
     * @param yksus  mõõtühik
     */
    public Koostisosa(String nimi, int kogus, String yksus) {
        this.nimi = nimi;
        this.kogus = kogus;
        this.yksus = yksus;
    }

    // --- Getterid ---

    /** Tagastab koostisosa nime. */
    public String getNimi() {
        return nimi;
    }

    /** Tagastab koostisosa koguse. */
    public int getKogus() {
        return kogus;
    }

    /** Tagastab mõõtühiku. */
    public String getYksus() {
        return yksus;
    }

    // --- Setterid ---

    /** Määrab koostisosa nime. */
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    /** Määrab koguse. */
    public void setKogus(int kogus) {
        this.kogus = kogus;
    }

    /** Määrab mõõtühiku. */
    public void setYksus(String yksus) {
        this.yksus = yksus;
    }

    /**
     * Tekstiline esitus, nt "200 g makaronid".
     */
    @Override
    public String toString() {
        return kogus + " " + yksus + " " + nimi;
    }
}
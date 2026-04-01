import java.util.ArrayList;

/**
 * Klass Kylmkapp hoiab koostisosade nimesid.
 */

public class Kylmkapp {

    // ArrayList hoiab koostisosade nimesid – mahub nii palju kui vaja
    private ArrayList<String> sisu;

    /**
     * Konstruktor – loob tühja külmkapi.
     */
    public Kylmkapp() {
        sisu = new ArrayList<String>();
    }

    /**
     * Lisab ühe koostisosa külmkappi.
     * Kui nimi on tühi või ruum on täis, ei lisata midagi.
     *
     * nimi koostisosa nimi
     */
    public void lisaKoostisosa(String nimi) {
        if (nimi == null) {
            return;
        }
        if (nimi.trim().isEmpty()) {
            return;
        }
        sisu.add(nimi.trim());
    }

    /**
     * Lisab mitu koostisosa korraga.
     * Kasutaja sisestab komadega eraldatud teksti, nt "munad, piim, juust".
     *
     * sisestus kasutaja sisestatud tekst
     */
    public void lisaKomadegaEraldatud(String sisestus) {
        if (sisestus == null) {
            return;
        }
        if (sisestus.trim().isEmpty()) {
            return;
        }

        // Lõika tekst komade pealt osadeks
        String[] osad = sisestus.split(",");

        // Lisa iga osa eraldi
        for (int i = 0; i < osad.length; i++) {
            lisaKoostisosa(osad[i].trim());
        }
    }


    // Tagastab külmkapi sisu massiivina.

    public ArrayList<String> getSisu() {
        return sisu;
    }


    // Tagastab koostisosade arvu.

    public int getArvutSisus() {
        return sisu.size();
    }


    // Kontrollib kas külmkapp on hetkel tühi
    public boolean onPeaaeguTyhi() {
        return sisu.size() < 3;
    }


    // Kuvab külmkapi sisu tekstina
    public String toString() {
        if (sisu.isEmpty()) {
            return "Külmkapp on tühi!";
        }

        String tekst = "Külmkapis on:\n";
        for (int i = 0; i < sisu.size(); i++) {
            tekst = tekst + "  • " + sisu.get(i) + "\n";
        }
        return tekst;
    }
}
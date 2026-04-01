import java.util.ArrayList;

/**
 * Klass Retsept sisaldab retsepti nime, valmistusaega ja vajalikke koostisosade nimesid.
 */
public class Retsept {

    // Retsepti nimi
    private String nimi;

    // Valmistusaeg minutites
    private int valmistusaeg;

    // Koostisosade nimed ArrayList-is – mahub nii palju kui vaja
    private ArrayList<String> koostisosad;

    /**
     * Konstruktor – loob uue retsepti.
     *
     * nimi         retsepti nimi
     * valmistusaeg valmistusaeg minutites
     */
    public Retsept(String nimi, int valmistusaeg) {
        this.nimi = nimi;
        this.valmistusaeg = valmistusaeg;
        this.koostisosad = new ArrayList<String>();
    }

    /**
     * Lisab retseptile ühe koostisosa nime järgi.

     * koostisosanimi koostisosa nimi
     */
    public void lisaKoostisosa(String koostisosanimi) {
        koostisosad.add(koostisosanimi);
    }

    /**
     * Kontrollib, millised koostisosad on puudu.
     * Tagastab puuduvate koostisosade nimed massiivis.

     * olemasolevad külmkapis olevate asjade nimed
     * tagastab puuduvate koostisosade nimed
     */
    public ArrayList<String> puuduvadKoostisosad(ArrayList<String> olemasolevad) {
        ArrayList<String> puuduvad = new ArrayList<String>();

        // Vaata iga retsepti koostisosa
        for (int i = 0; i < koostisosad.size(); i++) {
            String otsitav = koostisosad.get(i);
            boolean leitud = false;

            // Otsi, kas see on külmkapis olemas
            for (int j = 0; j < olemasolevad.size(); j++) {
                if (olemasolevad.get(j).equalsIgnoreCase(otsitav)) {
                    leitud = true;
                    break;
                }
            }

            // Kui ei leitud, lisa puuduvate nimekirja
            if (!leitud) {
                puuduvad.add(otsitav);
            }
        }

        return puuduvad;
    }

    /**
     * Kontrollib, kas kõik koostisosad on olemas.

     * olemasolevad külmkapis olevad asjad
     * true kui kõik on olemas
     */
    public boolean onTaielikultKaetud(ArrayList<String> olemasolevad) {
        return puuduvadKoostisosad(olemasolevad).isEmpty();
    }

    /**
     * Tagastab puuduvate koostisosade arvu.

     * olemasolevad koostisosad külmkapis
     * puuduvate koostisosade arv
     */
    public int puuduvateArv(ArrayList<String> olemasolevad) {
        return puuduvadKoostisosad(olemasolevad).size();
    }

    // Get-meetodid

    public String getNimi() {
        return nimi;
    }

    public int getValmistusaeg() {
        return valmistusaeg;
    }

    public String toString() {
        String tekst = "Retsept: " + nimi + " (" + valmistusaeg + " min)\n";
        tekst = tekst + "Koostisosad:\n";
        for (int i = 0; i < koostisosad.size(); i++) {
            tekst = tekst + "  - " + koostisosad.get(i) + "\n";
        }
        return tekst;
    }
}
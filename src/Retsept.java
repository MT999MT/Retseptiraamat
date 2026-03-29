import java.util.ArrayList;
import java.util.List;

/**
 * Klass Retsept sisaldab retsepti nime, vajalikke koostisosi ja valmistusaega.
 * Pakub meetodi, mis kontrollib, millised koostisosad on puudu.
 */
public class Retsept {

    // Retsepti nimi, nt "Makaronid ketšupiga"
    private String nimi;

    // Retseptis vajalikud koostisosad
    private List<Koostisosa> koostisosad;

    // Ligikaudne valmistusaeg minutites
    private int valmistusaeg;

    /**
     * Konstruktor – loob uue retsepti.
     *
     * @param nimi          retsepti nimi
     * @param valmistusaeg  valmistusaeg minutites
     */
    public Retsept(String nimi, int valmistusaeg) {
        this.nimi = nimi;
        this.valmistusaeg = valmistusaeg;
        this.koostisosad = new ArrayList<>();
    }

    /**
     * Lisab retseptile ühe koostisosa.
     *
     * @param k koostisosa, mis lisatakse
     */
    public void lisaKoostisosa(Koostisosa k) {
        koostisosad.add(k);
    }

    /**
     * Kontrollib, millised retsepti koostisosad on külmkapist puudu.
     * Võrdlus käib nime järgi (väiketähtedega).
     *
     * @param olemasolevad külmkapis olevate asjade nimekiri
     * @return list puuduvatest koostisosadest
     */
    public List<Koostisosa> puuduvadKoostisosad(List<String> olemasolevad) {
        List<Koostisosa> puuduvad = new ArrayList<>();

        for (Koostisosa k : koostisosad) {
            boolean leitud = false;
            for (String olemas : olemasolevad) {
                // Võrdlus on tõstutundetu
                if (olemas.trim().equalsIgnoreCase(k.getNimi())) {
                    leitud = true;
                    break;
                }
            }
            if (!leitud) {
                puuduvad.add(k);
            }
        }

        return puuduvad;
    }

    /**
     * Kontrollib, kas retsept on täielikult valmistamiseks kaetud.
     *
     * @param olemasolevad külmkapis olevad asjad
     * @return true kui kõik koostisosad on olemas
     */
    public boolean onTaielikultKaetud(List<String> olemasolevad) {
        return puuduvadKoostisosad(olemasolevad).isEmpty();
    }

    // --- Getterid ---

    /** Tagastab retsepti nime. */
    public String getNimi() {
        return nimi;
    }

    /** Tagastab koostisosade listi. */
    public List<Koostisosa> getKoostisosad() {
        return koostisosad;
    }

    /** Tagastab valmistusaja minutites. */
    public int getValmistusaeg() {
        return valmistusaeg;
    }

    // --- Setterid ---

    /** Määrab retsepti nime. */
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    /** Määrab valmistusaja. */
    public void setValmistusaeg(int valmistusaeg) {
        this.valmistusaeg = valmistusaeg;
    }

    /**
     * Tekstiline ülevaade retseptist koos koostisosadega.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Retsept: ").append(nimi).append(" (").append(valmistusaeg).append(" min)\n");
        sb.append("Koostisosad:\n");
        for (Koostisosa k : koostisosad) {
            sb.append("  - ").append(k).append("\n");
        }
        return sb.toString();
    }
}
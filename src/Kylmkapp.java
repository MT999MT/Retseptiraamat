import java.util.ArrayList;
import java.util.List;

/**
 * Klass Külmkapp hoiab hetkel olemasolevate koostisosade nimesid.
 * Kasutaja sisestab, mis tal kodus on, ning programm salvestab need siia.
 */
public class Kylmkapp {

    // Külmkapis olevate koostisosade nimed (lihtsustuse mõttes ainult nimed)
    private List<String> sisu;

    /**
     * Konstruktor – loob tühja külmkapi.
     */
    public Kylmkapp() {
        this.sisu = new ArrayList<>();
    }

    /**
     * Lisab külmkappi ühe koostisosa nime.
     *
     * @param nimi koostisosa nimi
     */
    public void lisaKoostisosa(String nimi) {
        if (nimi != null && !nimi.trim().isEmpty()) {
            sisu.add(nimi.trim());
        }
    }

    /**
     * Lisab korraga mitu koostisosa (eraldatud komaga).
     * Näiteks: "munad, makaronid, juust"
     *
     * @param sisestus kasutaja sisestatud tekst
     */
    public void lisaKomadegaEraldatud(String sisestus) {
        if (sisestus == null || sisestus.trim().isEmpty()) return;

        String[] osad = sisestus.split(",");
        for (String osa : osad) {
            lisaKoostisosa(osa.trim());
        }
    }

    /**
     * Tagastab külmkapi sisu listi.
     *
     * @return koostisosade nimede list
     */
    public List<String> getSisu() {
        return sisu;
    }

    /**
     * Tagastab külmkapis olevate asjade arvu.
     *
     * @return koostisosade arv
     */
    public int getSuuracknowledged() {
        return sisu.size();
    }

    /**
     * Tagastab, mitu erinevat koostisosa külmkapis on.
     */
    public int getArvutSisus() {
        return sisu.size();
    }

    /**
     * Kontrollib, kas külmkapp on peaaegu tühi (vähem kui 3 koostisosa).
     *
     * @return true kui vähe asju on
     */
    public boolean onPeaaeguTyhi() {
        return sisu.size() < 3;
    }

    /**
     * Kuvab külmkapi sisu tekstina.
     */
    @Override
    public String toString() {
        if (sisu.isEmpty()) {
            return "Külmkapp on tühi!";
        }
        StringBuilder sb = new StringBuilder("Külmkapis on:\n");
        for (String asi : sisu) {
            sb.append("  • ").append(asi).append("\n");
        }
        return sb.toString();
    }
}
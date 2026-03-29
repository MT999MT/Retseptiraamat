import java.util.List;
import java.util.Scanner;

/**
 * ======================================================
 *   NUTIKAS RETSEPTIRAAMAT JA OSTUNIMEKIRI
 * ======================================================
 * Peaklass, mis juhib programmi töö konsooli kaudu.
 *
 * Kasutaja sisestab, mis koostisosad tal kodus on.
 * Programm otsib sobivaid retsepte ja koostab ostunimekirja.
 * Kui kapis on vähe asju, pakutakse juhuslik "vaese tudengi" retsept.
 *
 * Kasutab klasse: Koostisosa, Retsept, Kylmkapp, RetseptiRaamat
 * Kasutajaliides: Scanner (konsooli sisend/väljund)
 *
 * @author Sinu nimi
 * @version 2.0
 */
public class Peaklass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // -------------------------------------------------------
        // 1. TERVITUSSÕNUM – tutvustab programmi
        // -------------------------------------------------------
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║    NUTIKAS RETSEPTIRAAMAT JA OSTUNIMEKIRI    ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("Tere tulemast! See programm aitab Sul otsustada,");
        System.out.println("mida täna süüa teha.");
        System.out.println();
        System.out.println("Kuidas see töötab?");
        System.out.println("  1) Sisesta koostisosad, mis sul kodus on");
        System.out.println("  2) Programm otsib sobivaid retsepte");
        System.out.println("  3) Kui midagi puudub, koostab programm ostunimekirja");
        System.out.println();
        System.out.println("Koostisosad sisesta komadega eraldatult,");
        System.out.println("naiteks:  munad, makaronid, piim, juust");
        System.out.println();

        // -------------------------------------------------------
        // 2. LOO PEAMISED OBJEKTID
        // -------------------------------------------------------
        Kylmkapp kylmkapp = new Kylmkapp();
        RetseptiRaamat raamat = new RetseptiRaamat();

        // -------------------------------------------------------
        // 3. KÜSI KASUTAJALT KOOSTISOSAD
        // -------------------------------------------------------
        System.out.print("Mis koostisosad sul praegu kodus on? ");
        String sisestus = scanner.nextLine();

        // Kui kasutaja ei sisesta midagi
        if (sisestus == null || sisestus.trim().isEmpty()) {
            System.out.println();
            System.out.println("Sa ei sisestanud ühtegi koostisosa. Programm lõpetab töö.");
            System.out.println("Head isu igal juhul!");
            scanner.close();
            return;
        }

        // Lisa sisestatud koostisosad külmkappi
        kylmkapp.lisaKomadegaEraldatud(sisestus);

        // -------------------------------------------------------
        // 4. KUVA KÜLMKAPI SISU KINNITUSEKS
        // -------------------------------------------------------
        System.out.println();
        System.out.println("Kirjutasin üles järgmised koostisosad:");
        System.out.println(kylmkapp);
        System.out.println("Kokku " + kylmkapp.getArvutSisus() + " koostisosa.");
        System.out.println();

        // -------------------------------------------------------
        // 5. KUI KAPIS ON VÄHE ASJU – PAKU TUDENGI RETSEPT
        // -------------------------------------------------------
        if (kylmkapp.onPeaaeguTyhi()) {
            System.out.println("Naib, et kapis on üsna vähe asju...");
            System.out.println("Aga ara muretse! Siin on tanane \"vaese tudengi\" retsept:");
            System.out.println();
            System.out.println("  >> " + raamat.juhuslikTudengiretsept() + " <<");
            System.out.println();
            System.out.println("Vaatan siiski ka üle, kas leidub midagi paremat!");
            System.out.println();
        }

        // -------------------------------------------------------
        // 6. OTSI TÄIELIKULT SOBIVAD RETSEPTID
        // -------------------------------------------------------
        List<Retsept> sobivad = raamat.sobivadRetseptid(kylmkapp.getSisu());

        System.out.println("══════════════════════════════════════════════");
        if (!sobivad.isEmpty()) {
            System.out.println("SAAD KOHE VALMISTADA:");
            System.out.println();
            for (int i = 0; i < sobivad.size(); i++) {
                Retsept r = sobivad.get(i);
                System.out.println("  " + (i + 1) + ". " + r.getNimi()
                        + " (valmistusaeg: " + r.getValmistusaeg() + " min)");
            }
            System.out.println();
            System.out.println("Kõik koostisosad on olemas – võid kohe alustada!");
        } else {
            System.out.println("Kahjuks pole ühtegi retsepti, mida saaksid");
            System.out.println("praegu täielikult valmistada.");
        }

        // -------------------------------------------------------
        // 7. OTSI PEAAEGU SOBIVAD RETSEPTID JA KOOSTA OSTUNIMEKIRI
        // -------------------------------------------------------
        List<Retsept> peaaeguSobivad = raamat.peaaeguSobivadRetseptid(kylmkapp.getSisu());

        if (!peaaeguSobivad.isEmpty()) {
            System.out.println();
            System.out.println("══════════════════════════════════════════════");
            System.out.println("OSTUNIMEKIRI");
            System.out.println("Allpool on retseptid, mille jaoks puudub 1-2 koostisosa.");
            System.out.println("Vaike poeminek lahendab probleemi!");
            System.out.println();

            for (Retsept r : peaaeguSobivad) {
                List<Koostisosa> puuduvad = r.puuduvadKoostisosad(kylmkapp.getSisu());
                System.out.println("  " + r.getNimi()
                        + " (" + r.getValmistusaeg() + " min)");
                System.out.println("  Poest:");
                for (Koostisosa k : puuduvad) {
                    System.out.println("    -> " + k);
                }
                System.out.println();
            }
        }

        // -------------------------------------------------------
        // 8. KUI ÜLDSE MIDAGI EI LEITUD
        // -------------------------------------------------------
        if (sobivad.isEmpty() && peaaeguSobivad.isEmpty()) {
            System.out.println();
            System.out.println("══════════════════════════════════════════════");
            System.out.println("Naib, et tanane seis on keeruline...");
            System.out.println();
            System.out.println("Soovitan viimase võimalusena:");
            System.out.println("  >> " + raamat.juhuslikTudengiretsept() + " <<");
            System.out.println();
            System.out.println("...või mine poodi!");
            System.out.println();
            System.out.println("Meie retseptiraamatus on olemas retseptid:");
            for (Retsept r : raamat.getRetseptid()) {
                System.out.println("  - " + r.getNimi());
            }
            System.out.println();
            System.out.println("Proovi mone neist koostisosad järgmine kord sisestada!");
        }

        // -------------------------------------------------------
        // 9. KÜSI, KAS KASUTAJA TAHAB LISADA OMA RETSEPTI
        // -------------------------------------------------------
        System.out.println();
        System.out.println("══════════════════════════════════════════════");
        System.out.print("Kas soovid lisada oma retsepti retseptiraamatusse? (jah/ei): ");
        String vastus = scanner.nextLine().trim().toLowerCase();

        if (vastus.equals("jah") || vastus.equals("j")) {
            lisaKasutajaRetsept(scanner, raamat, kylmkapp);
        }

        // -------------------------------------------------------
        // 10. LÕPUSÕNUM
        // -------------------------------------------------------
        System.out.println();
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║   Aitah kasutamast! Head isu!                ║");
        System.out.println("╚══════════════════════════════════════════════╝");

        scanner.close();
    }

    /**
     * Abimeetod kasutaja enda retsepti lisamiseks konsooli kaudu.
     *
     * @param scanner   Scanner sisendi lugemiseks
     * @param raamat    retseptiraamat, kuhu lisatakse
     * @param kylmkapp  kasutaja külmkapp võrdlemiseks
     */
    private static void lisaKasutajaRetsept(Scanner scanner, RetseptiRaamat raamat, Kylmkapp kylmkapp) {
        System.out.println();

        // Küsi retsepti nimi
        System.out.print("Retsepti nimi: ");
        String nimi = scanner.nextLine().trim();
        if (nimi.isEmpty()) {
            System.out.println("Nimi puudub – retsepti lisamist tühistati.");
            return;
        }

        // Küsi valmistusaeg
        System.out.print("Valmistusaeg minutites: ");
        int aeg = 30; // vaikeväärtus
        try {
            aeg = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Ei suutnud aega lugeda – kasutan vaikeväärtust 30 minutit.");
        }

        // Küsi koostisosad
        System.out.print("Koostisosad (komadega eraldatult): ");
        String koostisosadSisestus = scanner.nextLine().trim();
        if (koostisosadSisestus.isEmpty()) {
            System.out.println("Koostisosad puuduvad – retsepti ei lisatud.");
            return;
        }

        // Loo uus retsept ja lisa koostisosad
        Retsept uusRetsept = new Retsept(nimi, aeg);
        for (String osa : koostisosadSisestus.split(",")) {
            String koostisosanimi = osa.trim();
            if (!koostisosanimi.isEmpty()) {
                uusRetsept.lisaKoostisosa(new Koostisosa(koostisosanimi, 1, "tk"));
            }
        }

        raamat.lisaRetsept(uusRetsept);
        System.out.println();
        System.out.println("Retsept \"" + nimi + "\" lisati!");

        // Kontrolli kohe, kas uus retsept sobib
        List<Koostisosa> puuduvad = uusRetsept.puuduvadKoostisosad(kylmkapp.getSisu());
        if (puuduvad.isEmpty()) {
            System.out.println("Sul on KÕIK koostisosad olemas – saad kohe valmistada!");
        } else {
            System.out.println("Selle retsepti jaoks pead ostma:");
            for (Koostisosa k : puuduvad) {
                System.out.println("  -> " + k.getNimi());
            }
        }
    }
}
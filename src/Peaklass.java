import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

/**
 ======================================================
 RETSEPTIRAAMAT JA OSTUNIMEKIRJA KOOSTAJA
 ======================================================

 Kasutaja sisestab koostisosad, mis tal kodus on.
 Programm otsib sobivaid retsepte ja koostab ostunimekirja.

 Tobias Välja, Rasmus Vider, Mihkel Tomson

 */

public class Peaklass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║    NUTIKAS RETSEPTIRAAMAT JA OSTUNIMEKIRI    ║");
        System.out.println("╚══════════════════════════════════════════════╝");

        // PEAMISED OBJEKTID
        Kylmkapp kylmkapp = new Kylmkapp();
        RetseptiRaamat raamat = new RetseptiRaamat();

        boolean kaib = true;

        while (kaib) {
            System.out.println();
            System.out.println("══════════════════════════════");
            System.out.println("        PEAMENÜÜ");
            System.out.println("══════════════════════════════");
            System.out.println("1 - Sisesta koostisosad ja otsi retsepte");
            System.out.println("2 - Vaata külmkappi");
            System.out.println("3 - Lisa oma retsept");
            System.out.println("4 - Vali suvaline retsept");
            System.out.println("0 - Välju");
            System.out.print("Vali tegevus: ");

            String valik = scanner.nextLine();

            switch (valik) {

                case "1":
                    // KÜSIME KASUTAJALT KOOSTISOSAD
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

                    System.out.print("Millised koostisosad sul praegu kodus on? ");
                    String sisestus = scanner.nextLine();

                    // Kui kasutaja ei sisestanud midagi
                    if (sisestus == null || sisestus.trim().isEmpty()) {
                        System.out.println();
                        System.out.println("Sa ei sisestanud ühtegi koostisosa.");
                        break;
                    }

                    // (valikuline reset – kommenteeri välja kui ei taha)
                    kylmkapp.getSisu().clear();

                    // Lisa sisestatud koostisosad külmkappi
                    kylmkapp.lisaKomadegaEraldatud(sisestus);

                    // KUVA KÜLMKAPI SISU KINNITUSEKS
                    System.out.println();
                    System.out.println("Kirjutasin üles järgmised koostisosad:");
                    System.out.println(kylmkapp);
                    System.out.println("Kokku " + kylmkapp.getArvutSisus() + " koostisosa.");
                    System.out.println();

                    // KUI KAPIS ON VÄHE ASJU – PAKU TUDENGI RETSEPT
                    if (kylmkapp.onPeaaeguTyhi()) {
                        System.out.println("Näib, et kapis on üsna vähe asju...");
                        System.out.println("Aga ära muretse! Siin on tänane \"vaese tudengi\" retsept:");
                        System.out.println();
                        System.out.println("  >> " + raamat.juhuslikTudengiretsept() + " <<");
                        System.out.println();
                        System.out.println("Vaatan siiski ka üle, kas leidub midagi paremat!");
                        System.out.println();
                    }

                    // OTSI TÄIELIKULT SOBIVAID RETSEPTE
                    ArrayList<String> olemasolevad = kylmkapp.getSisu();

                    System.out.println("══════════════════════════════════════════════");

                    int sobivateArv = raamat.kuvasobivadRetseptid(olemasolevad);

                    if (sobivateArv > 0) {
                        System.out.println("SAAD KOHE VALMISTADA:");
                        System.out.println();
                        raamat.kuvasobivadRetseptid(olemasolevad);
                        System.out.println();
                        System.out.println("Kõik koostisosad on olemas – võid kohe alustada!");
                    } else {
                        System.out.println("Kahjuks pole ühtegi retsepti, mida saaksid");
                        System.out.println("praegu täielikult valmistada.");
                    }

                    // OTSI PEAAEGU SOBIVAID RETSEPTE JA KUVA OSTUNIMEKIRI
                    System.out.println();
                    System.out.println("══════════════════════════════════════════════");
                    System.out.println("OSTUNIMEKIRI");
                    System.out.println("Allpool on retseptid, mille jaoks on sul puudu 1-2 koostisosa.");
                    System.out.println("Väike poeskäik lahendab probleemi!");
                    System.out.println();

                    int peaaeguSobivateArv = raamat.kuvaOstunimekiri(olemasolevad);

                    // KUI ÜLDSE MIDAGI EI LEITUD
                    if (sobivateArv == 0 && peaaeguSobivateArv == 0) {
                        System.out.println();
                        System.out.println("══════════════════════════════════════════════");
                        System.out.println("Näib, et tänane seis on keeruline...");
                        System.out.println();
                        System.out.println("Soovitan viimase võimalusena:");
                        System.out.println("  >> " + raamat.juhuslikTudengiretsept() + " <<");
                        System.out.println();
                        System.out.println("...või mine poodi!");
                        System.out.println();
                        System.out.println("Meie retseptiraamatus on olemas retseptid:");
                        raamat.kuvaKoikRetseptid();
                        System.out.println();
                        System.out.println("Proovi mõnda nendest koostisosadest järgmine kord uuesti sisestada!");
                    }

                    break;

                case "2":
                    System.out.println(kylmkapp);
                    break;

                case "3":
                    lisaKasutajaRetsept(scanner, raamat, kylmkapp);
                    break;

                case "4":
                    System.out.println();
                    System.out.println("🎲 Suvaline retsept:");

                    Retsept suvaline = raamat.juhuslikRetsept();

                    if (suvaline == null) {
                        System.out.println("Retseptiraamat on tühi!");
                    } else {
                        System.out.println(suvaline);
                    }

                    break;

                case "0":
                    kaib = false;
                    System.out.println();
                    System.out.println("╔══════════════════════════════════════════════╗");
                    System.out.println("║   Aitah kasutamast! Head isu!                ║");
                    System.out.println("╚══════════════════════════════════════════════╝");
                    break;

                default:
                    System.out.println("Tundmatu valik!");
            }
        }

        scanner.close();
    }

    /**
     Abimeetod kasutaja enda retsepti lisamiseks.
     */
    private static void lisaKasutajaRetsept(Scanner scanner, RetseptiRaamat raamat, Kylmkapp kylmkapp) {
        System.out.println();

        System.out.print("Sisesta retsepti nimi: ");
        String nimi = scanner.nextLine().trim();
        if (nimi.isEmpty()) {
            System.out.println("Nimi puudub – retsepti lisamine tühistati.");
            return;
        }

        System.out.print("Sisesta valmistusaeg minutites: ");
        int aeg = 30;
        try {
            aeg = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Ei suutnud aega lugeda – kasutan vaikeväärtust 30 minutit.");
        }

        System.out.print("Sisesta koostisosad (komadega eraldatult): ");
        String koostisosadSisestus = scanner.nextLine().trim();
        if (koostisosadSisestus.isEmpty()) {
            System.out.println("Koostisosad puuduvad – retsepti ei lisatud.");
            return;
        }

        Retsept uusRetsept = new Retsept(nimi, aeg);

        String[] osad = koostisosadSisestus.split(",");
        for (int i = 0; i < osad.length; i++) {
            String koostisosanimi = osad[i].trim();
            if (!koostisosanimi.isEmpty()) {
                uusRetsept.lisaKoostisosa(koostisosanimi);
            }
        }

        raamat.lisaRetsept(uusRetsept);
        System.out.println();
        System.out.println("Retsept \"" + nimi + "\" lisati!");

        ArrayList<String> puuduvad = uusRetsept.puuduvadKoostisosad(kylmkapp.getSisu());
        if (puuduvad.isEmpty()) {
            System.out.println("Kõik koostisosad on olemas – saad kohe hakata toitu valmistada!");
        } else {
            System.out.println("Selle retsepti jaoks pead ostma:");
            for (int i = 0; i < puuduvad.size(); i++) {
                System.out.println("  -> " + puuduvad.get(i));
            }
        }
    }
}
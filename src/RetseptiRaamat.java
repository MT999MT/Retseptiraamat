import java.util.ArrayList;

/**
 * Klass RetseptiRaamat sisaldab kõiki retsepte.
 * Pakub meetodeid sobivate retseptide leidmiseks.
 */
public class RetseptiRaamat {

    // Kõik retseptid ArrayList-is – mahub nii palju kui vaja
    private ArrayList<Retsept> retseptid;

    // "Vaese tudengi" retseptide nimed
    private String[] tudengiretseptid;

    /**
     * Konstruktor – loob retseptiraamatu ja lisab valmis retseptid.
     */
    public RetseptiRaamat() {
        retseptid = new ArrayList<Retsept>();

        // Tudengi retseptide nimekiri
        tudengiretseptid = new String[8];
        tudengiretseptid[0] = "Makaronid ketšupiga";
        tudengiretseptid[1] = "Leib võiga";
        tudengiretseptid[2] = "Munaputru soola ja pipraga";
        tudengiretseptid[3] = "Keedetud riis sojakastmega";
        tudengiretseptid[4] = "Nuudlid kuubikupuljongi ja munaga";
        tudengiretseptid[5] = "Jogurt müslitükkidega";
        tudengiretseptid[6] = "Võileib juustu ja sinepiga";
        tudengiretseptid[7] = "Külm pitsa (eelmisest õhtust)";

        lisaVaikimisiRetseptid();
    }

    /**
     * Lisab eelnevalt defineeritud klassikalised retseptid.
     */
    private void lisaVaikimisiRetseptid() {

        // Retsept 1: Spagetid bolognese
        Retsept bolognese = new Retsept("Spagetibolognese", 40);
        bolognese.lisaKoostisosa("spagetid");
        bolognese.lisaKoostisosa("hakkliha");
        bolognese.lisaKoostisosa("tomatipasta");
        bolognese.lisaKoostisosa("sibul");
        bolognese.lisaKoostisosa("küüslauk");
        retseptid.add(bolognese);

        // Retsept 2: Klassikaline omlett
        Retsept omlett = new Retsept("Klassikaline omlett", 15);
        omlett.lisaKoostisosa("munad");
        omlett.lisaKoostisosa("piim");
        omlett.lisaKoostisosa("või");
        omlett.lisaKoostisosa("sool");
        retseptid.add(omlett);

        // Retsept 3: Kanasupp
        Retsept kanasupp = new Retsept("Kanasupp köögiviljadega", 60);
        kanasupp.lisaKoostisosa("kana");
        kanasupp.lisaKoostisosa("porgand");
        kanasupp.lisaKoostisosa("kartul");
        kanasupp.lisaKoostisosa("sibul");
        kanasupp.lisaKoostisosa("petersell");
        retseptid.add(kanasupp);

        // Retsept 4: Praetud riis
        Retsept praetudRiis = new Retsept("Praetud riis munaga", 25);
        praetudRiis.lisaKoostisosa("riis");
        praetudRiis.lisaKoostisosa("munad");
        praetudRiis.lisaKoostisosa("sojakaste");
        praetudRiis.lisaKoostisosa("küüslauk");
        praetudRiis.lisaKoostisosa("sibul");
        retseptid.add(praetudRiis);

        // Retsept 5: Pannkoogid
        Retsept pannkoogid = new Retsept("Eesti pannkoogid", 30);
        pannkoogid.lisaKoostisosa("jahu");
        pannkoogid.lisaKoostisosa("munad");
        pannkoogid.lisaKoostisosa("piim");
        pannkoogid.lisaKoostisosa("suhkur");
        pannkoogid.lisaKoostisosa("sool");
        pannkoogid.lisaKoostisosa("või");
        retseptid.add(pannkoogid);

        // Retsept 6: Küüslauguleib
        Retsept kuuslaugu = new Retsept("Küüslauguleib ahjust", 20);
        kuuslaugu.lisaKoostisosa("leib");
        kuuslaugu.lisaKoostisosa("või");
        kuuslaugu.lisaKoostisosa("küüslauk");
        kuuslaugu.lisaKoostisosa("petersell");
        retseptid.add(kuuslaugu);

        // Retsept 7: Pasta juustukastmega
        Retsept pastaJuust = new Retsept("Pasta juustukastmega", 25);
        pastaJuust.lisaKoostisosa("makaronid");
        pastaJuust.lisaKoostisosa("juust");
        pastaJuust.lisaKoostisosa("koor");
        pastaJuust.lisaKoostisosa("või");
        retseptid.add(pastaJuust);

        // Retsept 8: Kartulipuder
        Retsept kartulipuder = new Retsept("Kartulipuder vorstiga", 35);
        kartulipuder.lisaKoostisosa("kartul");
        kartulipuder.lisaKoostisosa("piim");
        kartulipuder.lisaKoostisosa("või");
        kartulipuder.lisaKoostisosa("vorst");
        kartulipuder.lisaKoostisosa("sool");
        retseptid.add(kartulipuder);
    }

    /**
     * Lisab kasutaja enda retsepti raamatusse.

     * r lisatav retsept
     */
    public void lisaRetsept(Retsept r) {
        retseptid.add(r);
    }

    /**
     * Kuvab kõik retseptid, mida saab täielikult valmistada.
     * Tagastab leitud retseptide arvu.

     * olemasolevad külmkapis olevad koostisosad
     */
    public int kuvasobivadRetseptid(ArrayList<String> olemasolevad) {
        int leitud = 0;

        for (int i = 0; i < retseptid.size(); i++) {
            if (retseptid.get(i).onTaielikultKaetud(olemasolevad)) {
                leitud = leitud + 1;
                System.out.println("  " + leitud + ". " + retseptid.get(i).getNimi()
                        + " (valmistusaeg: " + retseptid.get(i).getValmistusaeg() + " min)");
            }
        }

        return leitud;
    }

    /**
     * Kuvab retseptid, mille jaoks puudub 1-2 koostisosa (ostunimekiri).
     * Tagastab leitud retseptide arvu.

     * olemasolevad külmkapis olevad koostisosad

     */
    public int kuvaOstunimekiri(ArrayList<String> olemasolevad) {
        int leitud = 0;

        for (int i = 0; i < retseptid.size(); i++) {
            int puuduvaid = retseptid.get(i).puuduvateArv(olemasolevad);

            // Retsept on "peaaegu sobiv" kui puudub 1 kuni 2 koostisosa
            if (puuduvaid >= 1 && puuduvaid <= 2) {
                leitud = leitud + 1;
                System.out.println("  " + retseptid.get(i).getNimi()
                        + " (" + retseptid.get(i).getValmistusaeg() + " min)");
                System.out.println("  Poest:");

                ArrayList<String> puuduvad = retseptid.get(i).puuduvadKoostisosad(olemasolevad);
                for (int j = 0; j < puuduvad.size(); j++) {
                    System.out.println("    -> " + puuduvad.get(j));
                }
                System.out.println();
            }
        }

        return leitud;
    }

    /**
     * Tagastab juhusliku "vaese tudengi" retsepti nime.
     * Kasutame lihtsat arvutust (ei ole päris juhuslik, aga toimib).

     */
    public String juhuslikTudengiretsept() {
        // Kasutame System.currentTimeMillis() et saada "juhuslikkust"
        int indeks = (int) (System.currentTimeMillis() % tudengiretseptid.length);
        return tudengiretseptid[indeks];
    }


    // Kuvab kõigi retseptide nimed.

    public void kuvaKoikRetseptid() {
        for (int i = 0; i < retseptid.size(); i++) {
            System.out.println("  - " + retseptid.get(i).getNimi());
        }
    }


    // Tagastab retseptide arvu.

    public int getRetseptideArv() {
        return retseptid.size();
    }
}
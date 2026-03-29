import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Klass RetseptiRaamat sisaldab kõiki retsepte ja pakub meetodeid
 * sobivate retseptide leidmiseks ning ostunimekirja koostamiseks.
 * Sisaldab ka "vaese tudengi" juhuslike retseptide süsteemi.
 */
public class RetseptiRaamat {

    // Kõik retseptid, mis on raamatusse lisatud
    private List<Retsept> retseptid;

    // Juhuslike arv-generaator "vaese tudengi" retseptide valimiseks
    private Random random;

    // Vaese tudengi retseptide nimed (kasutatakse siis kui kapis vähe asju)
    private static final String[] TUDENGIRETSEPTID = {
            "Makaronid ketšupiga",
            "Leib võiga",
            "Munaputru soola ja pipraga",
            "Keedetud riis sojakastmega",
            "Nuudlid kuubikupuljongi ja munaga",
            "Jogurt müslitükkidega",
            "Võileib juustu ja sinepiga",
            "Külm pitsa (eelmisest õhtust)"
    };

    /**
     * Konstruktor – loob uue tühja retseptiraamatu ja initsialiseerib retseptid.
     */
    public RetseptiRaamat() {
        this.retseptid = new ArrayList<>();
        this.random = new Random();
        lisaVaikimisiRetseptid(); // Täida raamat valmis retseptidega
    }

    /**
     * Lisab retseptiraamatusse eelnevalt defineeritud klassikalised retseptid.
     * Neid kasutatakse kasutaja koostisosade võrdlemiseks.
     */
    private void lisaVaikimisiRetseptid() {

        // --- Retsept 1: Spagetid bolognese ---
        Retsept bolognese = new Retsept("Spagetid bolognese", 40);
        bolognese.lisaKoostisosa(new Koostisosa("spagetid", 300, "g"));
        bolognese.lisaKoostisosa(new Koostisosa("hakkliha", 400, "g"));
        bolognese.lisaKoostisosa(new Koostisosa("tomatipasta", 2, "spl"));
        bolognese.lisaKoostisosa(new Koostisosa("sibul", 1, "tk"));
        bolognese.lisaKoostisosa(new Koostisosa("küüslauk", 2, "tk"));
        retseptid.add(bolognese);

        // --- Retsept 2: Omlett ---
        Retsept omlett = new Retsept("Klassikaline omlett", 15);
        omlett.lisaKoostisosa(new Koostisosa("munad", 3, "tk"));
        omlett.lisaKoostisosa(new Koostisosa("piim", 50, "ml"));
        omlett.lisaKoostisosa(new Koostisosa("võid", 1, "spl"));
        omlett.lisaKoostisosa(new Koostisosa("sool", 1, "näpuotsatäis"));
        retseptid.add(omlett);

        // --- Retsept 3: Kanasupp ---
        Retsept kanasupp = new Retsept("Kanasupp köögiviljadega", 60);
        kanasupp.lisaKoostisosa(new Koostisosa("kana", 500, "g"));
        kanasupp.lisaKoostisosa(new Koostisosa("porgand", 2, "tk"));
        kanasupp.lisaKoostisosa(new Koostisosa("kartul", 3, "tk"));
        kanasupp.lisaKoostisosa(new Koostisosa("sibul", 1, "tk"));
        kanasupp.lisaKoostisosa(new Koostisosa("petersell", 1, "kamp"));
        retseptid.add(kanasupp);

        // --- Retsept 4: Praetud riis ---
        Retsept praetudRiis = new Retsept("Praetud riis munaga", 25);
        praetudRiis.lisaKoostisosa(new Koostisosa("riis", 200, "g"));
        praetudRiis.lisaKoostisosa(new Koostisosa("munad", 2, "tk"));
        praetudRiis.lisaKoostisosa(new Koostisosa("sojakaste", 2, "spl"));
        praetudRiis.lisaKoostisosa(new Koostisosa("küüslauk", 2, "tk"));
        praetudRiis.lisaKoostisosa(new Koostisosa("sibul", 1, "tk"));
        retseptid.add(praetudRiis);

        // --- Retsept 5: Pannkoogid ---
        Retsept pannkoogid = new Retsept("Eesti pannkoogid", 30);
        pannkoogid.lisaKoostisosa(new Koostisosa("jahu", 200, "g"));
        pannkoogid.lisaKoostisosa(new Koostisosa("munad", 2, "tk"));
        pannkoogid.lisaKoostisosa(new Koostisosa("piim", 400, "ml"));
        pannkoogid.lisaKoostisosa(new Koostisosa("suhkur", 2, "spl"));
        pannkoogid.lisaKoostisosa(new Koostisosa("sool", 1, "näpuotsatäis"));
        pannkoogid.lisaKoostisosa(new Koostisosa("või", 2, "spl"));
        retseptid.add(pannkoogid);

        // --- Retsept 6: Küüslauguleib ---
        Retsept kuuslaugu = new Retsept("Küüslauguleib ahjust", 20);
        kuuslaugu.lisaKoostisosa(new Koostisosa("leib", 1, "tk"));
        kuuslaugu.lisaKoostisosa(new Koostisosa("või", 50, "g"));
        kuuslaugu.lisaKoostisosa(new Koostisosa("küüslauk", 3, "tk"));
        kuuslaugu.lisaKoostisosa(new Koostisosa("petersell", 1, "kamp"));
        retseptid.add(kuuslaugu);

        // --- Retsept 7: Pasta juustukastmega ---
        Retsept pastaJuust = new Retsept("Pasta juustukastmega", 25);
        pastaJuust.lisaKoostisosa(new Koostisosa("makaronid", 300, "g"));
        pastaJuust.lisaKoostisosa(new Koostisosa("juust", 100, "g"));
        pastaJuust.lisaKoostisosa(new Koostisosa("koor", 200, "ml"));
        pastaJuust.lisaKoostisosa(new Koostisosa("või", 1, "spl"));
        retseptid.add(pastaJuust);

        // --- Retsept 8: Kartulipuder ---
        Retsept kartulipuder = new Retsept("Kartulipuder vorstiga", 35);
        kartulipuder.lisaKoostisosa(new Koostisosa("kartul", 500, "g"));
        kartulipuder.lisaKoostisosa(new Koostisosa("piim", 100, "ml"));
        kartulipuder.lisaKoostisosa(new Koostisosa("või", 2, "spl"));
        kartulipuder.lisaKoostisosa(new Koostisosa("vorst", 200, "g"));
        kartulipuder.lisaKoostisosa(new Koostisosa("sool", 1, "näpuotsatäis"));
        retseptid.add(kartulipuder);
    }

    /**
     * Lisab kasutaja enda loodud retsepti raamatusse.
     *
     * @param r lisatav retsept
     */
    public void lisaRetsept(Retsept r) {
        retseptid.add(r);
    }

    /**
     * Tagastab kõik retseptid, mida saab olemasolevate asjadega täielikult valmistada.
     *
     * @param olemasolevad külmkapis olevad koostisosad (nimed)
     * @return list sobivate retseptidega
     */
    public List<Retsept> sobivadRetseptid(List<String> olemasolevad) {
        List<Retsept> sobivad = new ArrayList<>();
        for (Retsept r : retseptid) {
            if (r.onTaielikultKaetud(olemasolevad)) {
                sobivad.add(r);
            }
        }
        return sobivad;
    }

    /**
     * Tagastab retseptid, mida on võimalik valmistada minimaalsete ostudega
     * (puudub kuni 2 koostisosa).
     *
     * @param olemasolevad külmkapis olevad koostisosad
     * @return list peaaegu-sobivate retseptidega
     */
    public List<Retsept> peaaeguSobivadRetseptid(List<String> olemasolevad) {
        List<Retsept> peaaeguSobivad = new ArrayList<>();
        for (Retsept r : retseptid) {
            int puuduvaid = r.puuduvadKoostisosad(olemasolevad).size();
            // Retsept on "peaaegu sobiv" kui puudub 1 kuni 2 koostisosa
            if (puuduvaid >= 1 && puuduvaid <= 2) {
                peaaeguSobivad.add(r);
            }
        }
        return peaaeguSobivad;
    }

    /**
     * Tagastab juhusliku "vaese tudengi" retsepti nime.
     * Kasutatakse siis, kui külmkapis on väga vähe asju.
     *
     * @return juhusliku tudengi retsepti nimi tekstina
     */
    public String juhuslikTudengiretsept() {
        int indeks = random.nextInt(TUDENGIRETSEPTID.length);
        return TUDENGIRETSEPTID[indeks];
    }

    /**
     * Tagastab kõik retseptid raamatust.
     *
     * @return kõigi retseptide list
     */
    public List<Retsept> getRetseptid() {
        return retseptid;
    }

    /**
     * Tagastab retseptide arvu.
     */
    public int getRetseptideArv() {
        return retseptid.size();
    }
}